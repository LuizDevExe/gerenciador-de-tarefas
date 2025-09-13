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

    @GetMapping("/listar")
    public List<TarefaModel> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/listar/{id}")
    public TarefaModel listarTarefasPorId(@PathVariable Long id) {
        return tarefaService.listarTarefaPorId(id);
    }

    @PostMapping("/criar")
    public TarefaModel criarTarefa(@RequestBody TarefaModel tarefaModel) {
        return tarefaService.criarTarefa(tarefaModel);
    }
}
