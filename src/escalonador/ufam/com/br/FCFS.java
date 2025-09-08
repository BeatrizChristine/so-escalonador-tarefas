package escalonador.ufam.com.br;

import java.util.ArrayList;
import java.util.List;

public class FCFS implements Escalonador {

    public FCFS() {
    }

    @Override
    public List<Processo> escalar(List<Processo> processos, List<Execucao> ordemExecucao) {
        List<Processo> resultado = new ArrayList<>();
        int tempoAtual = 0;

        for (Processo p : processos) {
            int espera = Math.max(0, tempoAtual - p.getChegada());
            p.setTempoEspera(espera);
            tempoAtual = Math.max(tempoAtual, p.getChegada()) + p.getDuracao();
            p.setTempoFinalizacao(tempoAtual);
            p.setTempoRestante(0);

            ordemExecucao.add(new Execucao(p.getPid(), tempoAtual - p.getDuracao(), p.getDuracao()));
            resultado.add(p);
        }

        return resultado;
    }
}
