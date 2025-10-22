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
     * @param criador criador da norma
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas da norma
     * @param numero número da norma
     * @param valido indica se a norma é válida
     * @param texto conteúdo da norma
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
     * @return número da norma
     */
    public int getNumero() {
        return numero;
    }
    /**
     * Retorna se a norma é válida.
     *
     * @return true se válida, false caso contrário
     */
    public boolean getValido() {
        return valido;
    }
    /**
     * Retorna o texto da norma.
     *
     * @return texto da norma
     */
    public String getTexto() {
        return texto;
    }
    /**
     * Compara esta norma com outro objeto para verificar se são iguais.
     *
     * @param obj objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
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
     * @return valor hash da norma
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
