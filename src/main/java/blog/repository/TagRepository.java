package blog.repository;


import blog.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findByName(String name);

    List<Tag> findByNameNotLike(String name);
}
