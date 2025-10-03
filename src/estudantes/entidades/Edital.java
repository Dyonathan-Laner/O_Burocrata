package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Edital extends Norma {

    private String[] responsaveis;
    public Edital(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, String[] responsaveis){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }
    
    public String[] getResponsaveis(){
        return responsaveis;
    }
}
