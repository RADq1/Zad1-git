package stm.stm.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import stm.stm.entity.Task;
import stm.stm.entity.User;
import stm.stm.enums.status;
import stm.stm.enums.type;
import stm.stm.repositories.TaskRepository;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    //f
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public Optional<Task> getTaskById(int taskId){
        return  taskRepository.findById(taskId);
    }
    //g
    public List<Task> selectTasks(){
        return taskRepository.findAll(Sort.by(Sort.Direction.DESC, "dateAdded"));
    }
    //h
    public List<Task> getTaskByTytleOrStatusOrType(String title,  type type, status status) {
        return taskRepository.findByTitleOrStatusOrType(title,type,status);
    }

    //i
    public Task changeTaskStatus(int taskId, status status) {
        Task task = taskRepository.findByTaskId(taskId);
        task.setStatus(status);
        return taskRepository.save(task);
    }
    //j
    public boolean deleteTaskById(int taskId){
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        getTaskById(taskId).ifPresent(user -> {
            taskRepository.deleteById(taskId);
            isDeleted.set(true);
        });
        return isDeleted.get();
    }



}
