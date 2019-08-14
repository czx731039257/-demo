package com.csx.demo2.aspect;

import com.csx.demo2.dao.MethodDao;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Aspect
@Component
public class MessageAspect {

    @Autowired
    private MethodDao methodDao;

    /**
     * 切入点 MessageController中的SelectMessageByUserNameController、SelectPersonMessageController、SelectGroupMessageController、SelectOtherGroupMessageController、SelectAllMessageController
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.csx.demo2.controller.MessageController.*(..))&&!execution(* com.csx.demo2.controller.MessageController.IntoEditMessageController(..))")
    public Object Log_Message(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        Object[] args = joinPoint.getArgs();
        String method_url = joinPoint.getSignature().getName();
        HttpSession session = ((HttpServletRequest) args[0]).getSession();
        User user=(User)session.getAttribute("user");
        String logmsg= (String) session.getAttribute("logmsg");
        //List<Message> messages= (List<Message>)session.getAttribute("messageSet");
        System.out.println("用户名："+user.getName()+" 用户id:"+user.getId()+" 操作:"+methodDao.selectByUrl(method_url).getMethod_name()+" \n返回结果："+logmsg);
        return proceed;
    }

}
