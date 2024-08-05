package com.rocket.tasklist.Controllers;

import com.rocket.tasklist.Models.TaskModel;
import com.rocket.tasklist.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // route to obtain all tasks
    @GetMapping("/list")
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        List<TaskModel> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // route to get a single task by its id
    @GetMapping("/{id}/task")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Long id) {
        TaskModel task = taskService.getTaskById(id);
        if(task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // create a new task
    @PostMapping("/create")
    public ResponseEntity<Void> createTask(@RequestBody TaskModel task) {
        taskService.createTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // update a task
    @PutMapping("/{id}/edit")
    public ResponseEntity<TaskModel> updateTask(@PathVariable Long id, @RequestBody TaskModel task) {
        TaskModel existingTask = taskService.getTaskById(id);
        if(existingTask != null) {
            task.setId(id);
            taskService.updateTask(task);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete a task
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        TaskModel existingTask = taskService.getTaskById(id);
        if(existingTask != null) {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // get completed tasks
    @GetMapping("/completed")
    public ResponseEntity<List<TaskModel>> getCompletedTasks() {
        List<TaskModel> tasks = taskService.getCompletedTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

}
