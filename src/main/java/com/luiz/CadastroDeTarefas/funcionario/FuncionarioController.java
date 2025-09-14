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

    @GetMapping("/listar")
    public List<FuncionarioModel> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/listar/{id}")
    public FuncionarioModel listarFuncionarioPorId(@PathVariable Long id){
        return funcionarioService.listarFuncionarioPorId(id);
    }

    @PostMapping("/criar")
    public void criarFuncionario(@RequestBody FuncionarioModel funcionarioModel){
        funcionarioService.salvarFuncionario(funcionarioModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarFuncionarioPorId(@PathVariable Long id){
        funcionarioService.deletarFuncionarioPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public FuncionarioModel atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel){
        return funcionarioService.atualizarFuncionarioPorId(id, funcionarioModel);
    }
}
