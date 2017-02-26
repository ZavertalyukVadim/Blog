package blog.service;

import blog.repository.CategoryRepository;
import blog.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Category viewAllPostsWithCurrentCategory(Integer id) {
        Category category = repository.findOne(id);
        return category;
    }

    public void addNewCategory(String name, String description) {
        Category category = new Category(name, description);
        repository.save(category);
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }
}
