package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Circular extends Deliberacao {
    private String[] destinatarios;
    
    public Circular(String criador, CodigoCurso codigoCurso, int paginas, String texto, String[] destinatarios){
        super(criador, codigoCurso, paginas, texto);
        this.destinatarios = destinatarios;   
    }
    
    public String[] getDestinatarios(){
        return destinatarios;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Circular circ = (Circular) obj;

        return Objects.equals(super.getCriador(), circ.getCriador())
                && Objects.equals(super.getCodigoCurso(), circ.getCodigoCurso())
                && super.getPaginas() == circ.getPaginas()
                && Objects.equals(super.getTexto(), circ.getTexto())
                && Objects.equals(this.getDestinatarios(), circ.getDestinatarios());
                
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += Objects.hashCode(super.getTexto());
        hash += Arrays.deepHashCode(this.getDestinatarios());
        
        return hash;
    }
}
