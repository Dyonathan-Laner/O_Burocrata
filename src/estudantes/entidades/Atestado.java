package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Atestado extends Registro {
    private String descricao;
    private String categoria;
    
    public Atestado(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String categoria){
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }
    
    
}
