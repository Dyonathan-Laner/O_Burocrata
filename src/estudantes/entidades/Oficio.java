package estudantes.entidades;

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
    
}
