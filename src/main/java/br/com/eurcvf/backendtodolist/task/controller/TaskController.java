package br.com.eurcvf.backendtodolist.task.controller;

import br.com.eurcvf.backendtodolist.task.modal.TaskModel;
import br.com.eurcvf.backendtodolist.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel) {
        var task = this.taskRepository.save(taskModel);
        return task;
    }

}
