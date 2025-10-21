package estudantes.entidades;

import professor.entidades.*;

/**
 * Classe que traz a lógica do algoritmo de organização e despacho de processos.
 * <br><br>
 * Você pode incluir novos atributos e métodos nessa classe para criar lógicas
 * mais complexas para o gerenciamento da organização e despacho de processos,
 * mas esses <strong>atributos e métodos devem ser todos privados</strong> e
 * eles não serão invocados diretamente pelo simulador.
 * <br><br>
 * Os únicos métodos públicos devem ser: getEstresse, trabalhar, estressar e
 * estressarMuito.
 *
 * @author coloque os nomes dos autores aqui
 */
public class Burocrata {

    private int estresse = 0;
    private Mesa mesa;
    private Universidade universidade;

    /**
     * Construtor de Burocrata.
     *
     * @param m mesa com os processos
     * @param u universidade com os montes dos cursos e a secretaria
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
     * Executa a lógica de criação e despacho dos processos.
     * <br><br>
     * Esse método é o único método de controle invocado durante a simulação da
     * universidade.
     * <br><br>
     * Aqui podem ser feitas todas as verificações sobre os documentos nos
     * montes dos cursos e dos processos abertos na mesa do Burocrata. A partir
     * dessas informações, você pode colocar documentos nos processos abertos e
     * despachar os processos para a secretaria acadêmica.
     * <br><br>
     * Cuidado com a complexidade do seu algoritmo, porque se ele demorar muito
     * serão criados menos documentos na sua execução e sua produtividade geral
     * vai cair.
     * <br><br>
     * Esse método será chamado a cada 100 milissegundos pelo simulador da
     * universidade.
     * <br><br>
     * <strong>O burocrata não pode manter documentos com ele</strong> depois
     * que o método trabalhar terminar de executar, ou seja, você deve devolver
     * para os montes dos cursos todos os documentos que você removeu dos montes
     * dos cursos.
     *
     * @see professor.entidades.Universidade#despachar(Processo)
     * @see
     * professor.entidades.Universidade#removerDocumentoDoMonteDoCurso(estudantes.entidades.Documento,
     * professor.entidades.CodigoCurso)
     * @see
     * professor.entidades.Universidade#devolverDocumentoParaMonteDoCurso(estudantes.entidades.Documento,
     * professor.entidades.CodigoCurso)
     */
    public void trabalhar() {
        /**
         * Pega todos os processos da mesa
         */
        Processo[] processos = mesa.getProcessos();
        for (Processo processo : processos) {
            if (processo == null) {
                continue;
            }
            
            boolean processoDespachado = false;

            /**
             * Tenta pegar um documento aleatório de cada monte de curso
             */
            for (CodigoCurso codigo : CodigoCurso.values()) {

                Documento[] documentosDoMonte = universidade.pegarCopiaDoMonteDoCurso(codigo);

                for (Documento doc : documentosDoMonte) {

                    int numPaginasAtuais = 0;
                    for (Documento document : processo.pegarCopiaDoProcesso()) {
                        numPaginasAtuais += document.getPaginas();
                    }

                    if (numPaginasAtuais + doc.getPaginas() <= 250) {

                        if (!contemGraduacaoEPos(processo, doc)) {

                            if (!(doc.getClass() == Ata.class && contemApenasAta(processo))) {

                                if (!contemAdministrativoEAcademico(processo, doc)) {

                                    if (atestadoDeMesmaCategoria(processo, doc)) {

                                        if (validarPortariaEEdital(processo, doc)) {
                                            
                                            if (validarDiploma(processo, doc)) {

                                                if (validarDestinatarios(processo, doc)) {
                                                boolean removido = universidade.removerDocumentoDoMonteDoCurso(doc, codigo);
                                                if (removido) {
                                                    processo.adicionarDocumento(doc);
                                                    
                                                    if(contemApenasSubstancialValido(processo)){
                                                        universidade.despachar(processo);
                                                        processoDespachado = true;
                                                        break;
                                                    }
                                                }
                                                
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }

                    }

                }
            }
            if(!processoDespachado){
            /**
             * Despacha o processo para a secretaria
             */
            universidade.despachar(processo);
            }
        }

    }

    /**
     * Aumenta um pouco o estresse do burocrata
     */
    public void estressar() {
        estresse += 1;
    }

    /**
     * Aumenta bastante o estresse do burocrata
     */
    public void estressarMuito() {
        estresse += 10;
    }

    /**
     * Retorna false se Caso o Documento for adicionado no Processo, ele terá
     * Graduação junto com pós
     */
    private static boolean contemGraduacaoEPos(Processo processo, Documento documento) {
        boolean temGraduacao = false;
        boolean temPos = false;

        /**
         * Verifica os Documentos que já estão no processo
         */
        for (Documento doc : processo.pegarCopiaDoProcesso()) {
            if (doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_SOFTWARE)
                    || doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA)
                    || doc.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA)) {

                /**
                 * Indica que esse processo tem um documento de Pós-Graduação
                 */
                temPos = true;
            } else {
                /**
                 * Indica que esse processo tem um documento de Graduação
                 */
                temGraduacao = true;
            }

        }
        if (documento.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_SOFTWARE)
                || documento.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA)
                || documento.getCodigoCurso().equals(CodigoCurso.POS_GRADUACAO_ENGENHARIA)) {

            /**
             * Indica que esse Documento é de Pós-Graduação
             */
            temPos = true;
        } else {
            /**
             * Indica que esse Documento é de Graduação
             */
            temGraduacao = true;
        }

        /**
         * Retorna true se o processo, for ter um Documento de Graduação e um de
         * pós-graduação ao mesmo tempo
         */
        return temGraduacao && temPos;
    }
    /** Verifica se o processo contém apenas atas */
    private static boolean contemApenasAta(Processo processo) {
        for (Documento doc : processo.pegarCopiaDoProcesso()) {
            if (doc.getClass() != Ata.class) {
                return false;
            }
        }
        return true;
    }
    /** Verifica se há documentos administrativos e acadêmicos juntos */
    private static boolean contemAdministrativoEAcademico(Processo processo, Documento documento) {
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
    
    /** Verifica se os atestados têm a mesma categoria */
    private static boolean atestadoDeMesmaCategoria(Processo processo, Documento documento) {
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
    
    /** Verifica se o diploma é válido no processo */
    private static boolean validarDiploma(Processo processo, Documento documento) {
        if (documento.getClass() == Diploma.class) {
            for (Documento doc : processo.pegarCopiaDoProcesso()) {
                if (!(doc instanceof Certificado) && doc.getClass() != Ata.class) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /** Verifica se portarias e editais são válidos */
    private static boolean validarPortariaEEdital(Processo processo, Documento doc) {
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
    /** Verifica se os destinatários de circulares e ofícios são compatíveis */
    private static boolean validarDestinatarios(Processo processo, Documento documento) {
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
    
    /** Verifica se o processo contém apenas um documento substancial e válido */
    private static boolean contemApenasSubstancialValido(Processo processo){
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
