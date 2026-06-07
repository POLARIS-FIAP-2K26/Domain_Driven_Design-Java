# SPACE CONNECT: Polaris, the Earth First 

## 📌 Sobre o Projeto

Este projeto propõe uma solução para a dificuldade de monitorar ambientes inóspitos ou de risco humano, como áreas florestais ou galpões industriais susceptíveis a incêndios, onde a coleta de dados e a resposta rápida a focos de calor são limitadas.

O objetivo da solução é desenvolver uma interface em Java (Dashboard) que recebe e processa dados simulados de um robô de patrulha ambiental equipado com um ESP32. O sistema interpreta dados de temperatura, umidade, proximidade de obstáculos e incidência de infravermelho (fogo), gerando alertas em tempo real.

### Relação com o ODS 9

A solução promove a inovação tecnológica e a infraestrutura inteligente. Ao utilizar robótica e IoT (Internet of Things) para automatizar a prevenção de desastres e coleta de dados, a plataforma constrói uma base de infraestrutura resiliente e sustentável para a indústria e o meio ambiente.

---

## 🛠️ Tecnologias e Habilidades

### Hardware e IoT

* **Microcontrolador:** ESP32
* **Sensores:** Infravermelho, Ultrassom, Temperatura e Umidade

### Software e Arquitetura

* **Linguagem:** Java (Interface gráfica com Swing )
* **Paradigma:** Programação Orientada a Objetos (Encapsulamento, Herança e Polimorfismo )

---

## ⚙️ Modelagem do Sistema

O sistema centraliza a estrutura de dados na classe abstrata `Sensor`. Esta classe é herdada por `SensorClimatico` (responsável por temperatura e umidade) e `SensorIncendio` (responsável por proximidade e detecção de chamas). A interface `Monitoravel` é aplicada aos sensores críticos para padronizar o disparo de alertas emergenciais.

---

## 🚀 Como Executar

1. Clone este repositório para a sua máquina local:
```bash
git clone https://github.com/seu-usuario/space-connect.git

```


2. Abra o projeto na sua IDE de preferência (recomendamos o IntelliJ IDEA).
3. Certifique-se de que a pasta `src` está marcada como "Sources Root".
4. Navegue até o pacote `app` e localize a classe `WallEDashboard.java`.
5. Execute o método `main` para compilar o projeto e abrir a interface gráfica do painel de controle.

---

## 👥 Equipe de Desenvolvimento

Projeto desenvolvido como Global Solution por estudantes de Engenharia de Software da FIAP:

* **Arthur Berlofa Bosi** - RM: 564438 
* **Levi de Jesus** - RM: 563279 
* **Luigi Borghi** - RM: 563096 
* **Ulisses Ribeiro** - RM: 562230
