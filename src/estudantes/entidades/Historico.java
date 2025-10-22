package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa um histórico acadêmico de um estudante, contendo coeficiente e componentes cursados.
 * Estende a classe Registro.
 */
public class Historico extends Registro {
    /** Coeficiente do estudante no histórico. */
    private double coeficiente;
    /** Componentes cursados pelo estudante. */
    private String[] componentes;
    
    /**
     * Construtor da classe Historico.
     *
     * @param criador criador do documento
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do histórico
     * @param autenticacao código de autenticação do documento
     * @param estudante nome do estudante
     * @param matricula número de matrícula do estudante
     * @param coeficiente coeficiente de rendimento
     * @param componentes componentes curriculares do histórico
     */
    public Historico(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, double coeficiente, String[] componentes){
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }
    /**
     * Retorna o coeficiente de rendimento do estudante.
     *
     * @return coeficiente
     */
    public double getCoeficiente() {
        return coeficiente;
    }
    /**
     * Retorna os componentes curriculares do histórico.
     *
     * @return array de componentes
     */
    public String[] getComponentes() {
        return componentes;
    }
    
    /**
     * Compara este histórico com outro objeto para verificar se são iguais.
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

        Historico hist = (Historico) obj;

        return Objects.equals(super.getCriador(), hist.getCriador())
                && Objects.equals(super.getCodigoCurso(), hist.getCodigoCurso())
                && super.getPaginas() == hist.getPaginas()
                && super.getAutenticacao() == hist.getAutenticacao()
                && super.getMatricula() == hist.getMatricula()
                && Objects.equals(super.getEstudante(), hist.getEstudante())
                && this.getCoeficiente() == hist.getCoeficiente()
                && Objects.equals(this.getComponentes(), hist.getComponentes());
    }
    /**
     * Retorna o hashCode do histórico.
     *
     * @return valor hash do histórico
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)super.getAutenticacao() / 100;
        hash += Objects.hashCode(super.getEstudante());
        hash += (int) super.getMatricula()/100;
        hash += (int) this.getCoeficiente()/100;
        hash += Objects.hashCode(this.getComponentes());
        
        return hash;
    }
    
}
