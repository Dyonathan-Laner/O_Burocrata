package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class DocumentoAdministrativo extends Documento {
    
    public DocumentoAdministrativo(String criador, CodigoCurso codigoCurso, int paginas){
        super(criador, codigoCurso, paginas);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        DocumentoAdministrativo docAd = (DocumentoAdministrativo) obj;

        return Objects.equals(super.getCriador(), docAd.getCriador())
                && Objects.equals(super.getCodigoCurso(), docAd.getCodigoCurso())
                && super.getPaginas() == docAd.getPaginas();
                
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        
        return hash;
    }
}
