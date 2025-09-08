package escalonador.ufam.com.br;

import java.util.List;

public interface Escalonador {
	List<Processo> escalar(List<Processo> processos, List<Execucao> ordemExecucao);
}
