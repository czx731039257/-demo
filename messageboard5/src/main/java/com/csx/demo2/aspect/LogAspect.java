package com.csx.demo2.aspect;

import com.csx.demo2.dao.LogDao;
import com.csx.demo2.dao.MethodDao;
import com.csx.demo2.entity.Log;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private MethodDao methodDao;

    @Autowired
    private LogDao logDao;
    /**
     * 切入点 MessageController中的SelectMessageByUserNameController、SelectPersonMessageController、SelectGroupMessageController、SelectOtherGroupMessageController、SelectAllMessageController
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("(execution(* com.csx.demo2.controller.MessageController.*(..))||execution(* com.csx.demo2.controller.UserController.*(..))||execution(* com.csx.demo2.controller.RoleController.*(..))||execution(* com.csx.demo2.controller.PermissionController.*(..)))" +
            "&&!execution(* com.csx.demo2.controller.MessageController.IntoEditMessageController(..))" +
            "&&!execution(* com.csx.demo2.controller.UserController.EditUserInfoController(..))" +
            "&&!execution(* com.csx.demo2.controller.UserController.CancelUserController(..))"+
            "&&!execution(* com.csx.demo2.controller.UserController.uploadhead(..))"+
            "&&!execution(* com.csx.demo2.controller.UserController.changehead(..))")
    public Object Log_Message(ProceedingJoinPoint joinPoint) throws Throwable {
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Long pre=System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        Long post=System.currentTimeMillis();

        String date1=dateFormat.format(date);
        Object[] args = joinPoint.getArgs();
        String method_url = joinPoint.getSignature().getName();
        HttpSession session = ((HttpServletRequest) args[0]).getSession();
        User user=(User)session.getAttribute("user");
        String logmsg= (String) session.getAttribute("logmsg");
        System.out.println("用户名："+user.getName()+" 用户id:"+user.getId()+" 操作:"+methodDao.selectByUrl(method_url).getMethod_name()+" 耗时："+(post-pre)+"返回结果："+logmsg);
        logDao.insert(new Log(user.getName(),user.getId(),methodDao.selectByUrl(method_url).getMethod_name(),(int)(post-pre),logmsg,date1));
        return proceed;
    }


    @Around("execution(* com.csx.demo2.controller.UserController.CancelUserController(..))")
    public Object CancelUser(ProceedingJoinPoint joinPoint) throws Throwable {
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Object[] args = joinPoint.getArgs();
        String method_url = joinPoint.getSignature().getName();
        HttpSession session = ((HttpServletRequest) args[0]).getSession();
        User user = (User)session.getAttribute("user");
        String logmsg = (String)session.getAttribute("logmsg");

        Long pre=System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        Long post=System.currentTimeMillis();

        String date1=dateFormat.format(date);
        System.out.println("用户名："+user.getName()+" 用户id:"+user.getId()+" 操作："+methodDao.selectByUrl(method_url).getMethod_name()+" 耗时："+(post-pre)+" 返回结果："+logmsg);
        logDao.insert(new Log(user.getName(),user.getId(),methodDao.selectByUrl(method_url).getMethod_name(),(int)(post-pre),logmsg,date1));
        return proceed;
    }


//    @Around("execution(* com.csx.demo2.controller.LoginController.LoginController(..))")
//    public Object login(ProceedingJoinPoint joinPoint) throws Throwable {
//        Date date=new Date();
//        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Object[] args = joinPoint.getArgs();
//        String method_url = joinPoint.getSignature().getName();
//        HttpSession session = ((HttpServletRequest) args[0]).getSession();
//        User user=null;
//
//        Long pre=System.currentTimeMillis();
//        Object proceed = joinPoint.proceed();
//        Long post=System.currentTimeMillis();
//
//        String date1=dateFormat.format(date);
//        String logmsg = (String)session.getAttribute("logmsg");
//        Integer loginflag = (Integer)session.getAttribute("loginflag");
//        if(loginflag==2){
//            user = (User)session.getAttribute("user");
//            System.out.println("用户名："+user.getName()+" 用户id:"+user.getId()+" 操作："+methodDao.selectByUrl(method_url).getMethod_name()+" 耗时："+(post-pre)+" 返回结果："+logmsg);
//            logDao.insert(new Log(user.getName(),user.getId(),methodDao.selectByUrl(method_url).getMethod_name(),(int)(post-pre),logmsg,date1));
//        }else if(loginflag==1){
//            user = (User)session.getAttribute("failuser");
//            System.out.println("用户名："+user.getName()+" 用户id:"+user.getId()+" 操作："+methodDao.selectByUrl(method_url).getMethod_name()+" 耗时："+(post-pre)+" 返回结果："+logmsg);
//            logDao.insert(new Log(user.getName(),user.getId(),methodDao.selectByUrl(method_url).getMethod_name(),(int)(post-pre),logmsg,date1));
//        }
//           return proceed;
//    }


}
