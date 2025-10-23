package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa uma norma administrativa, com número, validade e texto.
 * Estende a classe DocumentoAdministrativo.
 */
public class Norma extends DocumentoAdministrativo {
    /** Número da norma. */
    private int numero;
    /** Indica se a norma é válida. */
    private boolean valido;
    /** Texto da norma. */
    private String texto;
    
    /**
     * Construtor da classe Norma.
     *
     * @param criador o nome do criador da norma
     * @param codigoCurso o código do curso associado
     * @param paginas o número de páginas do documento
     * @param numero o número identificador da norma
     * @param valido indica se a norma está válida
     * @param texto o conteúdo textual da norma
     */
    public Norma(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto){
        super(criador, codigoCurso, paginas);
        this.numero = numero; 
        this.valido = valido;
        this.texto = texto;
        
    }
    /**
     * Retorna o número da norma.
     *
     * @return o número identificador
     */
    public int getNumero() {
        return numero;
    }
    /**
     * Retorna se a norma é válida.
     *
     * @return {@code true} se a norma está válida, {@code false} caso contrário
     */
    public boolean getValido() {
        return valido;
    }
    /**
     * Retorna o texto da norma.
     *
     * @return o texto da norma
     */
    public String getTexto() {
        return texto;
    }
    /**
     * Compara esta norma com outro objeto para verificar se são iguais.
     *
     * @param obj objeto a ser comparado
     * @return {@code true} se os objetos são equivalentes, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Norma norma = (Norma) obj;

        return Objects.equals(super.getCriador(), norma.getCriador())
                && Objects.equals(super.getCodigoCurso(), norma.getCodigoCurso())
                && super.getPaginas() == norma.getPaginas()
                && this.getNumero() == norma.getNumero()
                && this.getValido() == norma.getValido()
                && Objects.equals(this.getTexto(), norma.getTexto());
                
    }
    /**
     * Retorna o hashCode da norma.
     *
     * @return o valor do hashCode
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += this.getNumero();
        if(this.getValido()){hash ++;};
        hash += Objects.hashCode(this.getTexto());
        
        return hash;
    }
}
