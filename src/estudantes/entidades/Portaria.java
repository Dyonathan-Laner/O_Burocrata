package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa uma portaria administrativa, com ano de início e outras informações da Norma.
 * Estende a classe Norma.
 */
public class Portaria extends Norma {
    /** Ano de início da portaria. */
    private int anoInicio;
    
    /**
     * Construtor da classe Portaria.
     *
     * @param criador criador da portaria
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas da portaria
     * @param numero número da portaria
     * @param valido indica se a portaria é válida
     * @param texto conteúdo da portaria
     * @param anoInicio ano de início da portaria
     */
    public Portaria(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, int anoInicio){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.anoInicio = anoInicio;
    }
    /**
     * Retorna o ano de início da portaria.
     *
     * @return ano de início
     */
    public int getAnoInicio(){
        return anoInicio;
    }
    /**
     * Compara esta portaria com outro objeto para verificar se são iguais.
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

        Portaria portaria = (Portaria) obj;

        return Objects.equals(super.getCriador(), portaria.getCriador())
                && Objects.equals(super.getCodigoCurso(), portaria.getCodigoCurso())
                && super.getPaginas() == portaria.getPaginas()
                && super.getNumero() == portaria.getNumero()
                && super.getValido() == portaria.getValido()
                && Objects.equals(super.getTexto(), portaria.getTexto())
                && this.getAnoInicio() == portaria.getAnoInicio();
                
    }
    /**
     * Retorna o hashCode da portaria.
     *
     * @return valor hash da portaria
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += super.getNumero();
        if(super.getValido()){hash ++;};
        hash += Objects.hashCode(super.getTexto());
        hash += this.getAnoInicio();
        
        return hash;
    }
}
