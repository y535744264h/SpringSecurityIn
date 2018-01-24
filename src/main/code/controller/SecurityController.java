package controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SecurityController {

    private  Logger log = Logger.getLogger(SecurityController.class);

    @RequestMapping("/login")
    public String toLogin(){
        System.out.println("登陆");
        System.out.println();
        return "tologin";
    }
    @RequestMapping("/sorry")
    public String toSorry(){
        System.out.println("sorry");
        System.out.println();
        return "sorry";
    }
    @RequestMapping("index")
    public String toIndex(){
        System.out.println("index");
        System.out.println();
        return "index";
    }
    @RequestMapping("logout")
    public String toLogout(HttpServletResponse response, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/index";
    }
}
