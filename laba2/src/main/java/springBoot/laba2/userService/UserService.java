package springBoot.laba2.userService;

import com.sun.source.tree.WhileLoopTree;
import org.springframework.web.bind.annotation.PathVariable;
import springBoot.laba2.model.User;
import springBoot.laba2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserPhoneNumber(String phoneNumber){
        return userRepository.findByPhoneNumber(phoneNumber);
    }
}
