package estudantes.entidades;

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
}
