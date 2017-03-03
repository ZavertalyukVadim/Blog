package blog.controller;

import blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping(value = "/tag")
public class TagController {
    @Autowired
    private
    TagService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTagById(ModelMap modelMap, @PathVariable("id") Integer id) throws IOException {
        modelMap.addAttribute("tag", service.getTagById(id));
        return "allPostWithTag";
    }

    @RequestMapping(value = "/newTag", method = RequestMethod.GET)
    String viewTemplateForAddNewCategory() {
        return "addNewTag";
    }

    @RequestMapping(value = "/newTag", method = RequestMethod.POST)
    String AddNewCategory(@RequestParam("name") String name) {
        service.addNewTag(name);
        return "redirect:/";
    }
}
