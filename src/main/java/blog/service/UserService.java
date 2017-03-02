package blog.service;

import blog.domain.Role;
import blog.repository.RoleRepository;
import blog.repository.UserRepository;
import blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserById(Integer id) {
        return repository.findOne(id);
    }

    public List<User> getAllUsers() {
        List<User> users = repository.findAll();
        return users;
    }

    public User getUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    public void changeUser(Integer id, String first_name, String last_name, String username, String email, String password) {
        User user = repository.findOne(id);
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        repository.save(user);
    }

    public void createUser(User user) {
        Role role = new Role("USER");

        User currentUser = new User(user.getFirst_name(), user.getLast_name(), user.getUsername(), user.getEmail(), user.getBirthday());
        currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(currentUser);
        role.setUser_id(currentUser.getId());
        roleRepository.save(role);
    }
}
