package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
* Representa um certificado emitido para um estudante, contendo informações
* sobre autenticação, matrícula e descrição.
*/
public class Certificado extends Registro {
    /** Descrição do certificado. */
    private String descricao;
    
    /**
     * Construtor do certificado.
     * 
     * @param criador autor do documento
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do documento
     * @param autenticacao número de autenticação
     * @param estudante nome do estudante
     * @param matricula número de matrícula do estudante
     * @param descricao descrição do certificado
     */
    public Certificado(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao){
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
    }
    /** Retorna a descrição do certificado. */
    public String getDescricao(){
        return descricao;
    }
    /** Compara o objeto passado é igual a esse certificado.
    *
     * @param obj objeto a ser comparado
     * @return true se os documentos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Certificado certi = (Certificado) obj;

        return Objects.equals(super.getCriador(), certi.getCriador())
                && Objects.equals(super.getCodigoCurso(), certi.getCodigoCurso())
                && super.getPaginas() == certi.getPaginas()
                && super.getAutenticacao() == certi.getAutenticacao()
                && super.getMatricula() == certi.getMatricula()
                && Objects.equals(super.getEstudante(), certi.getEstudante())
                && Objects.equals(this.getDescricao(), certi.getDescricao());
    }
    /** Gera um hashCode com base nos atributos do certificado. */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)super.getAutenticacao() / 100;
        hash += Objects.hashCode(super.getEstudante());
        hash += (int) super.getMatricula()/100;
        hash += Objects.hashCode(this.getDescricao());
        
        return hash;
    }
}
