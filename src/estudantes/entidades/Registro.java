package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa um registro acadêmico de um estudante.
 * Estende a classe DocumentoAcademico.
 */
public class Registro extends DocumentoAcademico {
    /** Nome do estudante relacionado ao registro. */
    private String estudante;
    /** Matrícula do estudante. */
    private long matricula;

    /**
     * Construtor da classe Registro.
     *
     * @param criador criador do registro
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do registro
     * @param autenticacao código de autenticação do documento
     * @param estudante nome do estudante
     * @param matricula matrícula do estudante
     */
    public Registro(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }
     /**
     * Retorna o nome do estudante do registro.
     *
     * @return nome do estudante
     */
    public String getEstudante() {
        return estudante;
    }
    /**
     * Retorna a matrícula do estudante.
     *
     * @return matrícula
     */
    public long getMatricula() {
        return matricula;
    }
    /**
     * Compara este registro com outro objeto para verificar se são iguais.
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

        Registro regi = (Registro) obj;

        return Objects.equals(super.getCriador(), regi.getCriador())
                && Objects.equals(super.getCodigoCurso(), regi.getCodigoCurso())
                && super.getPaginas() == regi.getPaginas()
                && super.getAutenticacao() == regi.getAutenticacao()
                && this.getMatricula() == regi.getMatricula()
                && Objects.equals(this.getEstudante(), regi.getEstudante());
    }
    /**
     * Retorna o hashCode do registro.
     *
     * @return valor hash do registro
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)super.getAutenticacao() / 100;
        hash += Objects.hashCode(this.getEstudante());
        hash += (int) this.getMatricula()/100;
        
        return hash;
    }

}
