package professor.entidades;

import estudantes.entidades.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Classe que representa um curso com seu monte de documentos.
 * <br><br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 */
public class Curso {
    
    private final String[] PRENOMES = { "Alessandro", "Alexandre", "Alice", "Aline", "Amanda", "Ana", "Arlindo", "Celso", "Cesar", "Claudio", "Diego", "Diogo", "Dionatan", "Elder", "Eliezer", "Fabio", "Fabio", "Fladimir", "Gilleanes", "Ildevana", "Jean", "Joao", "Maicon", "Marcelo", "Marcelo",  "Paulo","Raquel", "Rodrigo", "Silvio", "Williamson" };
    private final String[] SOBRENOMES = { "Oliveira", "Oliveira", "Finger", "Mello", "Melo", "Lara", "Junior", "Fonseca", "Cristaldo", "Schepke", "Kreutz", "Cardoso", "Schmidt", "Rodrigues", "Flores", "Schons","Basso", "Santos", "Guedes",  "Rodrigues", "Cheiran", "Silva", "Silveira", "Luizelli", "Thielo",  "Souza", "Basso", "Mansilha", "Quincozes", "Silva" };
    private final String[] COMPONENTES = { "Algoritmos e Programação para Computação", "Introdução à Computação","Circuitos Digitais","Fundamentos de Matemática para Computação","Lógica Matemática","Estruturas de Dados I","Arquitetura e Organização de Computadores I","Geometria Analítica","Cálculo para Computação I", "Ética e Legislação em Computação","Inovação e Criativdade","Estruturas de Dados II","Programação Orientada a Objetos","Arquitetura e Organização de Computadores II","Álgebra Linear", "Cálculo para Computação II","Estruturas de Dados III","Teoria dos Grafos","Projeto e Análise de Algoritmos","Sistemas Operacionais","Probabilidade e Estatística","Linguagens Formais","Inteligência Artificial","Banco de Dados","Redes de Computadores","Teoria da Computação","Computação Gráfica","Engenharia de Software","Interação Humano-Computador","Metodologia Científica","Trabalho de Conclusão de Curso I","Trabalho de Conclusão de Curso II" };
    
    private static int documentosCriados = 0; 
    
    private Random gerador;
    
    private CodigoCurso codigo;
    private LinkedList<Documento> monte;
    
    protected Curso(CodigoCurso codigo){
        this.codigo = codigo;
        this.gerador = new Random(codigo.hashCode() + Universidade.SEMENTE);
        this.monte = new LinkedList<>();
    }
    
    protected void criarDocumentos(int quantidade){
        for(int i = 0; i < quantidade; i++){
            Documento doc = null;
            
            int tipoDeDocumento = gerador.nextInt(0, 11);
            
            switch(tipoDeDocumento){
                case 0:
                    doc = new Norma(gerarNome(), this.codigo, gerador.nextInt(1, 150), gerador.nextInt(1, 1000), gerador.nextBoolean(), "Lorem ipsum");
                    break;
                case 1:
                    doc = new Portaria(gerarNome(), this.codigo, gerador.nextInt(1, 250), gerador.nextInt(1, 1000), gerador.nextBoolean(), "Lorem ipsum", gerador.nextInt(2000, 2025));
                    break;
                case 2:
                    {
                        int quantidadeDePessoas = gerador.nextInt(1, 5);
                        String responsaveis[] = new String[quantidadeDePessoas];
                        for(int j = 0; j < quantidadeDePessoas; j++){
                            responsaveis[j] = gerarNome();
                        }
                        doc = new Edital(gerarNome(), this.codigo, gerador.nextInt(1, 250), gerador.nextInt(1, 1000), gerador.nextBoolean(), "Lorem ipsum", responsaveis);
                    }
                    break;
                case 3:
                    {
                        int quantidadeDePessoas = gerador.nextInt(1, 5);
                        String destinatarios[] = new String[quantidadeDePessoas];
                        for(int j = 0; j < quantidadeDePessoas; j++){
                            destinatarios[j] = gerarNome();
                        }
                        doc = new Circular(gerarNome(), this.codigo, gerador.nextInt(1, 5), "Lorem ipsum", destinatarios);
                    }
                    break;
                case 4:
                    doc = new Oficio(gerarNome(), this.codigo, gerador.nextInt(1, 5), "Lorem ipsum", gerarNome());
                    break;
                case 5:
                    {
                        int quantidadeDePessoas = gerador.nextInt(1, 50);
                        String presentes[] = new String[quantidadeDePessoas];
                        for(int j = 0; j < quantidadeDePessoas; j++){
                            presentes[j] = gerarNome();
                        }
                        doc = new Ata(gerarNome(), this.codigo, gerador.nextInt(1, 150), gerador.nextInt(1, 100), "Lorem ipsum", presentes);
                    }
                    break;
                case 6:
                    doc = new Certificado(gerarNome(), this.codigo, gerador.nextInt(1, 2), gerador.nextLong(Long.MAX_VALUE), gerarNome(), gerador.nextLong(Long.MAX_VALUE), "Lorem Ipsum");
                    break;
                case 7:
                    doc = new Diploma(gerarNome(), this.codigo, gerador.nextInt(1, 2), gerador.nextLong(Long.MAX_VALUE), gerarNome(), gerador.nextLong(Long.MAX_VALUE), "Lorem Ipsum", "Bacharelado "+this.codigo);
                    break;
                case 8:
                    {
                        int quantidadeDeComponentes = gerador.nextInt(1, 10);
                        String componentes[] = new String[quantidadeDeComponentes];
                        for(int j = 0; j < quantidadeDeComponentes; j++){
                            componentes[j] = escolherComponente();
                        }
                        doc = new Historico(gerarNome(), this.codigo, gerador.nextInt(1, 2), gerador.nextLong(Long.MAX_VALUE), gerarNome(), gerador.nextLong(Long.MAX_VALUE), gerador.nextDouble(100), componentes);
                    }
                    break;
                case 9:
                    doc = new Atestado(gerarNome(), this.codigo, gerador.nextInt(1, 2), gerador.nextLong(Long.MAX_VALUE), gerarNome(), gerador.nextLong(Long.MAX_VALUE), "Lorem Ipsum", "Categoria " + gerador.nextInt(1, 5));
                    break;
                case 10:
                    {
                        int quantidadeDeAtividades = gerador.nextInt(1, 30);
                        String atividades[] = new String[quantidadeDeAtividades];
                        for(int j = 0; j < quantidadeDeAtividades; j++){
                            atividades[j] = "Atividade " + (j+1);
                        }
                        doc = new Plano(gerarNome(), this.codigo, gerador.nextInt(1, 2), gerador.nextLong(Long.MAX_VALUE), gerarNome(), atividades);
                    }
                    break;
                default: 
                    throw new RuntimeException("Tipo de documento inválido");
            }
            
            documentosCriados++;
            monte.push(doc);
        }
    }
    
    protected int contarDocumentosNoMonte(){
        return monte.size();
    }
    
    protected boolean removerDocumento(Documento documento){
        return monte.remove(documento);
    }
    
    protected void devolverDocumento(Documento documento){
        monte.push(documento);
    }
    
    protected Documento[] pegarCopiaDoMonte(){
        return Arrays.copyOf(monte.toArray(), monte.size(), Documento[].class);
    }
    
    protected static int getDocumentosCriados(){
        return documentosCriados;
    }
    
    private String gerarNome(){
        return PRENOMES[gerador.nextInt(PRENOMES.length)] + " " + SOBRENOMES[gerador.nextInt(SOBRENOMES.length)];
    }
    
    private String escolherComponente(){
        return COMPONENTES[gerador.nextInt(COMPONENTES.length)];
    }
}
