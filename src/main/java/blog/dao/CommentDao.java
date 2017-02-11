package blog.dao;

import blog.domain.Comment;
import blog.domain.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static java.lang.Integer.parseInt;
import static org.hibernate.criterion.Restrictions.eq;

@Transactional
@Repository
public class CommentDao {
    @Autowired
    private
    SessionFactory sessionFactory;

    public Comment deleteCommentById(Integer id) {
        Comment comment = (Comment) sessionFactory.getCurrentSession().createCriteria(Comment.class)
                .add(eq("id", id)).uniqueResult();
        sessionFactory.getCurrentSession().delete(comment);
        return null;
    }

    public void addNewComment(String content, Date date, Integer post_id) {
        Comment comment = new Comment(content, date, post_id);
        sessionFactory.getCurrentSession().save(comment);
    }

    public Comment getCommentById(Integer id) {
        Comment comment=(Comment) sessionFactory.getCurrentSession().createCriteria(Comment.class)
                .add(eq("id", id))
                .uniqueResult();
        return comment;
    }

    public void updateComment(Integer id, String content) {
        Comment comment = (Comment)sessionFactory.getCurrentSession().createCriteria(Comment.class)
                .add(eq("id", id)).uniqueResult();
        comment.setContent(content);
        sessionFactory.getCurrentSession().update(comment);
    }
}
