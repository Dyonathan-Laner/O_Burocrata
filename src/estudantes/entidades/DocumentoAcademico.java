package estudantes.entidades;

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
    
    
}
