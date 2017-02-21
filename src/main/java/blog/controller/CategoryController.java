package blog.controller;

import blog.dao.CategoryRepository;
import blog.domain.Category;
import blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    String viewAllPostsWithCurrentCategory(ModelMap modelMap, @PathVariable("id") Integer id){
        modelMap.addAttribute("category",categoryService.viewAllPostsWithCurrentCategory(id));
        return "viewAllPostsWithCurrentCategory";
    }
}
