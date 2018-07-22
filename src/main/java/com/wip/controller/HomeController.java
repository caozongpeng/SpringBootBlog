package com.wip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "blog/home";
    }

    @RequestMapping(value = "/archives")
    public String archives() {
        return "blog/archives";
    }

    @RequestMapping(value = "/categories")
    public String categories() {
        return "blog/category";
    }

    @RequestMapping(value = "/tags")
    public String tags() {
        return "blog/tags";
    }

    @RequestMapping(value = "/about")
    public String about() {
        return "blog/about";
    }

    @RequestMapping(value = "/detail")
    public String detail() {
        return "blog/detail";
    }

}
