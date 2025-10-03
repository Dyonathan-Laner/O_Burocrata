package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Classe que representa um documento genérico.
 * <br><br>
 * <strong>Seu trabalho começa aqui...</strong>
 *
 * @author coloque os nomes dos autores aqui
 */
public abstract class Documento {

    private String criador;
    private CodigoCurso codigoCurso;
    private int paginas;

    public Documento(String criador, CodigoCurso codigoCurso, int paginas) {
        super();
        this.criador = criador;
        this.codigoCurso = codigoCurso;
        this.paginas = paginas;
    }

    public String getCriador() {
        return criador;
    }

    public CodigoCurso getCodigoCurso() {
        return codigoCurso;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Documento doc = (Documento) obj;

        return Objects.equals(this.criador, doc.criador)
                && Objects.equals(this.codigoCurso, doc.codigoCurso)
                && this.paginas == doc.paginas;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + Objects.hashCode(this.criador);
        hash = 7 * hash + Objects.hashCode(this.codigoCurso);
        hash = 7 * hash + this.paginas;
        return hash;
    }

}
