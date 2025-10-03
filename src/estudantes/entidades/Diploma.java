package estudantes.entidades;

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
    
}
