package blog.controller;

import blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ajaxtest")
public class AjaxController {
    @Autowired
    private
    CommentService commentService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public void ajaxTest( @PathVariable("id") Integer id) {
        commentService.deleteCommentById(id);
    }
}
