package blog.service;

import blog.repository.CommentRepository;
import blog.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {
    @Autowired
    private
    CommentRepository repository;

    public Comment deleteCommentById(Integer id) {
        repository.delete(id);
        return null;
    }

    public void addNewComment(String content, Integer post_id) {
        Comment comment = new Comment(content, new Date(), post_id);
        repository.save(comment);
//        return comment;
    }

    public Comment getCommentById(Integer id) {
        Comment comment = repository.findOne(id);
        return comment;
    }

    public void updateComment(Integer id, String content) {
        Comment comment = repository.findOne(id);
        comment.setContent(content);
        repository.save(comment);
    }
}
