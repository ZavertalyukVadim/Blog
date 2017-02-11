package blog.controller;

import blog.service.CommentService;
import blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private
    CommentService commentService;

    @Autowired
    private
    PostService postService;

    @RequestMapping(value = "{id}/delete",method = RequestMethod.POST)
    public String deleteComment(@PathVariable("id") Integer commId, @RequestParam("id") Integer id) {
        commentService.deleteCommentById(commId);
        return "redirect:/post/"+id;
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String viewPostForNewComment(@RequestParam("id") Integer id,ModelMap modelMap){
        modelMap.addAttribute("post",postService.getPostById(id));
        return "addCommentForPost";
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String viewPostForChangeComment(@RequestParam("post_id") Integer post_id,@RequestParam("comm_id") Integer comm_id,ModelMap modelMap){
        modelMap.addAttribute("post",postService.getPostById(post_id));
        modelMap.addAttribute("comm",commentService.getCommentById(comm_id));
        return "changeCommentForPost";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String addNewComment(@RequestParam("id") Integer post_id,@RequestParam("content") String content,ModelMap modelMap){
        commentService.addNewComment(content,post_id);
        modelMap.addAttribute("post",postService.getPostById(post_id));
        return "redirect:/post/"+post_id;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String changeComment(@RequestParam("comm_id") Integer comm_id,@RequestParam("content") String content,@RequestParam("post_id") Integer post_id,ModelMap modelMap){
        commentService.updateComment(comm_id,content);
        modelMap.addAttribute("post",postService.getPostById(post_id));
        return "redirect:/post/"+post_id;
    }
}
