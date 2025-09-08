package escalonador.ufam.com.br;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilitarios {
	
    public static boolean isSim(String resposta) {
        if (resposta == null) return false;
        resposta = resposta.trim().toLowerCase();
        return resposta.equals("s") || resposta.equals("sim");
    }

    public static boolean isNao(String resposta) {
        if (resposta == null) return false;
        resposta = resposta.trim().toLowerCase();
        return resposta.equals("n") || resposta.equals("nao") || resposta.equals("não");
    }
	
    public static List<Processo> lerProcessosDeArquivo(String caminho) {
        List<Processo> processos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.trim().split("\\s+");
                int pid = Integer.parseInt(partes[0].substring(1)); // Remove 'P'
                int chegada = Integer.parseInt(partes[1]);
                int duracao = Integer.parseInt(partes[2]);
                int prioridade = Integer.parseInt(partes[3]);
                int tipo = Integer.parseInt(partes[4]);
                processos.add(new Processo(pid, chegada, duracao, prioridade, tipo));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return processos;
    }


    public static void imprimirOrdemExecucao(List<Execucao> execucoes) {
        for (Execucao execucao : execucoes) {
            System.out.println(execucao);
        }
    }

    public static void calcularTemposMedios(List<Processo> processos) {
        double somaEspera = 0;
        double somaTurnaround = 0;

        for (Processo p : processos) {
            somaEspera += p.getTempoEspera();
            int turnaround = p.getTempoFinalizacao() - p.getChegada();
            somaTurnaround += turnaround;
        }

        double tempoMedioEspera = somaEspera / processos.size();
        double tempoMedioTurnaround = somaTurnaround / processos.size();

        System.out.printf("Tempo médio de espera: %.2f\n", tempoMedioEspera);
        System.out.printf("Tempo médio de execução: %.2f\n", tempoMedioTurnaround);
    }
}
