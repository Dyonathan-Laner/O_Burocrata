package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Norma extends DocumentoAdministrativo {
    private int numero;
    private boolean valido;
    private String texto;
    
    public Norma(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto){
        super(criador, codigoCurso, paginas);
        this.numero = numero; 
        this.valido = valido;
        this.texto = texto;
        
    }

    public int getNumero() {
        return numero;
    }

    public boolean getValido() {
        return valido;
    }

    public String getTexto() {
        return texto;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Norma norma = (Norma) obj;

        return Objects.equals(super.getCriador(), norma.getCriador())
                && Objects.equals(super.getCodigoCurso(), norma.getCodigoCurso())
                && super.getPaginas() == norma.getPaginas()
                && this.getNumero() == norma.getNumero()
                && this.getValido() == norma.getValido()
                && Objects.equals(this.getTexto(), norma.getTexto());
                
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += this.getNumero();
        if(this.getValido()){hash ++;};
        hash += Objects.hashCode(this.getTexto());
        
        return hash;
    }
}
