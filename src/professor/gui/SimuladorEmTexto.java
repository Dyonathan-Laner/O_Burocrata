package professor.gui;

import java.util.TimerTask;
import professor.entidades.CodigoCurso;
import professor.entidades.Universidade;

/**
 * Classe com o simulador da universidade em modo texto.
 * <br><br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 */
public class SimuladorEmTexto {
    public final int TEMPO_DE_EXECUCAO = 60; //em segundos
    
    private static SimuladorEmTexto instancia;
    private static Universidade universidade;
    
    private static TimerTask tarefaSimular;
    private static TimerTask tarefaAtualizar;
    private static TimerTask tarefaControle;
    
    private int execucoes = 0;
    
    private SimuladorEmTexto(){
        universidade = new Universidade();
    }
    
    /**
     * Retorna a única instância de Universidade disponível (singleton).
     * 
     * <strong>NÃO INVOQUE ESSE MÉTODO!!!</strong>
     */
    public static SimuladorEmTexto getInstancia(){
        if(instancia == null){
            instancia = new SimuladorEmTexto();
        }
        return instancia;
    }
    
    private void simular(){
        universidade.simular();
    }
    
    private void atualizarInterface(){
        //TODO refazer uma versão em ASCII
        System.out.println("--------");
        System.out.println("Tempo: " + execucoes + (execucoes==1?" segundo":" segundos"));
        System.out.println("--------");
        System.out.println("Monte da CC: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.GRADUACAO_CIENCIA_DA_COMPUTACAO));
        System.out.println("Monte da EA: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.GRADUACAO_ENGENHARIA_AGRICOLA));
        System.out.println("Monte da EC: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.GRADUACAO_ENGENHARIA_CIVIL));
        System.out.println("Monte da EE: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.GRADUACAO_ENGENHARIA_ELETRICA));
        System.out.println("Monte da EM: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.GRADUACAO_ENGENHARIA_MECANICA));
        System.out.println("Monte da ES: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.GRADUACAO_ENGENHARIA_SOFTWARE));
        System.out.println("Monte da ET: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.GRADUACAO_ENGENHARIA_TELECOMUNICACOES));
        System.out.println("Monte da PPGE: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.POS_GRADUACAO_ENGENHARIA));
        System.out.println("Monte da PPGEE: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.POS_GRADUACAO_ENGENHARIA_ELETRICA));
        System.out.println("Monte da PPGES: " + universidade.contarDocumentosNoMonteDoCurso(CodigoCurso.POS_GRADUACAO_ENGENHARIA_SOFTWARE));
        System.out.println("--------");
        System.out.println("Estresse do burocrata: " + universidade.verificarEstresseDoBurocrata());
        System.out.println("Processos despachados: " + universidade.contarProcessosDespachados());
        System.out.println("Documentos despachados: " + universidade.contarDocumentosDespachados());
        System.out.println("Documentos perdidos: " + universidade.contarDocumentosPerdidos());
        System.out.println("Documentos criados: " + universidade.contarDocumentosCriados());
        System.out.println("--------");
    }
    
    private void controlarTempo(){
        if(execucoes >= TEMPO_DE_EXECUCAO){
            pararSimulacao();
        }
        execucoes++;
    }
    
    private static void pararSimulacao(){
        tarefaControle.cancel();
        tarefaSimular.cancel();
        tarefaAtualizar.cancel();
    }
    
    public static void main(String[] args) {
        tarefaSimular = new TimerTask() {
            @Override
            public void run() {
                SimuladorEmTexto.getInstancia().simular();
            }
        };
        
        tarefaAtualizar = new TimerTask() {
            @Override
            public void run() {
                SimuladorEmTexto.getInstancia().atualizarInterface();
            }
        };
        
        tarefaControle = new TimerTask() {
            @Override
            public void run() {
                SimuladorEmTexto.getInstancia().controlarTempo();
            }
        };
        
        /* começa a invocação da tarefa a cada 1 segundo, começando com 3 segundos de atraso */
        new java.util.Timer().schedule(tarefaControle,3000,1000);
        
        /* começa a invocação da tarefa a cada 100 milissegundos, começando com 3 segundos de atraso */
        new java.util.Timer().schedule(tarefaSimular,3000,100);
        
        /* começa a invocação da tarefa a cada segundos, começando com 4 segundos de atraso */
        new java.util.Timer().schedule(tarefaAtualizar,4000,1000);
    }
    
}
