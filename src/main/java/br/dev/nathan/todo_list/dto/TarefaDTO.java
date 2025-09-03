package br.dev.nathan.todo_list.dto;

import br.dev.nathan.todo_list.entity.TarefaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class TarefaDTO {
    private Long id;
    private String titulo;
    private String descricao;

    public TarefaDTO(TarefaEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
