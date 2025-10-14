package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Historico extends Registro {
    private double coeficiente;
    private String[] componentes;
    
    public Historico(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, double coeficiente, String[] componentes){
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public String[] getComponentes() {
        return componentes;
    }
    
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
