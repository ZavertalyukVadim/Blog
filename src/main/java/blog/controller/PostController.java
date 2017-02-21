package blog.controller;

import blog.service.CategoryService;
import blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private
    PostService postService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPostById(ModelMap modelMap, @PathVariable(value = "id") String id) throws IOException {
        modelMap.addAttribute("post", postService.getPostById(Integer.parseInt(id)));
        return "aboutPost";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    String viewTemplateForAddNewPost(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.getAllCategories());
        return "addNewPost";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    String addNewPost(@RequestParam("title") String name,
                      @RequestParam("description") String description,
                      @RequestParam("content") String content,
                      @RequestParam("category_id") Integer category_id) {
        postService.addNewPost(name, description, content,category_id);
        return "redirect:/";
    }
}
