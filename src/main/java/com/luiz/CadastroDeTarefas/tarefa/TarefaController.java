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
    public List<TarefaModel> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    // GETBYID - Lista tarefa por id
    @GetMapping("/listar/{id}")
    public TarefaModel listarTarefasPorId(@PathVariable Long id) {
        return tarefaService.listarTarefaPorId(id);
    }

    // POST - Cria tarefa
    @PostMapping("/criar")
    public TarefaModel criarTarefa(@RequestBody TarefaModel tarefaModel) {
        return tarefaService.criarTarefa(tarefaModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTarefaPorId(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
    }

}
