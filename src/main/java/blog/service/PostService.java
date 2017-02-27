package blog.service;

import blog.repository.PostRepository;
import blog.domain.Post;
import blog.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getAllPost() {
        List<Post> posts = repository.findAll();
        return posts;
    }

    public Post getPostById(Integer id) {
        Post post = repository.findOne(id);
        return post;
    }

    public void addNewPost(String name, String description, String content, Integer category_id, List<Tag> tagList) {
        List<Post> postList = new ArrayList<>();
        Post post = new Post(name, description, content, new Date(), category_id);
        postList.add(post);
        post.setTags(tagList);
        for (Tag tag : post.getTags()) {
            tag.setPosts(postList);
        }
        repository.save(post);
    }
}
