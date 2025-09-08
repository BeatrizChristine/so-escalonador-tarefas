package escalonador.ufam.com.br;

import java.util.*;

public class RoundRobin implements Escalonador {
    private int quantum;

    public RoundRobin(int quantum) {
        this.quantum = quantum;
    }

    @Override
    public List<Processo> escalar(List<Processo> processos, List<Execucao> ordemExecucao) {
        List<Processo> resultado = new ArrayList<>();
        Queue<Processo> prontos = new LinkedList<>();
        Map<Integer, Integer> restante = new HashMap<>();
        int tempoAtual = 0;

        for (Processo p : processos) {
            restante.put(p.getPid(), p.getDuracao());
        }

        while (!processos.isEmpty() || !prontos.isEmpty()) {
            Iterator<Processo> it = processos.iterator();
            while (it.hasNext()) {
                Processo p = it.next();
                if (p.getChegada() <= tempoAtual) {
                    prontos.add(p);
                    it.remove();
                }
            }

            if (prontos.isEmpty()) {
                tempoAtual++;
                continue;
            }

            Processo atual = prontos.poll();
            int restanteTempo = restante.get(atual.getPid());
            int uso = Math.min(quantum, restanteTempo);

            ordemExecucao.add(new Execucao(atual.getPid(), tempoAtual, uso));
            tempoAtual += uso;
            restante.put(atual.getPid(), restanteTempo - uso);

            if (restante.get(atual.getPid()) == 0) {
                atual.setTempoFinalizacao(tempoAtual);
                atual.setTempoRestante(0);
                atual.setTempoEspera(tempoAtual - atual.getChegada() - atual.getDuracao());
                resultado.add(atual);
            } else {
                prontos.add(atual);
            }
        }

        return resultado;
    }
}
