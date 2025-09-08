package escalonador.ufam.com.br;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SJF implements Escalonador {

    public SJF() {
    }

    @Override
    public List<Processo> escalar(List<Processo> processos, List<Execucao> ordemExecucao) {
        List<Processo> fila = new ArrayList<>(processos);
        List<Processo> resultado = new ArrayList<>();
        int tempoAtual = 0;

        while (!fila.isEmpty()) {
            Processo menor = null;

            for (Processo p : fila) {
                if (p.getChegada() <= tempoAtual) {
                    if (menor == null || p.getDuracao() < menor.getDuracao()) {
                        menor = p;
                    }
                }
            }

            if (menor == null) {
                tempoAtual++;
                continue;
            }

            fila.remove(menor);
            int espera = tempoAtual - menor.getChegada();
            menor.setTempoEspera(espera);
            tempoAtual += menor.getDuracao();
            menor.setTempoFinalizacao(tempoAtual);
            menor.setTempoRestante(0);

            ordemExecucao.add(new Execucao(menor.getPid(), tempoAtual - menor.getDuracao(), menor.getDuracao()));
            resultado.add(menor);
        }

        return resultado;
    }
}
