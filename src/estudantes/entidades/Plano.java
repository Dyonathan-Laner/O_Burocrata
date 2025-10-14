package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Plano extends DocumentoAcademico {
    private String responsavel;
    private String[] planejamento;
    
    public Plano(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String responsavel, String[] planejamento){
        super(criador, codigoCurso, paginas, autenticacao);
        this.responsavel = responsavel;
        this.planejamento = planejamento;
        
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String[] getPlanejamento() {
        return planejamento;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Plano plano = (Plano) obj;

        return Objects.equals(super.getCriador(), plano.getCriador())
                && Objects.equals(super.getCodigoCurso(), plano.getCodigoCurso())
                && super.getPaginas() == plano.getPaginas()
                && super.getAutenticacao() == plano.getAutenticacao()
                && Objects.equals(this.getPlanejamento(), plano.getPlanejamento())
                && Objects.equals(this.getResponsavel(), plano.getResponsavel());
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)super.getAutenticacao() / 100;
        hash += Arrays.deepHashCode(this.planejamento);
        hash += Objects.hashCode(this.responsavel);
        
        return hash;
    }
    
}
