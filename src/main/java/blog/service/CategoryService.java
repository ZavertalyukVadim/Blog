package blog.service;

import blog.dao.CategoryRepository;
import blog.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category viewAllPostsWithCurrentCategory(Integer id){
        Category category = categoryRepository.findOne(id);
        return category;
    }

}
