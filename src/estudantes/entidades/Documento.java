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

    /** Nome do criador do documento. */
    private String criador;
    /** Código do curso que o documento está associado. */
    private CodigoCurso codigoCurso;
    /** Quantidade de páginas do documento. */
    private int paginas;
    
    /**
     * Construtor da classe Documento.
     *
     * @param criador criador do documento
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do documento
     */
    public Documento(String criador, CodigoCurso codigoCurso, int paginas) {
        super();
        this.criador = criador;
        this.codigoCurso = codigoCurso;
        this.paginas = paginas;
    }
    /**
     * Retorna o nome do criador do documento.
     *
     * @return nome do criador
     */
    public String getCriador() {
        return criador;
    }
    /**
     * Retorna o código do curso do documento.
     *
     * @return código do curso
     */
    public CodigoCurso getCodigoCurso() {
        return codigoCurso;
    }
    /**
     * Retorna a quantidade de páginas do documento.
     *
     * @return número de páginas
     */
    public int getPaginas() {
        return paginas;
    }
    
    /**
     * Compara este documento com outro objeto para verificar se são iguais.
     *
     * @param obj objeto a ser comparado
     * @return true se os documentos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Documento doc = (Documento) obj;

        return Objects.equals(this.criador, doc.criador)
                && Objects.equals(this.codigoCurso, doc.codigoCurso)
                && this.paginas == doc.paginas;
    }
    /**
     * Retorna o hashCode do documento.
     *
     * @return valor hash do documento
     */
    @Override
    public int hashCode() {
        int hash = Objects.hashCode(this.criador);
        hash += Objects.hashCode(this.codigoCurso);
        hash += this.paginas;
        return hash;
    }

}
