package springBoot.laba2.userController;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import springBoot.laba2.model.User;
import springBoot.laba2.userService.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("Отримано запит на отримання всіх користувачів");
        try {
            List<User> users = userService.getAllUsers();
            logger.info("Повернено {} користувачів", users.size());
            return users;
        } catch (Exception e) {
            logger.error("Помилка під час отримання всіх користувачів", e);
            throw e;
        }
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.info("Отримано запит на створення користувача: {}", user);
        try {
            User createdUser = userService.createUser(user);
            if (createdUser != null) {
                logger.info("Створено користувача з email: {}", createdUser.getEmail());
            } else {
                logger.warn("Не вдалося створити користувача: {}", user);
            }
            return createdUser;
        } catch (Exception e) {
            logger.error("Помилка під час створення користувача: {}", user, e);
            throw e;
        }
    }
    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/phone/{phoneNumber}")
    public Optional<User> getUserByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.getUserPhoneNumber(phoneNumber);
    }





}
