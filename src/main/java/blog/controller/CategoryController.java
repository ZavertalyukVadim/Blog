package blog.controller;

import blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    String viewAllPostsWithCurrentCategory(ModelMap modelMap, @PathVariable("id") Integer id) {
        modelMap.addAttribute("category", categoryService.viewAllPostsWithCurrentCategory(id));
        return "viewAllPostsWithCurrentCategory";
    }

    @RequestMapping(value = "/newCategory", method = RequestMethod.GET)
    String viewTemplateForAddNewCategory() {
        return "addNewCategory";
    }

    @RequestMapping(value = "/newCategory", method = RequestMethod.POST)
    String AddNewCategory(@RequestParam("name") String name, @RequestParam("description") String description) {
        categoryService.addNewCategory(name, description);
        return "redirect:/";
    }
}
