# ⚙️ Escalonamento de Tarefas — Sistemas Operacionais

Projeto desenvolvido na disciplina de **Sistemas Operacionais (UFAM)**.  
Implementação de múltiplos algoritmos de escalonamento de processos.

---

## 📌 Descrição
O sistema operacional **ELF** possui seis algoritmos de escalonamento de processos já definidos em seu núcleo:  
- **FCFS** (First Come, First Served)  
- **RR** (Round Robin)  
- **SJF** (Shortest Job First)  
- **SRTF** (Shortest Remaining Time First — preemptivo)  
- **Prioc** (Prioridade com preempção)  
- **Priop** (Prioridade sem preempção)  

O programa simula a execução de processos recebidos como entrada, contendo as seguintes informações:  
- **PID**: Identificador do processo  
- **Tempo de ingresso** na fila de prontos  
- **Duração** (tempo de execução necessário)  
- **Prioridade** (0 = sem prioridade; valores maiores = maior prioridade)  
- **Tipo de processo**:  
  - `1` = CPU bound  
  - `2` = I/O bound  
  - `3` = Ambos  

### Saída esperada:
- Ordem de execução dos processos (sequência de PIDs)  
- Tempo médio de execução  
- Tempo médio de espera  

---

## ⚙️ Funcionalidades
- [x] Implementação de no mínimo **dois algoritmos de escalonamento**  
- [x] Definição de **quantum** para Round Robin  
- [x] Entrada de dados parametrizada para diferentes cenários  
- [x] Cálculo automático de **tempos médios de execução e espera**  
- [x] Relatório completo da simulação com destaque para cada algoritmo utilizado  
- [x] Código totalmente **comentado** para fins acadêmicos e didáticos  

---

## 🚀 Tecnologias Utilizadas
- **Linguagens**: *C*, *Java* ou *Python*  
- **Estruturas de dados**: filas, listas encadeadas e gerenciamento de prioridades  
- **Paradigma**: programação concorrente / simulação de escalonamento  

---

## 📂 Estrutura do Projeto
```bash
/escalonador-tarefas
│── src/                  # Código-fonte principal
│   ├── Process.java       # Classe que modela um processo
│   ├── Scheduler.java     # Classe abstrata de escalonador
│   ├── Fcfs.java          # Implementação do algoritmo FCFS
│   ├── Rr.java            # Implementação do algoritmo Round Robin
│   ├── Sjf.java           # Implementação do algoritmo SJF
│   ├── Srtf.java          # Implementação do algoritmo SRTF
│   ├── Prioc.java         # Implementação do algoritmo de prioridade com preempção
│   ├── Priop.java         # Implementação do algoritmo de prioridade sem preempção
│── input/                # Arquivos de entrada de processos
│── output/               # Resultados da simulação
│── README.md             # Documentação do projeto
```
---

##🖥️ Como Executar
# 🔹 Passo 1 — Clonar o repositório
git clone https://github.com/SEU-USUARIO/so-escalonador-tarefas.git
cd so-escalonador-tarefas

# 🔹 Passo 2 — Compilar e executar
# Dependendo da linguagem escolhida:

## Java
javac src/*.java -d bin
java -cp bin Main

## C
gcc src/*.c -o escalonador
./escalonador

## Python
python3 src/main.py

# 🔹 Passo 3 — Inserir os processos
# O programa solicitará os processos no seguinte formato:
# PID TempoDeIngresso Duracao Prioridade Tipo
# Exemplo:
1 0 6 0 1
2 2 4 3 2
3 4 5 2 1

---

##📊 Exemplo de Saída
Algoritmo escolhido: Round Robin (Quantum = 2)

Ordem de execução dos processos: P1 → P2 → P1 → P3 → P2 → P3 → P1  
Tempo médio de execução: 12.33  
Tempo médio de espera: 5.67

## Licença MIT © Beatriz Christine
