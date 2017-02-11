package blog.service;

import blog.dao.PostDao;
import blog.domain.Post;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private
    PostDao postDao;

    public List<Post> getAllPost() {
        List<Post> posts = postDao.getAllPost();
        return posts;
    }

    public Post getPostById(Integer id) {
        Post post = postDao.getPostById(id);
        return post;
    }
}
