package stm.stm.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stm.stm.entity.*;
import stm.stm.enums.*;
import stm.stm.repositories.*;
import stm.stm.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    //a
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    //b
    public List<User> selectUsers() {
        return userRepository.findAll();
    }

    //c
    public List<User> getUserByEmailOrId(Integer userId, String email) {
        return userRepository.findByUserIdOrEmail(userId,email);
    }

    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }
    //d
    public boolean activateUser(int userId){

        Optional<User> userOptional = getUserById(userId);
        if(userOptional.isPresent()){
            User userToActivate = userOptional.get();
            if(userToActivate.getStatus()){
                userToActivate.setStatus(false);
            }else{
                userToActivate.setStatus(true);
            }
            userRepository.save(userToActivate);     // działa jak update gdy dotyczy istniejącego w repo obiektu
        }
        return userOptional.get().getStatus();

    }

    //e
    public boolean deleteUserById(int userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()) {
            for (Task task : taskRepository.findTasksByUserId(userId)) {
                taskRepository.delete(task);
            }
            userRepository.delete(optionalUser.get());
            return true;
        }
        return false;
    }

}
