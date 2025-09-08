package escalonador.ufam.com.br;

import java.util.*;

public class PRIOnaopreemp implements Escalonador {

    public PRIOnaopreemp() {
    }

    @Override
    public List<Processo> escalar(List<Processo> processos, List<Execucao> ordemExecucao) {
        List<Processo> fila = new ArrayList<>(processos);
        List<Processo> resultado = new ArrayList<>();
        int tempoAtual = 0;

        while (!fila.isEmpty()) {
            List<Processo> disponiveis = new ArrayList<>();
            for (Processo p : fila) {
                if (p.getChegada() <= tempoAtual) {
                    disponiveis.add(p);
                }
            }

            if (disponiveis.isEmpty()) {
                tempoAtual++;
                continue;
            }

            Processo maisPrior = disponiveis.stream()
                .max(Comparator.comparingInt(Processo::getPrioridade))
                .get();

            fila.remove(maisPrior);
            ordemExecucao.add(new Execucao(maisPrior.getPid(), tempoAtual, maisPrior.getDuracao()));
            maisPrior.setTempoEspera(tempoAtual - maisPrior.getChegada());
            tempoAtual += maisPrior.getDuracao();
            maisPrior.setTempoFinalizacao(tempoAtual);
            maisPrior.setTempoRestante(0);
            resultado.add(maisPrior);
        }

        return resultado;
    }
}
