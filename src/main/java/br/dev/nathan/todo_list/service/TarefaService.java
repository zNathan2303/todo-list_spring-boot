package br.dev.nathan.todo_list.service;

import br.dev.nathan.todo_list.dto.TarefaDTO;
import br.dev.nathan.todo_list.entity.TarefaEntity;
import br.dev.nathan.todo_list.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefaDTO buscarPorId(Long id) {
        TarefaEntity tarefa = tarefaRepository.findById(id).get();
        return new TarefaDTO(tarefa);
    }

    public List<TarefaDTO> buscarTudo() {
        List<TarefaEntity> tarefas = tarefaRepository.findAll();
        return tarefas.stream().map(TarefaDTO::new).toList();
    }

    public void criar(TarefaDTO tarefa) {
        TarefaEntity tarefaEntity = new TarefaEntity(tarefa);
        tarefaRepository.save(tarefaEntity);
    }

    public void atualizar(Long id, TarefaDTO tarefa) {
        TarefaEntity tarefaEntity = tarefaRepository.findById(id).get();
        tarefaEntity.setDescricao(tarefa.getDescricao());
        tarefaEntity.setTitulo(tarefa.getTitulo());
        tarefaRepository.save(tarefaEntity);
    }

    public void apagar(Long id) {
        TarefaEntity tarefa = tarefaRepository.findById(id).get();
        tarefaRepository.delete(tarefa);
    }
}
