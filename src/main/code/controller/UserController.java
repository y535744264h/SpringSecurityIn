package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/sayHi")
    public String toTestJSP(Map<String,Object> map){
        return "user";
    }
}
