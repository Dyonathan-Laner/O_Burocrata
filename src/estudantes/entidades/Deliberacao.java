package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Deliberacao extends DocumentoAdministrativo {

    private String texto;

    public Deliberacao(String criador, CodigoCurso codigoCurso, int paginas, String texto) {
        super(criador, codigoCurso, paginas);
        this.texto = texto;
    }
    
    public String getTexto(){
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

        Deliberacao delib = (Deliberacao) obj;

        return Objects.equals(super.getCriador(), delib.getCriador())
                && Objects.equals(super.getCodigoCurso(), delib.getCodigoCurso())
                && super.getPaginas() == delib.getPaginas()
                && Objects.equals(this.getTexto(), delib.getTexto());
                
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += Objects.hashCode(this.getTexto());
        
        return hash;
    }
    
}
