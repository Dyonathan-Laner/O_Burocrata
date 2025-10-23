package estudantes.entidades;

import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa um ofício administrativo, contendo destinatário e texto.
 * Estende a classe Deliberacao.
 */
public class Oficio extends Deliberacao {
    /** Destinatário do ofício. */
    private String destinatario;
    
    /**
     * Construtor da classe Oficio.
     *
     * @param criador criador do ofício
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do ofício
     * @param texto conteúdo do ofício
     * @param destinatario destinatário do ofício
     */
    public Oficio(String criador, CodigoCurso codigoCurso, int paginas, String texto, String destinatario){
        super(criador, codigoCurso, paginas, texto);
        this.destinatario = destinatario;
        
    }
    /**
     * Retorna o destinatário do ofício.
     *
     * @return o nome do destinatário
     */
    public String getDestinatario(){
        return destinatario;
    }
    /**
     * Compara este ofício com outro objeto para verificar se são iguais.
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

        Oficio ofi = (Oficio) obj;

        return Objects.equals(super.getCriador(), ofi.getCriador())
                && Objects.equals(super.getCodigoCurso(), ofi.getCodigoCurso())
                && super.getPaginas() == ofi.getPaginas()
                && Objects.equals(super.getTexto(), ofi.getTexto())
                && Objects.equals(this.getDestinatario(), ofi.getDestinatario());
                
    }
    /**
     * Retorna o hashCode do ofício.
     *
     * @return o valor do hashCode
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += Objects.hashCode(super.getTexto());
        hash += Objects.hashCode(this.getDestinatario());
        
        return hash;
    }
    
}
