package blog.service;

import blog.domain.Role;
import blog.repository.RoleRepository;
import blog.repository.UserRepository;
import blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void createUser(String first_name, String last_name, String username, String email, String password, String date) {

        User user = new User(first_name, last_name, username, email, password, new Date());
        List<Role> roles = new ArrayList<>();

        Role role = roleRepository.findOne(1);
        Role role2 = roleRepository.findOne(2);
        roles.add(role);
        roles.add(role2);

        user.setRoles(roles);
        repository.save(user);
    }
}
