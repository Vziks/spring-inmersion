package info.vziks.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class WebContentController
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Controller
public class WebContentController {

    @GetMapping("/content")
    public String content(@RequestParam(name="content", required=false, defaultValue="Content") String content, Model model) {
        model.addAttribute("content", content);
        return "content";
    }
}
