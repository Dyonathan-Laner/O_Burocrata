package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa uma circular, um tipo de deliberação enviada para vários destinatários.
 */
public class Circular extends Deliberacao {
    /** Lista de destinatários da circular. */
    private String[] destinatarios;
    
     /**
     * Construtor da circular.
     * 
     * @param criador autor do documento
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do documento
     * @param texto conteúdo do texto da circular
     * @param destinatarios lista de destinatários
     */
    public Circular(String criador, CodigoCurso codigoCurso, int paginas, String texto, String[] destinatarios){
        super(criador, codigoCurso, paginas, texto);
        this.destinatarios = destinatarios;   
    }
    /** Retorna os destinatários da circular. */
    public String[] getDestinatarios(){
        return destinatarios;
    }
    
    /** Compara o objeto passado é igual a essa circular. 
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

        Circular circ = (Circular) obj;

        return Objects.equals(super.getCriador(), circ.getCriador())
                && Objects.equals(super.getCodigoCurso(), circ.getCodigoCurso())
                && super.getPaginas() == circ.getPaginas()
                && Objects.equals(super.getTexto(), circ.getTexto())
                && Objects.equals(this.getDestinatarios(), circ.getDestinatarios());
                
    }
    
    /** Gera um hashCode com base nos atributos da circular. */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        hash += Objects.hashCode(super.getTexto());
        hash += Arrays.deepHashCode(this.getDestinatarios());
        
        return hash;
    }
}
