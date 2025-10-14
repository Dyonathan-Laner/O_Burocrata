package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

public class Ata extends Documento {

    private int numero;
    private String texto;
    private String[] presentes;

    public Ata(String criador, CodigoCurso codigoCurso, int paginas, int numero, String texto, String[] presentes) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Ata ata = (Ata) obj;

        return Objects.equals(super.getCriador(), ata.getCriador())
                && Objects.equals(super.getCodigoCurso(), ata.getCodigoCurso())
                && super.getPaginas() == ata.getPaginas()
                && this.numero == ata.numero
                && Objects.equals(this.texto, ata.texto)
                && Objects.equals(this.presentes, ata.presentes);
    }

    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += this.numero;
        hash += Objects.hashCode(this.texto);
        hash += Arrays.deepHashCode(this.presentes);
        
        return hash;
    }

    
}
