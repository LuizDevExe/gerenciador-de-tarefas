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
- **Flyway**

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

src/
 ├── main/
 │   ├── java/com/luiz/CadastroDeTarefas/
 │   │   ├── funcionario/
 │   │   │   ├── FuncionarioController.java   # Controlador REST (endpoints de funcionário)
 │   │   │   ├── FuncionarioRepository.java   # Interface JPA para persistência
 │   │   │   ├── FuncionarioService.java      # Service (onde fica a lógica de negócios da aplicação)
 │   │   │   └── FuncionarioModel.java        # Entidade mapeada para tabela tb_funcionarios
 │   │   │
 │   │   ├── tarefa/
 │   │   │   ├── TarefaController.java        # Controlador REST (endpoints de tarefa)
 │   │   │   ├── TarefaRepository.java        # Interface JPA para persistência
 │   │   │   ├── TarefaService.java           # Service (onde fica a lógica de negócios da aplicação)
 │   │   │   └── TarefaModel.java             # Entidade mapeada para tabela tb_tarefas
 │   │   │
 │   │   └── Application.java                 # Classe principal (ponto de entrada)
 │   │
 │   └── resources/
 │       ├── application.properties           # Configurações do projeto
 │       └── db/
 │           └── migration/                   # Aqui ficam os scripts de migração do Flyway (versões do banco)
 │
 └── test/                                    # Testes unitários e de integração
      
