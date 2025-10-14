package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Portaria extends Norma {

    private int anoInicio;
    
    public Portaria(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, int anoInicio){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }
    public int getAnoInicio(){
        return anoInicio;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Portaria portaria = (Portaria) obj;

        return Objects.equals(super.getCriador(), portaria.getCriador())
                && Objects.equals(super.getCodigoCurso(), portaria.getCodigoCurso())
                && super.getPaginas() == portaria.getPaginas()
                && super.getNumero() == portaria.getNumero()
                && super.getValido() == portaria.getValido()
                && Objects.equals(super.getTexto(), portaria.getTexto())
                && this.getAnoInicio() == portaria.getAnoInicio();
                
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += super.getNumero();
        if(super.getValido()){hash ++;};
        hash += Objects.hashCode(super.getTexto());
        hash += this.getAnoInicio();
        
        return hash;
    }
}
