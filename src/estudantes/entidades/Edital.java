package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Edital extends Norma {

    private String[] responsaveis;
    public Edital(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, String[] responsaveis){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }
    
    public String[] getResponsaveis(){
        return responsaveis;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Edital edital = (Edital) obj;

        return Objects.equals(super.getCriador(), edital.getCriador())
                && Objects.equals(super.getCodigoCurso(), edital.getCodigoCurso())
                && super.getPaginas() == edital.getPaginas()
                && super.getNumero() == edital.getNumero()
                && super.getValido() == edital.getValido()
                && Objects.equals(super.getTexto(), edital.getTexto())
                && Objects.equals(this.getResponsaveis(), edital.getResponsaveis());
                
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += super.getNumero();
        if(super.getValido()){hash ++;};
        hash += Objects.hashCode(super.getTexto());
        hash += Arrays.deepHashCode(this.getResponsaveis());
        
        return hash;
    }
}
