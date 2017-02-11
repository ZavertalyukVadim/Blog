package blog.service;

import blog.dao.UserDao;
import blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private
    UserDao userDao;

    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        return users;
    }
}
