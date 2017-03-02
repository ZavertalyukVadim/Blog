package blog.controller;

import blog.domain.Comment;
import blog.domain.Post;
import blog.domain.Role;
import blog.domain.User;
import blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @RequestMapping(method = RequestMethod.GET)
    String viewAllPost(ModelMap modelMap) {
        Boolean role;
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        role = !Objects.equals(auth.toString(), "anonymousUser");

        List<Post> posts = postService.getAllPost();
        modelMap.addAttribute("role", role);
        modelMap.addAttribute("posts", posts);
        return "blog";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    String addNewUser(@Valid User user){
        userService.createUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    String registration() {
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String authorization(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        userDetailsService.loadUserByUsername(username);
        return "redirect:/";
    }

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
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
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