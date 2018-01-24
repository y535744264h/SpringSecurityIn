package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping("/admin")
public class TestController {

    @RequestMapping("/sayHi")
    public String toTestJSP(Map<String,Object> map){
        String sayHi="Hi,My is Spring MVC";
        map.put("sayHi",sayHi);
        return "test";
    }
}
