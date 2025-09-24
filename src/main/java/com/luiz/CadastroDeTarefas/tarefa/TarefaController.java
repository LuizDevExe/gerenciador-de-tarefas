package com.luiz.CadastroDeTarefas.tarefa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // GET - Lista todas as tarefas
    @GetMapping("/listar")
    public ResponseEntity<List<TarefaDTO>> listarTarefas() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    // GETBYID - Lista tarefa por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarTarefasPorId(@PathVariable Long id) {
        TarefaDTO tarefa = tarefaService.listarTarefaPorId(id);

        if(tarefa != null){
            return ResponseEntity.ok(tarefa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada!");
        }
    }

    // POST - Cria tarefa
    @PostMapping("/criar")
    public TarefaDTO criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.criarTarefa(tarefaDTO);
    }

    // DELETE - Deleta tarefa por id
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTarefaPorId(@PathVariable Long id) {
        TarefaDTO tarefa = tarefaService.listarTarefaPorId(id);

        if(tarefa != null){
            tarefaService.deletarTarefaPorId(id);
            return ResponseEntity.ok("Tarefa removida com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa não encontrada!");
        }
    }

    // UPDATE - Atualiza tarefa por id de maneira inteiriça
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarTarefaPorId(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefa = tarefaService.atualizarTarefaPorId(id,tarefaDTO);

        if(tarefa != null){
            tarefaService.atualizarTarefaPorId(id, tarefaDTO);
            return ResponseEntity.ok(tarefa);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada!");
        }
    }
}
