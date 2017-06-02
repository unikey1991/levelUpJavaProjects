package ua.dp.levelup.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Shegeda Alexandr (https://www.luxoft.com).
 */
@Controller
public class MainController {

  // inject via application.properties
  @Value("${welcome.message:test}")
  private String message = "Hello World";
//
//  @RequestMapping("/")
//  @ResponseBody
//  public String index() {
//    return "<a href='/welcome'>Welcome Page</a>";
//  }
//
//  @RequestMapping("/welcome")
//  public String welcome(Map<String, Object> model) {
//    model.put("message", message);
//    return "welcome";
//  }

  @RequestMapping("/hello")
  public String hello(Map<String, Object> model) {
    return "hello";
  }

  @RequestMapping("/welcome")
  public String welcome(Map<String, Object> model) {
    model.put("message", message);
    return "welcome";
  }

}
