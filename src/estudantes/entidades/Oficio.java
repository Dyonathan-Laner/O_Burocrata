package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Oficio extends Deliberacao {

    private String destinatario;
    
    public Oficio(String criador, CodigoCurso codigoCurso, int paginas, String texto, String destinatario){
        super(criador, codigoCurso, paginas, texto);
        this.destinatario = destinatario;
        
    }
    public String getDestinatario(){
        return destinatario;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Oficio ofi = (Oficio) obj;

        return Objects.equals(super.getCriador(), ofi.getCriador())
                && Objects.equals(super.getCodigoCurso(), ofi.getCodigoCurso())
                && super.getPaginas() == ofi.getPaginas()
                && Objects.equals(super.getTexto(), ofi.getTexto())
                && Objects.equals(this.getDestinatario(), ofi.getDestinatario());
                
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += Objects.hashCode(super.getTexto());
        hash += Objects.hashCode(this.getDestinatario());
        
        return hash;
    }
    
}
