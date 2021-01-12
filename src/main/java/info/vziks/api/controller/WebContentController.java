package info.vziks.api.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


/**
 * Class WebContentController
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Controller
@PropertySource("classpath:propertyContext.properties")
public class WebContentController {


    private final MessageSource messageSource;
    private final ApplicationContext applicationContext;

    public WebContentController(MessageSource messageSource, ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        logger.info("Hello from WebContentController");
        this.messageSource = messageSource;
    }

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${fileProperty.message}")
    private String myStr;

    @Value("${fileProperty.number}")
    private int fileValue;

    @Autowired
    Environment environment;

    private final Logger logger = LoggerFactory.getLogger(WebContentController.class);

    @GetMapping("/content")
    public String content(@RequestParam(name = "content", required = false, defaultValue = "Content") String content, Model model) throws UnknownHostException {

        InetAddress myHost = InetAddress.getLocalHost();
        System.out.println(myHost.getHostName());

        Locale russian = new Locale("ru", "RU");


        System.out.println(messageSource);
        System.out.println(messageSource.getMessage("helloMessage",
                new Object[]{"Paul Smith"}, russian));

        logger.info("{}", messageSource.getMessage("helloMessage",
                null, Locale.ENGLISH));

        logger.info("Hello from Logback {}", messageSource.getMessage("helloMessage",
                new Object[]{"Paul Smith"}, russian));
        logger.info("Hello from Logback {}", content);
        logger.info("Hello from this.myStr {}", this.myStr);
        model.addAttribute("content", content);
        model.addAttribute("jdbcUrl", this.jdbcUrl);
        model.addAttribute("fileValue", this.fileValue);
        return "content";
    }


    @GetMapping("/content/one")
    public String contents(Model model) {
        File file = null;
        try {
            file = File.createTempFile("test", "txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(file).deleteOnExit();

        Resource resource = applicationContext.getResource("file://" + file.getPath());
        getInfo(resource);
        Resource resource1 = applicationContext.getResource("classpath:test.txt");
        getInfo(resource1);
        Resource resource2 = applicationContext.getResource("https://www.google.ru");
        getInfo(resource2);
        return "content";
    }


    @GetMapping("/content/two")
    public String two(HttpServletRequest request) {



        List<Integer> list = new ArrayList<>();

        list.add(5);

        System.out.println(request.getParameterMap());
        return "content";
    }

    private void getInfo(Resource resource) {

        System.out.println(resource.getClass());
        try {
            System.out.println(resource.getURL().getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
