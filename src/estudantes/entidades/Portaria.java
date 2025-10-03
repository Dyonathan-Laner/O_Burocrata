package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Portaria extends Norma {

    private int anoInicio;
    
    public Portaria(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, int anoInicio){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }
    public int getAnoInicio(){
        return anoInicio;
    }
}
