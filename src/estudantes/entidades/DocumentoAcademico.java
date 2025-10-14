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
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        DocumentoAcademico docAca = (DocumentoAcademico) obj;

        return Objects.equals(super.getCriador(), docAca.getCriador())
                && Objects.equals(super.getCodigoCurso(), docAca.getCodigoCurso())
                && super.getPaginas() == docAca.getPaginas()
                && this.autenticacao == docAca.autenticacao;
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)this.autenticacao / 100;
        
        return hash;
    }
    
}
