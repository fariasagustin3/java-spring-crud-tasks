package com.rocket.tasklist.Services;

import com.rocket.tasklist.Mapper.TaskMapper;
import com.rocket.tasklist.Models.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    // get all tasks
    public List<TaskModel> getAllTasks() {
        return taskMapper.findAll();
    }

    // get task by id
    public TaskModel getTaskById(Long id) {
        return taskMapper.findById(id);
    }

    // create task
    public void createTask(TaskModel task) {
        taskMapper.create(task);
    }

    // update task
    public void updateTask(TaskModel task) {
        taskMapper.update(task);
    }

    // delete task
    public void deleteTask(Long id) {
        taskMapper.delete(id);
    }

    // get completed tasks
    public List<TaskModel> getCompletedTasks() {
        return taskMapper.getCompleted();
    }

}
