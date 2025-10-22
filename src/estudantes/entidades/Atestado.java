package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Classe que representa um atestado.
 */
public class Atestado extends Registro {
    /** Descrição do atestado. */
    private String descricao;
    /** Categoria do atestado. */
    private String categoria;
    
    /**
    * Construtor do atestado.
    */
    public Atestado(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, String descricao, String categoria){
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.descricao = descricao;
        this.categoria = categoria;
    }
    /** Retorna a descrição do atestado. */
    public String getDescricao() {
        return descricao;
    }
    /** Retorna a categoria do atestado. */
    public String getCategoria() {
        return categoria;
    }
    /** Compara se dois atestados são iguais. */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Atestado ate = (Atestado) obj;

        return Objects.equals(super.getCriador(), ate.getCriador())
                && Objects.equals(super.getCodigoCurso(), ate.getCodigoCurso())
                && super.getPaginas() == ate.getPaginas()
                && super.getAutenticacao() == ate.getAutenticacao()
                && super.getMatricula() == ate.getMatricula()
                && Objects.equals(super.getEstudante(), ate.getEstudante())
                && Objects.equals(this.getDescricao(), ate.getDescricao())
                && Objects.equals(this.getCategoria(), ate.getCategoria());
    }
    /** Gera um hashCode para o atestado. */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)super.getAutenticacao() / 100;
        hash += Objects.hashCode(super.getEstudante());
        hash += (int) super.getMatricula()/100;
        hash += Objects.hashCode(this.getDescricao());
        hash += Objects.hashCode(this.getCategoria());
        
        return hash;
    }
    
    
}
