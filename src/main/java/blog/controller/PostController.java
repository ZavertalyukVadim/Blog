package blog.controller;

import blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private
    PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPostById(ModelMap modelMap, @PathVariable(value = "id") String id) throws IOException {
        modelMap.addAttribute("post", postService.getPostById(Integer.parseInt(id)));
        return "aboutPost";
    }
}
