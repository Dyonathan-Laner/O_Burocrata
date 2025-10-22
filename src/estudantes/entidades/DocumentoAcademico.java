package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa um documento acadêmico com código de autenticação.
 * Estende a classe Documento.
 */
public class DocumentoAcademico extends Documento {
    /** Código de autenticação do documento acadêmico. */
    private long autenticacao;
    
    /**
     * Construtor da classe DocumentoAcademico.
     *
     * @param criador criador do documento
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do documento
     * @param autenticacao código de autenticação do documento
     */
    public DocumentoAcademico(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao) {
        super(criador, codigoCurso, paginas);
        this.autenticacao = autenticacao;
    }
    /**
     * Retorna o código de autenticação do documento.
     *
     * @return código de autenticação
     */
    public long getAutenticacao() {
        return autenticacao;
    }
    /**
     * Compara este documento acadêmico com outro objeto para verificar se são iguais.
     *
     * @param obj objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        DocumentoAcademico docAca = (DocumentoAcademico) obj;

        return Objects.equals(super.getCriador(), docAca.getCriador())
                && Objects.equals(super.getCodigoCurso(), docAca.getCodigoCurso())
                && super.getPaginas() == docAca.getPaginas()
                && this.autenticacao == docAca.autenticacao;
    }
    /**
     * Retorna o hashCode do documento acadêmico.
     *
     * @return valor hash do documento acadêmico
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)this.autenticacao / 100;
        
        return hash;
    }
    
}
