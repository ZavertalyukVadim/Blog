package blog.controller;

import blog.domain.Comment;
import blog.domain.Post;
import blog.domain.Role;
import blog.domain.User;
import blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class MyController {
    @Autowired
    private
    UserService userService;

    @Autowired
    private
    PostService postService;

    @Autowired
    private
    CommentService commentService;

    @Autowired
    private
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    String viewAllPost(ModelMap modelMap) {
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("Login="+auth);
        role = !Objects.equals(auth.toString(), "anonymousUser");

        List<Post> posts = postService.getAllPost();
        List<Role> roles = roleService.viewAllRoles();
        for (Role role1:roles){
            System.out.println("Type="+role1.getType());
        }
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("posts", posts);
        return "blog";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    String login() {
//        return "login";
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        List<Post> posts = postService.getAllPost();
        modelMap.addAttribute("posts", posts);
        return "redirect:/";
    }

    @RequestMapping(value = "/access_denied")
    String error() {
        return "errorPage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "user";
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.POST)
    @ResponseBody
    public Comment ajaxTest(@RequestParam("comment_id") Integer comment_id, @RequestParam("post_id") Integer post_id) {
        return commentService.deleteCommentById(comment_id);
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "errorPage";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}