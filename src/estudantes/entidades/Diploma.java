package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa um diploma de um estudante, contendo informações de habilitação.
 * Estende a classe Certificado.
 */
public class Diploma extends Certificado {
    
    /** Habilitação associada ao diploma. */
    private String habilitacao;
    
    /**
     * Construtor da classe Diploma.
     *
     * @param criador criador do documento
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do diploma
     * @param autenticacao código de autenticação do diploma
     * @param estudante nome do estudante
     * @param matricula número de matrícula do estudante
     * @param descricao descrição do diploma
     * @param habilitacao habilitação correspondente ao diploma
     */
    public Diploma(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String habilitacao){
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }
    
    /**
     * Retorna a habilitação do diploma.
     *
     * @return habilitação do diploma
     */
    public String getHabilitacao() {
        return habilitacao;
    }
    
    /**
     * Compara este diploma com outro objeto para verificar se são iguais.
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

        Diploma dip = (Diploma) obj;

        return Objects.equals(super.getCriador(), dip.getCriador())
                && Objects.equals(super.getCodigoCurso(), dip.getCodigoCurso())
                && super.getPaginas() == dip.getPaginas()
                && super.getAutenticacao() == dip.getAutenticacao()
                && super.getMatricula() == dip.getMatricula()
                && Objects.equals(super.getEstudante(), dip.getEstudante())
                && Objects.equals(super.getDescricao(), dip.getDescricao())
                && Objects.equals(this.getHabilitacao(), dip.getHabilitacao());
    }
    
    /**
     * Retorna o hashCode do diploma.
     *
     * @return valor hash do diploma
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)super.getAutenticacao() / 100;
        hash += Objects.hashCode(super.getEstudante());
        hash += (int) super.getMatricula()/100;
        hash += Objects.hashCode(super.getDescricao());
        hash += Objects.hashCode(this.getHabilitacao());
        
        return hash;
    }
}
