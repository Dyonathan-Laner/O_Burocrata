package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Diploma extends Certificado {

    private String habilitacao;
    
    public Diploma(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String habilitacao){
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula, descricao);
        this.habilitacao = habilitacao;
    }

    public String getHabilitacao() {
        return habilitacao;
    }
    
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
