package blog.controller;

import blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private
    UserService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("user", service.getUserByUsername(getPrincipal()));
        return "aboutUser";
    }

    @RequestMapping(value = "/changeProfile", method = RequestMethod.GET)
    public String aboutUserForChange(ModelMap model) {
        model.addAttribute("user", service.getUserByUsername(getPrincipal()));
        return "aboutUserForChange";
    }

    @RequestMapping(value = "/changeProfile", method = RequestMethod.POST)
    public String changeUser(HttpServletRequest request,
                             HttpServletResponse response,
                             ModelMap model,
                             @RequestParam("id") Integer id,
                             @RequestParam("first_name") String first_name,
                             @RequestParam("last_name") String last_name,
                             @RequestParam("username") String username,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password) {
        service.changeUser(id, first_name, last_name, username, email, password);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
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
