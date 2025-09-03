package br.dev.nathan.todo_list.repository;

import br.dev.nathan.todo_list.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
}
