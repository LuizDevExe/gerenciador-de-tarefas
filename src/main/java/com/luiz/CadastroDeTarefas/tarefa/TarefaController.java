package com.luiz.CadastroDeTarefas.tarefa;

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
    public List<TarefaDTO> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    // GETBYID - Lista tarefa por id
    @GetMapping("/listar/{id}")
    public TarefaDTO listarTarefasPorId(@PathVariable Long id) {
        return tarefaService.listarTarefaPorId(id);
    }

    // POST - Cria tarefa
    @PostMapping("/criar")
    public TarefaDTO criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.criarTarefa(tarefaDTO);
    }

    // DELETE - Deleta tarefa por id
    @DeleteMapping("/deletar/{id}")
    public void deletarTarefaPorId(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
    }

    // UPDATE - Atualiza tarefa por id de maneira inteiriça
    @PutMapping("/atualizar/{id}")
    public TarefaDTO atualizarTarefaPorId(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.atualizarTarefaPorId(id, tarefaDTO);
    }
}
