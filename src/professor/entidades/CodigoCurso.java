package professor.entidades;

/**
 * Enumeração dos códigos dos cursos.
 * <br><br>
 * Uma enumeração é um tipo especial de classe que representa um grupo de
 * constantes que podem ser usadas em várias instruções de forma mais elegante 
 * que constantes padrão (por exemplo, enumerações podem ser usadas em 
 * cláusulas <strong>case</strong> de estruturas switch-case no lugar de
 * números inteiros, caracteres e Strings).
 * <br><br>
 * Como elas são classes especiais, uma enumeração pode incluir atributos e
 * métodos quando são criadas (o que não é o caso da enumeração CodigoCurso).
 * <br><br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 */
public enum CodigoCurso {
    GRADUACAO_CIENCIA_DA_COMPUTACAO,
    GRADUACAO_ENGENHARIA_AGRICOLA,
    GRADUACAO_ENGENHARIA_CIVIL,
    GRADUACAO_ENGENHARIA_ELETRICA,
    GRADUACAO_ENGENHARIA_MECANICA,
    GRADUACAO_ENGENHARIA_SOFTWARE,
    GRADUACAO_ENGENHARIA_TELECOMUNICACOES,
    POS_GRADUACAO_ENGENHARIA,
    POS_GRADUACAO_ENGENHARIA_ELETRICA,
    POS_GRADUACAO_ENGENHARIA_SOFTWARE
}
