package br.com.eurcvf.backendtodolist.task.repositories;

import br.com.eurcvf.backendtodolist.task.modal.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskModel, UUID> {
    List<TaskModel> findByUserId(UUID userId);
    TaskModel findByIdAndUserId(UUID id, UUID userId);
}
