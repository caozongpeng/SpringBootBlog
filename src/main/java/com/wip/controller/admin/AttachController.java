package com.wip.controller.admin;

import com.wip.controller.BaseController;
import com.wip.service.attach.AttAchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api("文件管理")
@Controller
@RequestMapping("admin/attach")
public class AttachController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttachController.class);

    @Autowired
    private AttAchService attAchService;



    @ApiOperation("文件管理首页")
    @GetMapping(value = "")
    public String index() {
        return "admin/attach";
    }

}
