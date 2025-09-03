package br.dev.nathan.todo_list.controller;

import br.dev.nathan.todo_list.dto.TarefaDTO;
import br.dev.nathan.todo_list.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping(value = "/{id}")
    public TarefaDTO buscarTarefaPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @GetMapping
    public List<TarefaDTO> buscarTodasTarefas() {
        return tarefaService.buscarTudo();
    }

    @PostMapping
    public void criarTarefa(@RequestBody TarefaDTO tarefa) {
        tarefaService.criar(tarefa);
    }

    @PutMapping(value = "/{id}")
    public void atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefa) {
        tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping(value = "/{id}")
    public void apagarTarefa(@PathVariable Long id) {
        tarefaService.apagar(id);
    }

}
