package ua.com.hav.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller
public class IndexController {

    private Logger logger = Logger.getLogger(IndexController.class);
    @RequestMapping("/")
    public String index() {
        System.out.println("index");
        logger.info("INDEX");
        return "index";
    }

    @RequestMapping("/number")
    public String number(Model model) {
        model.addAttribute("msg", 777);
        logger.info("NUMBER");
        return "index";
    }

    @RequestMapping("/time")
    public String date(Model model) {
        model.addAttribute("msg", new Date());
        logger.info("TIME");
        return "index";
    }
}
