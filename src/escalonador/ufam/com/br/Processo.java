package escalonador.ufam.com.br;

public class Processo {
    private int pid;
    private int chegada;
    private int duracao;
    private int prioridade;
    private int tipo;
    private int tempoEspera;
    private int tempoRestante;
    private int ultimaExecucao; 
    private int tempoFinalizacao;
    private int tempoDeEntradaNaFila;
    private int turnaround; // Novo campo para armazenar o turnaround

    public Processo(int pid, int chegada, int duracao, int prioridade, int tipo) {
        this.pid = pid;
        this.chegada = chegada;    
        this.duracao = duracao;
        this.prioridade = prioridade;
        this.tipo = tipo;
        this.tempoEspera = 0;
        this.tempoRestante = duracao;
        this.ultimaExecucao = -1;
        this.tempoDeEntradaNaFila = -1;
        this.tempoFinalizacao = -1; 
        this.turnaround = -1; // Inicializa o turnaround como um valor inválido
    }

    public Processo(Processo outro) {
        this.pid = outro.pid;
        this.chegada = outro.chegada;
        this.duracao = outro.duracao;
        this.prioridade = outro.prioridade;
        this.tipo = outro.tipo;
        this.tempoEspera = outro.tempoEspera;
        this.tempoRestante = outro.tempoRestante;
        this.ultimaExecucao = outro.ultimaExecucao;
        this.tempoDeEntradaNaFila = outro.tempoDeEntradaNaFila;
        this.tempoFinalizacao = outro.tempoFinalizacao;
        this.turnaround = outro.turnaround; // Copia o turnaround
    }

    // Getters e Setters normais (pid, chegada, duracao, prioridade, tipo, tempoEspera, tempoRestante...)

    public int getPid() {
        return pid;
    }

    public int getChegada() {
        return chegada;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getTipo() {
        return tipo;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public void executar(int tempo) {
        this.tempoRestante = Math.max(0, this.tempoRestante - tempo);
    }

    public int getUltimaExecucao() {
        return ultimaExecucao;
    }

    public void setUltimaExecucao(int ultimaExecucao) {
        this.ultimaExecucao = ultimaExecucao;
    }
    
    public int getTempoFinalizacao() {
        return tempoFinalizacao;
    }

    public void setTempoFinalizacao(int tempoFinalizacao) {
        this.tempoFinalizacao = tempoFinalizacao;
    }
    
    public int getTempoDeEntradaNaFila() {
        return tempoDeEntradaNaFila;
    }

    public void setTempoDeEntradaNaFila(int tempoDeEntradaNaFila) {
        this.tempoDeEntradaNaFila = tempoDeEntradaNaFila;
    }

    public boolean isFinalizado() {
        return tempoRestante == 0;
    }

    // Novo método para calcular e setar o turnaround
    public void calcularTurnaround() {
        if (tempoFinalizacao > -1) {
            this.turnaround = tempoFinalizacao - chegada;
        }
    }

    @Override
    public String toString() {
        // Se o turnaround não tiver sido calculado, calcule-o
        if (turnaround == -1 && tempoFinalizacao > -1) {
            calcularTurnaround();
        }

        return "Processo{PID=" + pid +
                ", chegada=" + chegada +
                ", duracao=" + duracao +
                ", prioridade=" + prioridade +
                ", tipo=" + tipo +
                ", tempoEspera=" + tempoEspera +
                ", turnaround=" + turnaround +
                ", tempoRestante=" + tempoRestante + "}";
    }
}
