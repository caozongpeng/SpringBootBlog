package com.wip.controller;

import com.wip.service.article.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Api("博客前台页面")
@Controller
public class HomeController extends BaseController {

    @Autowired
    private ContentService contentService;

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
