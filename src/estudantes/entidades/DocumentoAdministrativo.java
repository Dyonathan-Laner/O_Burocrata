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
        if (obj == null || !(obj instanceof DocumentoAdministrativo)) {
            return false;
        }

        DocumentoAdministrativo docAdmin = (DocumentoAdministrativo) obj;

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        
        hash = 7 * hash + Objects.hashCode(super.getCriador());
        hash = 7 * hash + Objects.hashCode(super.getCodigoCurso());
        hash = 7 * hash + super.getPaginas();
        return hash;
    }
}
