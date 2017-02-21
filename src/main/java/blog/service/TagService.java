package blog.service;

import blog.dao.TagRepository;
import blog.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository repository;

    public Tag getTagById(Integer id) {
        return repository.findOne(id);
    }

    public void addNewTag(String name) {
        Tag tag = new Tag(name);
        repository.save(tag);
    }
}
