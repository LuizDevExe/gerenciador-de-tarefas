# 📝 Gerenciador de Tarefas - API

API desenvolvida em **Java** utilizando o padrão de **camadas**, com suporte a **JPA/Hibernate**, **Lombok**, **Spring Web** e **banco em memória H2**.  
O objetivo é gerenciar tarefas dentro de uma empresa, permitindo cadastrar funcionários e associá-los às tarefas que precisam ser executadas.

---

## 🚀 Tecnologias utilizadas
- **Java 17+**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **Lombok**
- **H2 Database**
- **Maven**

---

## 📌 Funcionalidades
- **Funcionários**
  - Cadastro de funcionários com os dados:  
    `id`, `nome`, `cpf`, `email`, `cargo`
  - Listagem de funcionários
  - Consulta por ID
  - Exclusão e atualização

- **Tarefas**
  - Cadastro de tarefas com os dados:  
    `id`, `nome da tarefa`, `prazo`, `prioridade`
  - Associação de funcionários responsáveis (`funcionarios_id`)
  - Listagem de todas as tarefas
  - Consulta por ID
  - Exclusão e atualização

---

## 🗂️ Estrutura do Projeto
