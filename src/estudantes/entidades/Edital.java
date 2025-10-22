package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa um edital, que é um tipo de norma, contendo responsáveis pelo documento.
 * Estende a classe Norma.
 */
public class Edital extends Norma {
    
    /** Lista de responsáveis pelo edital. */
    private String[] responsaveis;
    /**
     * Construtor da classe Edital.
     *
     * @param criador criador do edital
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do edital
     * @param numero número do edital
     * @param valido indica se o edital é válido
     * @param texto conteúdo do edital
     * @param responsaveis lista de responsáveis pelo edital
     */
    public Edital(String criador, CodigoCurso codigoCurso, int paginas, int numero, boolean valido, String texto, String[] responsaveis){
        super(criador, codigoCurso, paginas, numero, valido, texto);
        this.responsaveis = responsaveis;
    }
    /**
     * Retorna a lista de responsáveis pelo edital.
     *
     * @return array de responsáveis
     */
    public String[] getResponsaveis(){
        return responsaveis;
    }
    /**
     * Compara este edital com outro objeto para verificar se são iguais.
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

        Edital edital = (Edital) obj;

        return Objects.equals(super.getCriador(), edital.getCriador())
                && Objects.equals(super.getCodigoCurso(), edital.getCodigoCurso())
                && super.getPaginas() == edital.getPaginas()
                && super.getNumero() == edital.getNumero()
                && super.getValido() == edital.getValido()
                && Objects.equals(super.getTexto(), edital.getTexto())
                && Objects.equals(this.getResponsaveis(), edital.getResponsaveis());
                
    }
    /**
     * Retorna o hashCode do edital.
     *
     * @return valor hash do edital
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += super.getNumero();
        if(super.getValido()){hash ++;};
        hash += Objects.hashCode(super.getTexto());
        hash += Arrays.deepHashCode(this.getResponsaveis());
        
        return hash;
    }
}
