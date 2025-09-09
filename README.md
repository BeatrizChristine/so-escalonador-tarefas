# ⚙️ Escalonamento de Tarefas — Sistemas Operacionais

Projeto desenvolvido na disciplina de **Sistemas Operacionais (UFAM)**.  
Implementação de múltiplos algoritmos de escalonamento de processos.

---

## Descrição
O sistema operacional **ELF** possui seis algoritmos de escalonamento de processos já definidos em seu núcleo:  
- **FCFS** (First Come, First Served)  
- **RR** (Round Robin)  
- **SJF** (Shortest Job First)  
- **SRTF** (Shortest Remaining Time First — preemptivo)  
- **Prioc** (Prioridade com preempção)  
- **Priop** (Prioridade sem preempção)  

O programa simula a execução de processos com base nas seguintes informações:  
- **PID**: Identificador do processo  
- **Tempo de ingresso** na fila de prontos  
- **Duração** (tempo de execução necessário)  
- **Prioridade** (0 = sem prioridade; valores maiores = maior prioridade)  
- **Tipo de processo**:  
  - `1` = CPU bound  
  - `2` = I/O bound  
  - `3` = Ambos  

### Resultados da simulação
- Ordem de execução dos processos  
- Tempo médio de execução  
- Tempo médio de espera  

---

## Funcionalidades
- [x] Implementação de múltiplos algoritmos de escalonamento  
- [x] Definição de **quantum** para Round Robin  
- [x] Entrada de dados parametrizada para diferentes cenários  
- [x] Cálculo automático de tempos médios  
- [x] Relatório consolidado por algoritmo escolhido  
- [x] Código comentado para fins acadêmicos e didáticos  

---

## Tecnologias Utilizadas
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
│── input/                 # Arquivos de entrada de processos
│── output/                # Resultados da simulação
│── README.md              # Documentação do projeto
```
---
## Como Executar

### Passo 1 — Clonar o repositório
```bash
git clone https://github.com/SEU-USUARIO/so-escalonador-tarefas.git
cd so-escalonador-tarefas
```
###Passo 2 — Compilar e executar
Dependendo da linguagem escolhida:
- Java:
```bash
javac src/*.java -d bin
java -cp bin Main
```
- C:
```bash
gcc src/*.c -o escalonador
./escalonador
```
- Python:
```bash
python3 src/main.py
```
### Passo 3 — Inserir os processos

O programa solicitará os processos no seguinte formato:

```bash
PID  TempoDeIngresso  Duracao  Prioridade  Tipo
```

## 📄 Licença
Este projeto foi desenvolvido por **Beatriz Christine Azevedo Batista**  
e está licenciado sob a **Licença MIT** — veja o arquivo [LICENSE](LICENSE) para mais detalhes.



