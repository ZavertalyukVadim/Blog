package blog.controller;

import blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ajaxtest")
public class AjaxController {
    @Autowired
    private
    CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public String ajaxTest(@RequestParam("id") Integer comment_id) {
        System.out.println(comment_id);
        commentService.deleteCommentById(comment_id);
//        return commentService.deleteCommentById(comment_id);
        return "ok";
    }
}
