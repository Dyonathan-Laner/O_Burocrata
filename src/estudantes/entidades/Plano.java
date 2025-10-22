package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa um plano acadêmico de curso, com responsável e planejamento.
 * Estende a classe DocumentoAcademico.
 */
public class Plano extends DocumentoAcademico {
    /** Responsável pelo plano. */
    private String responsavel;
     /** Planejamento contido no plano. */
    private String[] planejamento;
    
     /**
     * Construtor da classe Plano.
     *
     * @param criador criador do plano
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do plano
     * @param autenticacao código de autenticação do documento
     * @param responsavel responsável pelo plano
     * @param planejamento planejamento contido no plano
     */
    public Plano(String criador, CodigoCurso codigoCurso, int paginas, long autenticacao, String responsavel, String[] planejamento){
        super(criador, codigoCurso, paginas, autenticacao);
        this.responsavel = responsavel;
        this.planejamento = planejamento;
        
    }
    /**
     * Retorna o responsável pelo plano.
     *
     * @return responsável
     */
    public String getResponsavel() {
        return responsavel;
    }
    /**
     * Retorna o planejamento do plano.
     *
     * @return array de planejamento
     */
    public String[] getPlanejamento() {
        return planejamento;
    }
    /**
    * Compara este plano com outro objeto para verificar se são iguais.
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

        Plano plano = (Plano) obj;

        return Objects.equals(super.getCriador(), plano.getCriador())
                && Objects.equals(super.getCodigoCurso(), plano.getCodigoCurso())
                && super.getPaginas() == plano.getPaginas()
                && super.getAutenticacao() == plano.getAutenticacao()
                && Objects.equals(this.getPlanejamento(), plano.getPlanejamento())
                && Objects.equals(this.getResponsavel(), plano.getResponsavel());
    }
    /**
     * Retorna o hashCode do plano.
     *
     * @return valor hash do plano
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += (int)super.getAutenticacao() / 100;
        hash += Arrays.deepHashCode(this.planejamento);
        hash += Objects.hashCode(this.responsavel);
        
        return hash;
    }
    
}
