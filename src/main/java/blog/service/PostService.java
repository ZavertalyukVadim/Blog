package blog.service;

import blog.dao.PostRepository;
import blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getAllPost() {
//        List<Post> posts = postDao.getAllPost();
        List<Post> posts = repository.findAll();
        return posts;
    }

    public Post getPostById(Integer id) {
//        Post post = postDao.getPostById(id);
        Post post = repository.findOne(id);
        return post;
    }

    public void addNewPost(String name, String description, String content,Integer category_id) {
        Post post = new Post(name,description,content,new Date(), category_id);
        repository.save(post);
    }
}
