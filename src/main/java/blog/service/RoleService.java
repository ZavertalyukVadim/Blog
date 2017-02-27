package blog.service;

import blog.domain.Role;
import blog.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository repository;

    public List<Role> viewAllRoles() {
        List<Role> roles = repository.findAll();
        return roles;
    }
}
