package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class DocumentoAcademico extends Documento {

    private long autenticacao;

    public DocumentoAcademico(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao) {
        super(criador, codigoCurso, paginas);
        this.autenticacao = autenticacao;
    }
    public long getAutenticacao() {
        return autenticacao;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DocumentoAcademico) || !super.equals(obj)) {
            return false;
        }

        DocumentoAcademico docAca = (DocumentoAcademico) obj;

        return this.autenticacao == docAca.autenticacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        
        hash = 7 * hash + Objects.hashCode(super.getCriador());
        hash = 7 * hash + Objects.hashCode(super.getCodigoCurso());
        hash = 7 * hash + super.getPaginas();
        hash = 7 * hash + (int)this.autenticacao;
        
        return hash;
    }
    
}
