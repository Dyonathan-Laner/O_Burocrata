package estudantes.entidades;

import professor.entidades.*;

/**
 * Classe que representa um Burocrata responsável por organizar e despachar processos
 * na universidade. Gerencia estresse e valida documentos antes do despacho.
 */
public class Burocrata {

    private int estresse = 0;
    private Mesa mesa;
    private Universidade universidade;

    /**
     * Construtor de Burocrata.
     *
     * @param mesa mesa com os processos
     * @param universidade universidade com os montes dos cursos e a secretaria
     */
    public Burocrata(Mesa mesa, Universidade universidade) {
        this.mesa = mesa;
        this.universidade = universidade;
    }
    /** Retorna o nível de estresse do burocrata. */
    public int getEstresse() {
        return estresse;
    }

    /**
     * Executa a lógica de trabalho do burocrata:
     * percorre todos os processos da mesa, valida e adiciona documentos,
     * e despacha os processos para a secretaria.
     */
    public void trabalhar() {
    /**
    * Pega todos os processos da mesa.
    */
    Processo[] processos = mesa.getProcessos();

    for (Processo processo : processos) {
        if (processo == null) continue;

        boolean processoDespachado = false;
        /**
        * Tenta pegar um documento aleatório de cada monte de curso.
        */
        for (CodigoCurso codigo : CodigoCurso.values()) {

            Documento[] documentosDoMonte = universidade.pegarCopiaDoMonteDoCurso(codigo);

            for (Documento doc : documentosDoMonte) {

                int numPaginasAtuais = 0;
                for (Documento document : processo.pegarCopiaDoProcesso()) {
                    numPaginasAtuais += document.getPaginas();
                }
                /**
                * Valida se é possível adicionar o documento no processo.
                */
                if (numPaginasAtuais + doc.getPaginas() <= 250
                        && !contemGraduacaoEPos(processo, doc)
                        && !(doc.getClass() == Ata.class && contemApenasAta(processo))
                        && !contemAdministrativoEAcademico(processo, doc)
                        && atestadoDeMesmaCategoria(processo, doc)
                        && validarPortariaEEdital(processo, doc)
                        && validarDiploma(processo, doc)
                        && validarDestinatarios(processo, doc)) {

                    boolean removido = universidade.removerDocumentoDoMonteDoCurso(doc, codigo);

                    if (removido) {
                        processo.adicionarDocumento(doc);

                        if (contemApenasSubstancialValido(processo)) {
                            universidade.despachar(processo);
                            processoDespachado = true;
                            break;
                        }
                    }
                }
            }
        }

        /**
        * Despacha o processo para a secretaria.
        */
        if (!processoDespachado) {
            universidade.despachar(processo);
        }
    }
}

    /**
     * Aumenta um pouco o estresse do burocrata.
     */
    public void estressar() {
        estresse += 1;
    }

    /**
     * Aumenta bastante o estresse do burocrata.
     */
    public void estressarMuito() {
        estresse += 10;
    }

    /**
     * Retorna false se Caso o Documento for adicionado no Processo, ele terá
     * Graduação junto com pós.
     */
    public static boolean contemGraduacaoEPos(Processo processo, Documento documento) {
        boolean temGraduacao = false;
        boolean temPos = false;

        /**
        * Verifica se adicionar o documento ao processo causaria mistura de
        * documentos de Graduação e Pós-Graduação.
        *
        * @param processo o processo que receberia o documento
        * @param documento o documento a ser verificado
        * @return (@Code true se haveria mistura de Graduação e Pós-Graduação, false caso contrário
        */
        for (Documento doc : processo.pegarCopiaDoProcesso()) {
            if (doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_SOFTWARE)
                    || doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA)
                    || doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA)) {

                /**
                 * Indica que esse processo tem um documento de Pós-Graduação.
                 */
                temPos = true;
            } else {
                /**
                 * Indica que esse processo tem um documento de Graduação.
                 */
                temGraduacao = true;
            }

        }
        if (documento.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_SOFTWARE)
                || documento.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA)
                || documento.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA)) {

            /**
             * Indica que esse Documento é de Pós-Graduação.
             */
            temPos = true;
        } else {
            /**
             * Indica que esse Documento é de Graduação.
             */
            temGraduacao = true;
        }

        /**
         * Retorna true se o processo, for ter um Documento de Graduação e um de
         * pós-graduação ao mesmo tempo.
         */
        return temGraduacao && temPos;
    }
    /**
     * Verifica se o processo contém apenas documentos do tipo Ata.
     *
     * @param processo processo a ser verificado
     * @return (@Code true se contém apenas Atas, (@Code false) caso contrário
     */
    public static boolean contemApenasAta(Processo processo) {
        for (Documento doc : processo.pegarCopiaDoProcesso()) {
            if (doc.getClass() != Ata.class) {
                return false;
            }
        }
        return true;
    }
    /**
     * Verifica se há mistura de documentos administrativos e acadêmicos.
     *
     * @param processo processo a ser verificado
     * @param documento documento a ser adicionado
     * @return (@Code true se houver mistura, (@Code false) caso contrário
     */
    public static boolean contemAdministrativoEAcademico(Processo processo, Documento documento) {
        boolean temAdministrativo = false;
        boolean temAcademico = false;

        for (Documento doc : processo.pegarCopiaDoProcesso()) {
            if (doc instanceof DocumentoAcademico) {
                temAcademico = true;
            } else if (doc instanceof DocumentoAdministrativo) {
                temAdministrativo = true;
            }
        }
        if (documento instanceof DocumentoAcademico) {
            temAcademico = true;
        } else if (documento instanceof DocumentoAdministrativo) {
            temAdministrativo = true;
        }
        return temAcademico && temAdministrativo;
    }
    
    /**
     * Verifica se atestados possuem a mesma categoria.
     *
     * @param processo processo a ser verificado
     * @param documento documento a ser adicionado
     * @return (@Code true se todas as categorias coincidem, (@Code false) caso contrário
     */
    public static boolean atestadoDeMesmaCategoria(Processo processo, Documento documento) {
        if (documento.getClass() == Atestado.class) {
            Atestado ate1 = (Atestado) documento;
            for (Documento doc : processo.pegarCopiaDoProcesso()) {
                if (doc.getClass() == Atestado.class) {
                    Atestado ate2 = (Atestado) doc;
                    if (!(ate1.getCategoria().equals(ate2.getCategoria()))) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
    
    /**
     * Verifica se o Diploma é válido no processo.
     *
     * @param processo processo a ser verificado
     * @param documento documento a ser adicionado
     * @return (@Code true se o diploma pode ser adicionado, (@Code false) caso contrário
     */
    public static boolean validarDiploma(Processo processo, Documento documento) {
        if (documento.getClass() == Diploma.class) {
            for (Documento doc : processo.pegarCopiaDoProcesso()) {
                if (!(doc instanceof Certificado) && doc.getClass() != Ata.class) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Verifica se portarias e editais são válidos.
     *
     * @param processo processo a ser verificado
     * @param doc documento a ser adicionado
     * @return (@Code true) se válidos, (@Code false) caso contrário
     */
    public static boolean validarPortariaEEdital(Processo processo, Documento doc) {
        if ((doc instanceof Norma) && doc.getClass() != Norma.class) {
            Norma norma = (Norma) doc;
            if (norma.getValido() && norma.getPaginas() >= 100) {
                Documento[] docs = processo.pegarCopiaDoProcesso();
                if (docs.length > 0) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Verifica compatibilidade dos destinatários de circulares e ofícios.
     *
     * @param processo processo a ser verificado
     * @param documento documento a ser adicionado
     * @return (@Code true) se todos os destinatários são compatíveis, (@Code false) caso contrário
     */
    public static boolean validarDestinatarios(Processo processo, Documento documento) {
        if ((documento instanceof Deliberacao) && documento.getClass() != Deliberacao.class) {
            String[] dest;
            if (documento.getClass() == Circular.class) {
                Circular circ = (Circular) documento;
                dest = circ.getDestinatarios();
            } else {
                Oficio oficio = (Oficio) documento;
                dest = new String[]{oficio.getDestinatario()};
            }

            for (Documento doc : processo.pegarCopiaDoProcesso()) {
                if ((doc instanceof Deliberacao) && doc.getClass() != Deliberacao.class) {

                    if (doc.getClass() == Circular.class) {
                        Circular circ = (Circular) doc;
                        boolean temIgual = false;

                        for (String destPro : circ.getDestinatarios()) {
                            for (String destDoc : dest) {
                                if (destPro.equals(destDoc)) {
                                    temIgual = true;
                                }
                            }
                        }
                        if (!temIgual) {
                            
                            return false;
                        }

                    } else {
                        Oficio oficio = (Oficio) doc;
                        boolean temIgual = false;
                        for (String destDoc : dest) {
                            if (destDoc.equals(oficio.getDestinatario())) {
                                temIgual = true;
                            }
                        }
                        if (!temIgual) {
                           
                            return false;
                        }
                    }

                }
            }
        }
        return true;

    }
    
    /**
     * Verifica se o processo contém apenas um documento substancial válido (Norma).
     *
     * @param processo processo a ser verificado
     * @return (@Code true) se o processo contém apenas uma Norma válida, (@Code false) caso contrário
     */
    public static boolean contemApenasSubstancialValido(Processo processo){
        Documento[] docs = processo.pegarCopiaDoProcesso();
        if(docs.length == 1){
            Documento doc = docs[0];
            if((doc instanceof Norma) && doc.getClass() != Norma.class){
                Norma norma = (Norma)doc;
                if(norma.getValido()){
                    return true;
                }
            }
        }
        return false;
        
    }
}
