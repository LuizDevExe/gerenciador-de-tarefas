package com.luiz.CadastroDeTarefas.tarefa;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // Lista todas as tarefas
    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    // Lista Tarefa por id
    public TarefaModel listarTarefaPorId(Long id) {
        Optional<TarefaModel> tarefa = tarefaRepository.findById(id);
        return tarefa.orElse(null);
    }

    // Cria tarefa
    public TarefaModel criarTarefa(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }

    // Deleta a tarefa

    public void  deletarTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }
}
