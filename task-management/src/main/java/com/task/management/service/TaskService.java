package com.task.management.service;

import com.task.management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.task.management.entity.Task;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {

        try {
            System.out.println("Getting all tasks on node: " + InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Hostname could not be resolved");
        }

        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
