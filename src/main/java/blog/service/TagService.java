package blog.service;

import blog.dao.TagDao;
import blog.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private
    TagDao tagDao;

    public Tag getTagById(Integer id){
        return tagDao.getTagById(id);
    }
}
