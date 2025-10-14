package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Registro extends DocumentoAcademico {

    private String estudante;
    private long matricula;

    public Registro(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula) {
        super(criador, codigoCurso, paginas, autenticacao);
        this.estudante = estudante;
        this.matricula = matricula;
    }

    public String getEstudante() {
        return estudante;
    }

    public long getMatricula() {
        return matricula;
    }
    
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
