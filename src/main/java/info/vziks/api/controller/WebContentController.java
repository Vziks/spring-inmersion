package info.vziks.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:propertyContext.properties")
public class WebContentController {


    @Value( "${spring.datasource.url}" )
    private String jdbcUrl;


    @Value( "${fileProperty.number}" )
    private int fileValue;


    @GetMapping("/content")
    public String content(@RequestParam(name="content", required=false, defaultValue="Content") String content, Model model) {
        model.addAttribute("content", content);
        model.addAttribute("jdbcUrl", this.jdbcUrl);
        model.addAttribute("fileValue", this.fileValue);
        return "content";
    }
}
