package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa uma deliberação administrativa com um texto descritivo.
 * Extende a classe DocumentoAdministrativo.
 */
public class Deliberacao extends DocumentoAdministrativo {
    /** Texto da deliberação. */
    private String texto;
    
    /**
     * Construtor da classe Deliberacao.
     *
     * @param criador criador do documento
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do documento
     * @param texto conteúdo da deliberação
     */
    public Deliberacao(String criador, CodigoCurso codigoCurso, int paginas, String texto) {
        super(criador, codigoCurso, paginas);
        this.texto = texto;
    }
    
    /**
     * Retorna o texto da deliberação.
     *
     * @return texto da deliberação
     */
    public String getTexto(){
        return texto;
    }
    /**
     * Compara esta deliberação com outro objeto para verificar se são iguais.
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

        Deliberacao delib = (Deliberacao) obj;

        return Objects.equals(super.getCriador(), delib.getCriador())
                && Objects.equals(super.getCodigoCurso(), delib.getCodigoCurso())
                && super.getPaginas() == delib.getPaginas()
                && Objects.equals(this.getTexto(), delib.getTexto());
                
    }
    
    /**
     * Retorna o hashCode da deliberação.
     *
     * @return valor hash da deliberação
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += Objects.hashCode(this.getTexto());
        
        return hash;
    }
    
}
