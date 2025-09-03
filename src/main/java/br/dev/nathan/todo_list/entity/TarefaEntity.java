package br.dev.nathan.todo_list.entity;

import br.dev.nathan.todo_list.dto.TarefaDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "tbl_tarefa")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TarefaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    public TarefaEntity(TarefaDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
