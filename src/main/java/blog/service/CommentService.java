package blog.service;

import blog.dao.CommentDao;
import blog.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {
    @Autowired
    private
    CommentDao commentDao;

    public Comment deleteCommentById(Integer id) {
        return commentDao.deleteCommentById(id);
    }

    public void addNewComment( String content,Integer post_id) {
        commentDao.addNewComment(content,new Date(),post_id);
    }

    public Comment getCommentById(Integer id) {
        Comment comment = commentDao.getCommentById(id);
        return comment;
    }

    public void updateComment(Integer id, String content) {
        commentDao.updateComment(id,content);
    }
}
