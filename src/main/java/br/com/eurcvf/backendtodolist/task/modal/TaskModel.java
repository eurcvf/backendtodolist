package br.com.eurcvf.backendtodolist.task.modal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "tb_tasks")
@Getter
@Setter
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(length = 50)
    private String title;
    @NotBlank
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    @NotBlank
    private String priority;

    private UUID userId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception {
        if (title.length() > 50) {
            throw new Exception("O campo title deve ter no máximo 50 caracteres!");
        }

        this.title = title;
    }

}
