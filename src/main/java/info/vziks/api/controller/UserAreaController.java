package info.vziks.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class UserAreaController
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Controller
public class UserAreaController {

    @GetMapping("/foruser/")
    public String foruser() {
        return "foruser";
    }


    @GetMapping("/foradmin/")
    public String foradmin() {
        return "foradmin";
    }

}
