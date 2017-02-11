package blog.dao;

import blog.domain.Post;
import blog.domain.Tag;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.hibernate.criterion.Restrictions.eq;

@Transactional
@Repository
public class TagDao {
    @Autowired
    private
    SessionFactory sessionFactory;

    public Tag getTagById(Integer id){
        Tag tag = (Tag) sessionFactory.getCurrentSession().createCriteria(Tag.class)
                .add(eq("id", id))
                .uniqueResult();
        tag.getName();
        for (Post post:tag.getPosts()){
            post.getTitle();
            post.getCategory().getName();
            for (Tag tag1:post.getTags()){
                tag1.getName();
            }
        }
        return tag;
    }


}
