package blog.controller;

import blog.domain.Comment;
import blog.domain.Post;
import blog.domain.User;
import blog.service.CommentService;
import blog.service.PostService;
import blog.service.TagService;
import blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MyController {
    @Autowired
    private
    UserService userService;

    @Autowired
    private
    PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home(ModelMap modelMap) {
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("users", users);
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET)
    String viewAllPost(ModelMap modelMap) {
        List<Post> posts = postService.getAllPost();
        modelMap.addAttribute("posts", posts);
        return "blog";
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.POST)
    @ResponseBody
    public Comment ajaxTest(@RequestParam("comment_id") Integer comment_id, @RequestParam("post_id") Integer post_id) {
      return commentService.deleteCommentById(comment_id);
    }

}