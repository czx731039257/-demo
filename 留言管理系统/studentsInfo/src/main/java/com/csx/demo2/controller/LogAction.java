package com.csx.demo2.controller;

import com.csx.demo2.entity.*;
import com.csx.demo2.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LogAction {

    @Autowired
    private LogService logService;

    /**
     * 查询日志
     *
     * @param req
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/queryLogs")
    public Page queryLogs(HttpServletRequest req) throws IOException {
        Integer pageNumber = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("rows"));
        String username = req.getParameter("username");
        Page page = new Page.Builder().pageNumber(pageNumber).pageSize(pageSize).startIndex((pageNumber - 1) * pageSize).build();
        Page pagebean = null;
        if (StringUtils.isNoBlank(username)) {
            User user = new User.Builder().name(username).build();
            page.setLog(new Log.Builder().user(user).build());
            page = logService.findpage(page);
        } else {
            page = logService.findpage(page);
        }

        return page;
    }

    /**
     * 清空日志记录
     *
     * @param req
     * @return
     * @throws IOException
     */

    @ResponseBody
    @RequestMapping("/emptyLogs")
    public Result emptyLogs(HttpServletRequest req) throws IOException {
        boolean i = logService.emptyLogs();
        if (i) {//如果清空成功
            return new Result.Builder().successMsg("清空日志成功").build();
        } else {
            return new Result.Builder().errorMsg("清空日志失败").build();
        }
    }
}
