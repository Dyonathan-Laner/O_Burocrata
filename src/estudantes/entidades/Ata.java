package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa uma ata.
 */
public class Ata extends Documento {
    
    /** Número da ata. */
    private int numero;
    
    /** Texto da ata. */   
    private String texto;
    
    /** Lista de presentes. */
    private String[] presentes;

     /**
     * Cria uma nova ata.
     */
    public Ata(String criador, CodigoCurso codigoCurso, int paginas, int numero, String texto, String[] presentes) {
        super(criador, codigoCurso, paginas);
        this.numero = numero;
        this.texto = texto;
        this.presentes = presentes;
    }
    /** @return número da ata */
    public int getNumero() {
        return numero;
    }
     /** @return texto da ata */
    public String getTexto() {
        return texto;
    }
    /** @return presentes da ata */
    public String[] getPresentes() {
        return presentes;
    }
    /** Compara se duas atas são iguais. */
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

    /** Gera um hashCode para a ata. */
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
