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
    public List<FuncionarioDTO> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/listar/{id}")
    public FuncionarioDTO listarFuncionarioPorId(@PathVariable Long id){
        return funcionarioService.listarFuncionarioPorId(id);
    }

    @PostMapping("/criar")
    public void criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO){
        funcionarioService.salvarFuncionario(funcionarioDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarFuncionarioPorId(@PathVariable Long id){
        funcionarioService.deletarFuncionarioPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public FuncionarioDTO atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO){
        return funcionarioService.atualizarFuncionarioPorId(id, funcionarioDTO);
    }
}
