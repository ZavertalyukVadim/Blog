package blog.dao;

import blog.domain.Comment;
import blog.domain.Post;
import blog.domain.Tag;
import blog.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
@Transactional
public class PostDao {
    @Autowired
    private
    SessionFactory sessionFactory;

    public List<Post> getAllPost() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(Post.class);
        List<Post> posts = (List<Post>) criteria.list();
        for (Post post:posts){
            post.getCategory().getName();
            for (Tag tag :post.getTags()){
                tag.getName();

            }
        }
        return posts;
    }

    public Post getPostById(Integer id) {
        Post post = (Post) sessionFactory.getCurrentSession().createCriteria(Post.class)
                .add(eq("id", id))
                .uniqueResult();
        post.getCategory().getName();
        for (Tag tag:post.getTags()){
            tag.getName();
        }
        post.getAuthor().getUser().getUsername();
        for (Comment comment:  post.getComments()) {
            comment.getContent();
        }
        return post;
    }
}
