package com.luiz.CadastroDeTarefas.funcionario;


import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios(){
        return ResponseEntity.ok(funcionarioService.listarFuncionarios());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarFuncionarioPorId(@PathVariable Long id){
        FuncionarioDTO funcionarioPorId =  funcionarioService.listarFuncionarioPorId(id);

        if(funcionarioPorId != null){
            return ResponseEntity.ok(funcionarioPorId);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encotrado");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO){
        FuncionarioDTO funcionario = funcionarioService.salvarFuncionario(funcionarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcinário cadastrado!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncionarioPorId(@PathVariable Long id){
        FuncionarioDTO funcionarioDTO =  funcionarioService.listarFuncionarioPorId(id);
        if(funcionarioDTO != null){
            funcionarioService.deletarFuncionarioPorId(id);
            return ResponseEntity.ok("Funcionário deletado");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO){

        FuncionarioDTO funcionario = funcionarioService.atualizarFuncionarioPorId(id, funcionarioDTO);

        if(funcionario != null){
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário não encontrado");
        }

    }
}
