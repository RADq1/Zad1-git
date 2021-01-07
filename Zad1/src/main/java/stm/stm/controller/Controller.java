package stm.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import stm.stm.entity.*;
import stm.stm.enums.*;
import stm.stm.services.*;


import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@EnableSwagger2
public class Controller {
    private UserService userService;
    private TaskService taskService;

    @Autowired
    public Controller(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }
    //a
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.selectUsers();
    }
    //b
    @PostMapping("/users/create")
    public User createUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        return userService.insertUser(new User(name,lastName,email,password, LocalDateTime.now(),false));
    }
    //c
    @GetMapping("users/IdOrEmail")
    public List<User> getByEmail(Integer userId,String email){
        return userService.getUserByEmailOrId(userId,email);
    }
    //d
    @PutMapping("/users/activate/id={userId}")
    public boolean activateUser(
            @PathVariable("userId") int userId
    ){
        return userService.activateUser(userId);
    }
    //e
    @DeleteMapping("/users/delete")
    public boolean deleteUserById(
            @RequestParam("userId") int userId
    ){
        return userService.deleteUserById(userId);
    }
    //f
    @PostMapping("/tasks/create")
    public Task createTask(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("type") type type,
            @RequestParam("status") status status,
            @RequestParam("user_id") User userId

    ){
        return taskService.createTask(new Task(title,description,LocalDateTime.now(),type,status,userId));
    }
    //g
    @GetMapping("/tasks/date")
    public List<Task> getAllTasks(){
        return taskService.selectTasks();
    }
    //h
    @GetMapping("tasks/TitleOrStatusOrType")
    public List<Task> getByTitleOrStatusOrType(String title, type type, status status){
        return taskService.getTaskByTytleOrStatusOrType(title,type,status);
    }

    //j
    @DeleteMapping("/tasks/delete")
    public boolean deleteTaskById(
            @RequestParam("taskId") int taskId
    ){
        return taskService.deleteTaskById(taskId);
    }
    //i
    @PutMapping("/task/status/id={taskId}")
    public Task changeTaskStatus(
            @PathVariable("taskId") int taskId,
            @RequestParam("status") status status
    ) {
        return taskService.changeTaskStatus(taskId,status);
    }



}
