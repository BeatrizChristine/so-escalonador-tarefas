package escalonador.ufam.com.br;

public class Execucao {
    private int pid;
    private int inicio;
    private int duracao;

    public Execucao(int pid, int inicio, int duracao) {
        this.pid = pid;
        this.inicio = inicio;
        this.duracao = duracao;
    }

    public int getPid() {
        return pid;
    }

    public int getInicio() {
        return inicio;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Execucao{PID=" + pid + ", Início=" + inicio + ", Duração=" + duracao + "}";
    }
}
