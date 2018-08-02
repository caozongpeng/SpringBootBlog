package com.wip.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wip.controller.BaseController;
import com.wip.dto.cond.CommentCond;
import com.wip.model.CommentDomain;
import com.wip.model.UserDomain;
import com.wip.service.comment.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Api("评论相关接口")
@Controller
@RequestMapping("/admin/comments")
public class CommentController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @ApiOperation("进入评论列表页")
    @GetMapping(value = "")
    public String index(
            @ApiParam(name = "page", value = "页数", required = false)
            @RequestParam(name = "page", required = false, defaultValue = "1")
            int page,
            @ApiParam(name = "limit", value = "每页条数", required = false)
            @RequestParam(name = "limit", required = false, defaultValue = "15")
            int limit,
            HttpServletRequest request

    ) {
        UserDomain user = this.user(request);
        PageInfo<CommentDomain> comments = commentService.getCommentsByCond(new CommentCond(), page, limit);
        request.setAttribute("comments", comments);
        return "admin/comment_list";
    }

}
