package estudantes.entidades;

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

}
