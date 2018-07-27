package com.wip.controller.admin;

import com.wip.constant.LogActions;
import com.wip.constant.WebConst;
import com.wip.controller.BaseController;
import com.wip.model.OptionsDomain;
import com.wip.service.log.LogService;
import com.wip.service.option.OptionService;
import com.wip.utils.APIResponse;
import com.wip.utils.GsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("系统设置管理")
@Controller
@RequestMapping("admin/setting")
public class SettingController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingController.class);

    @Autowired
    private OptionService optionService;

    @Autowired
    private LogService logService;


    @ApiOperation("进入设置页")
    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        List<OptionsDomain> optionsList = optionService.getOptions();
        Map<String, String> options = new HashMap<>();
        optionsList.forEach((option) ->{
            options.put(option.getName(),option.getValue());
        });
        request.setAttribute("options", options);
        return "admin/setting";
    }

    @ApiOperation("保存系统设置")
    @PostMapping(value = "")
    @ResponseBody
    public APIResponse saveSetting(HttpServletRequest request) {

        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String, String> querys = new HashMap<>();
            parameterMap.forEach((key, value) -> {
            //System.out.println(key + "------" + join(value));
                querys.put(key, join(value));
            });

            optionService.saveOptions(querys);
            WebConst.initConfig = querys;

            // 写入日志
            logService.addLog(LogActions.SYS_SETTING.getAction(),GsonUtils.toJsonString(querys),request.getRemoteAddr(),this.getUid(request));
            return APIResponse.success();

        } catch (Exception e) {
            String msg = "保存设置失败";
            return APIResponse.fail(e.getMessage());
        }
    }

}
