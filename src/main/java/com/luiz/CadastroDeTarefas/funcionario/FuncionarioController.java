package com.luiz.CadastroDeTarefas.funcionario;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Boas vindas";

    }

    //Adicionar Funcionário (Create)
    @PostMapping("/cadastrar")
    public String cadastrarFuncionario(){
        return "Cadastrar Funcionario";
    }

    // Mostrar funcionários(Read)
    @GetMapping("/listar")
    public List<FuncionarioModel> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }

    // Prourar Funcionário Por ID (Read)

    @GetMapping("/listarID")
    public String listarFuncionariosID(){
        return "Listar Funcionarios ID";
    }

    // Alterar dados dos Funcionários (Update)
    @PutMapping("/atualizar")
    public String atualizarFuncionario(){
        return "Atualizar Funcionario";
    }

    // Deletar Funcionário (Delete)
    @DeleteMapping("/deletar")
    public String deletarFuncionario(){
        return "Deletar Funcionario";
    }

}
