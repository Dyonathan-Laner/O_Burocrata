package estudantes.entidades;

import professor.entidades.CodigoCurso;

public class Historico extends Registro {
    private double coeficiente;
    private String[] componentes;
    
    public Historico(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String estudante, long matricula, double coeficiente, String[] componentes){
        super(criador, codigoCurso, paginas, autenticacao, estudante, matricula);
        this.coeficiente = coeficiente;
        this.componentes = componentes;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public String[] getComponentes() {
        return componentes;
    }
    
}
