package estudantes.entidades;

import java.util.Arrays;
import java.util.Objects;
import professor.entidades.CodigoCurso;

/**
 * Representa um documento administrativo genérico.
 * Estende a classe Documento.
 */
public class DocumentoAdministrativo extends Documento {
     /**
     * Construtor da classe DocumentoAdministrativo.
     *
     * @param criador criador do documento
     * @param codigoCurso código do curso relacionado
     * @param paginas número de páginas do documento
     */
    public DocumentoAdministrativo(String criador, CodigoCurso codigoCurso, int paginas){
        super(criador, codigoCurso, paginas);
    }
    
    /**
     * Compara este documento administrativo com outro objeto para verificar se são iguais.
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

        DocumentoAdministrativo docAd = (DocumentoAdministrativo) obj;

        return Objects.equals(super.getCriador(), docAd.getCriador())
                && Objects.equals(super.getCodigoCurso(), docAd.getCodigoCurso())
                && super.getPaginas() == docAd.getPaginas();
                
    }
    
    /**
     * Retorna o hashCode do documento administrativo.
     *
     * @return valor hash do documento administrativo
     */
    @Override
    public int hashCode() {
        
        int hash = Objects.hashCode(super.getCriador());
        hash += Objects.hashCode(super.getCodigoCurso());
        hash += super.getPaginas();
        
        return hash;
    }
}
