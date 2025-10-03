package estudantes.entidades;

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
    
}
