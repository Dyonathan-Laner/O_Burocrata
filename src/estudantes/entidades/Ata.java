
package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Ata extends Documento {
    private int numero;
    private String texto;
    private String[] presentes;
    
    public Ata(String criador, CodigoCurso codigoCurso, int  paginas, int numero, String texto, String[] presentes){
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.texto = texto;
        this.presentes = presentes;
    }

    public int getNumero() {
        return numero;
    }

    public String getTexto() {
        return texto;
    }

    public String[] getPresentes() {
        return presentes;
    }
    
}
