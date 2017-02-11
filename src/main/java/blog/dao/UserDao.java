package blog.dao;

import blog.domain.Comment;
import blog.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao {
    @Autowired
    private
    SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(User.class);
        List<User> users = (List<User>) criteria.list();
        for (User user : users) {
            user.getFirst_name();
            user.getAuthor().getUser_id();
            for (Comment comment : user.getComments()) {
                comment.getContent();
            }
        }
        return users;
    }
}
