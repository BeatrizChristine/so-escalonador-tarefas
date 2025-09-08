package escalonador.ufam.com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Processo> processos = new ArrayList<>();

        // Entrada dos processos
        System.out.println("\u2501".repeat(60));
        String opcaoArquivo = "";
        while (true) {
            System.out.print("\ud83d\udcc5 Deseja carregar processos de um arquivo? (s/n): ");
            opcaoArquivo = scanner.nextLine().trim().toLowerCase();
            if (opcaoArquivo.equals("s") || opcaoArquivo.equals("sim") ||
                opcaoArquivo.equals("n") || opcaoArquivo.equals("nao") || opcaoArquivo.equals("não")) {
                break;
            }
            System.out.println("\u26a0\ufe0f Entrada inválida. Digite 's' (sim) ou 'n' (não).");
        }

        if (Utilitarios.isSim(opcaoArquivo)) {
            System.out.print("\ud83d\udcc2 Digite o caminho do arquivo: ");
            String caminhoArquivo = scanner.nextLine().trim().replace("\"", "");
            processos = Utilitarios.lerProcessosDeArquivo(caminhoArquivo);

            if (processos.isEmpty()) {
                System.out.println("\u26a0\ufe0f Nenhum processo carregado. Encerrando programa.");
                scanner.close();
                return;
            }
        } else {
        	// CPU-bound (tipo 1)
        	processos.add(new Processo(1, 0, 6, 2, 1));
        	processos.add(new Processo(2, 1, 4, 3, 1));
        	processos.add(new Processo(3, 3, 9, 1, 1));
        	processos.add(new Processo(4, 5, 2, 4, 1));
        	processos.add(new Processo(5, 6, 7, 5, 1));
        	processos.add(new Processo(6, 8, 1, 3, 1));
        	processos.add(new Processo(7, 9, 5, 1, 1));
        	processos.add(new Processo(8, 11, 3, 2, 1));
        	processos.add(new Processo(9, 12, 4, 1, 1));
        	processos.add(new Processo(10, 14, 6, 3, 1));

        	// I/O-bound (tipo 2)
        	processos.add(new Processo(11, 0, 3, 2, 2));
        	processos.add(new Processo(12, 2, 4, 1, 2));
        	processos.add(new Processo(13, 4, 2, 3, 2));
        	processos.add(new Processo(14, 5, 5, 1, 2));
        	processos.add(new Processo(15, 6, 1, 4, 2));
        	processos.add(new Processo(16, 7, 3, 2, 2));
        	processos.add(new Processo(17, 8, 2, 1, 2));
        	processos.add(new Processo(18, 9, 4, 2, 2));
        	processos.add(new Processo(19, 11, 3, 3, 2));
        	processos.add(new Processo(20, 12, 2, 1, 2));

        	// Ambos (tipo 3)
        	processos.add(new Processo(21, 0, 7, 2, 3));
        	processos.add(new Processo(22, 3, 5, 1, 3));
        	processos.add(new Processo(23, 5, 4, 4, 3));
        	processos.add(new Processo(24, 6, 6, 3, 3));
        	processos.add(new Processo(25, 7, 3, 2, 3));
        	processos.add(new Processo(26, 8, 2, 1, 3));
        	processos.add(new Processo(27, 9, 4, 2, 3));
        	processos.add(new Processo(28, 10, 5, 3, 3));
        	processos.add(new Processo(29, 12, 6, 4, 3));
        	processos.add(new Processo(30, 14, 3, 1, 3));

        }

        List<Processo> cpuBound = new ArrayList<>();
        List<Processo> ioBound = new ArrayList<>();
        List<Processo> ambos = new ArrayList<>();

        for (Processo p : processos) {
            if (p.getTipo() == 1) cpuBound.add(p);
            else if (p.getTipo() == 2) ioBound.add(p);
            else ambos.add(p);
        }

        int quantum = 0;
        int escolhaCpu = 0, escolhaIo = 0, escolhaAmbos = 0;

        System.out.println("\n" + "\u2501".repeat(60));
        System.out.println("\ud83e\uddd0 ALGORITMOS DISPONÍVEIS:");
        System.out.println("1 - FCFS (First Come First Served)");
        System.out.println("2 - SJF (Shortest Job First)");
        System.out.println("3 - Round Robin");
        System.out.println("4 - PRIO (Preemptivo)");
        System.out.println("5 - PRIO (Não Preemptivo)");
        System.out.println("\u2501".repeat(60));

        if (!cpuBound.isEmpty()) {
            while (true) {
                System.out.print("\ud83d\udc6e Escolha o algoritmo para CPU-bound (1-5): ");
                if (scanner.hasNextInt()) {
                    escolhaCpu = scanner.nextInt();
                    if (escolhaCpu >= 1 && escolhaCpu <= 5) break;
                } else scanner.next();
                System.out.println("\u26a0\ufe0f Entrada inválida. Digite um número entre 1 e 5.");
            }
        }
        if (!ioBound.isEmpty()) {
            while (true) {
                System.out.print("\ud83d\udcca Escolha o algoritmo para I/O-bound (1-5): ");
                if (scanner.hasNextInt()) {
                    escolhaIo = scanner.nextInt();
                    if (escolhaIo >= 1 && escolhaIo <= 5) break;
                } else scanner.next();
                System.out.println("\u26a0\ufe0f Entrada inválida. Digite um número entre 1 e 5.");
            }
        }
        if (!ambos.isEmpty()) {
            while (true) {
                System.out.print("\ud83d\udd00 Escolha o algoritmo para processos mistos (1-5): ");
                if (scanner.hasNextInt()) {
                    escolhaAmbos = scanner.nextInt();
                    if (escolhaAmbos >= 1 && escolhaAmbos <= 5) break;
                } else scanner.next();
                System.out.println("\u26a0\ufe0f Entrada inválida. Digite um número entre 1 e 5.");
            }
        }

        if ((escolhaCpu == 3 && !cpuBound.isEmpty()) ||
            (escolhaIo == 3 && !ioBound.isEmpty()) ||
            (escolhaAmbos == 3 && !ambos.isEmpty())) {
            while (true) {
                System.out.print("\ud83c\udf00 Informe o quantum para Round Robin: ");
                if (scanner.hasNextInt()) {
                    quantum = scanner.nextInt();
                    if (quantum > 0) break;
                } else scanner.next();
                System.out.println("\u26a0\ufe0f Digite um número inteiro positivo.");
            }
        }

        if (!cpuBound.isEmpty()) {
            System.out.println("\n\ud83d\uddfe Escalonando CPU-bound:");
            executar(cpuBound, escolhaCpu, quantum);
        }
        if (!ioBound.isEmpty()) {
            System.out.println("\n\ud83d\udfe8 Escalonando I/O-bound:");
            executar(ioBound, escolhaIo, quantum);
        }
        if (!ambos.isEmpty()) {
            System.out.println("\n\ud83d\udfe9 Escalonando processos mistos:");
            executar(ambos, escolhaAmbos, quantum);
        }

        System.out.println("\n\u2705 Escalonamento concluído.");
        System.out.println("\u2501".repeat(60));
        scanner.close();
    }

    private static void executar(List<Processo> lista, int escolha, int quantum) {
        Escalonador escalonador;
        String nomeAlgoritmo;

        switch (escolha) {
            case 1: escalonador = new FCFS(); nomeAlgoritmo = "FCFS"; break;
            case 2: escalonador = new SJF(); nomeAlgoritmo = "SJF"; break;
            case 3: escalonador = new RoundRobin(quantum); nomeAlgoritmo = "Round Robin (q=" + quantum + ")"; break;
            case 4: escalonador = new PRIOpreemp(); nomeAlgoritmo = "PRIO Preemptivo"; break;
            case 5: escalonador = new PRIOnaopreemp(); nomeAlgoritmo = "PRIO Não Preemptivo"; break;
            default: System.out.println("\u274c Opção inválida."); return;
        }

        List<Execucao> ordemExecucao = new ArrayList<>();
        List<Processo> escalonados = escalonador.escalar(lista, ordemExecucao);

        System.out.println("\u2501".repeat(60));
        System.out.println("\u25b6\ufe0f  Algoritmo usado: " + nomeAlgoritmo);
        System.out.println("\ud83d\udce6  Total de processos: " + escalonados.size());
        System.out.println("\u2501".repeat(60));

        System.out.println("\n\ud83d\udd39 Ordem de Execução:");
        System.out.println("PID  | Início | Duração");
        System.out.println("-----+--------+--------");
        for (Execucao exec : ordemExecucao) {
            System.out.printf("P%-3d | %-6d | %-7d\n", exec.getPid(), exec.getInicio(), exec.getDuracao());
        }

        System.out.println("\n\ud83d\udccb Detalhes dos Processos:");
        System.out.println("PID  | Chegada | Duração | Prior | Tipo | Espera | Turnaround");
        System.out.println("-----+---------+---------+-------+------+--------+------------");
        for (Processo p : escalonados) {
            int turnaround = p.getTempoFinalizacao() - p.getChegada();
            System.out.printf("P%-3d | %-7d | %-7d | %-5d | %-4d | %-6d | %-10d\n",
                p.getPid(), p.getChegada(), p.getDuracao(), p.getPrioridade(),
                p.getTipo(), p.getTempoEspera(), turnaround);
        }

        double somaEspera = 0, somaTurnaround = 0;
        for (Processo p : escalonados) {
            somaEspera += p.getTempoEspera();
            somaTurnaround += (p.getTempoFinalizacao() - p.getChegada());
        }

        double mediaEspera = somaEspera / escalonados.size();
        double mediaTurnaround = somaTurnaround / escalonados.size();

        System.out.println("\n\ud83d\udcca Estatísticas do Escalonamento:");
        System.out.printf(Locale.US, "\u23f3 Tempo médio de espera:     %.2f unidades de tempo\n", mediaEspera);
        System.out.printf(Locale.US, "\u2705 Tempo médio de execução:   %.2f unidades de tempo (turnaround)\n", mediaTurnaround);
        System.out.println("\u2501".repeat(60) + "\n");
    }
}
