package blog.service;

import blog.dao.UserRepository;
import blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        List<User> users = repository.findAll();
        return users;
    }
}
