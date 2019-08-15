package com.csx.demo2.service;

import com.csx.demo2.dao.MessageDao;
import com.csx.demo2.dao.UserDao;
import com.csx.demo2.entity.Message;
import com.csx.demo2.entity.PageBean;
import com.csx.demo2.entity.Result;
import com.csx.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;


    /*
    * 查询所有用户
    */
    public Result selectAllMessage(){
        List<Message> messages = messageDao.select(new Message( null, null, null, null, null));
        PageBean pageBean=new PageBean(1,messages.size());
        pageBean.setMessagesType(4);
        return new Result(true,null,pageBean,messages);
    }
    /*
    * 根据用户查询留言
    * @param username 要查询的用户名
    * @return 封装了留言集合和分页信息的Result对象
    * */
    public Result selectMessageByUserName(String username){
        List<Message> messages = messageDao.selectByUserName(new User(null,username,null,null,null,null));
        PageBean pageBean=new PageBean(1,messages.size());
        pageBean.setMessagesType(5);
        Result result=new Result(true,null,pageBean,messages);
        return result;
    }


    public Result selectPersonMessage(User user){
        List<Message> messages = messageDao.select(new Message(null, null, null, null, user.getId()));
        PageBean pageBean=new PageBean(1,messages.size());
        pageBean.setMessagesType(1);
        return new Result(true,null,pageBean,messages);
    }

    public Result selectGroupMessage(User user){
        List<Message> messages = messageDao.selectGroup(user);
        PageBean pageBean=new PageBean(1,messages.size());
        pageBean.setMessagesType(2);
        return new Result(true,null,pageBean,messages);
    }

    public Result selectOtherGroupMessage(User user){
        List<Message> messages = messageDao.selectOtherGroup(user);
        PageBean pageBean=new PageBean(1,messages.size());
        pageBean.setMessagesType(3);
        return new Result(true,null,pageBean,messages);
    }
    /*
    * 新建留言
    * @param pageBean 分页信息
    * @param user 当前的用户
    * @param label 新建留言的标题
    * @param detail 新建留言的内容
    * @return 封装了留言集合和分页信息的Result对象
    * */
    public Result createMessage(PageBean pageBean,User user, String label, String detail){
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_create=dateFormat.format(date);
        String date_edit=dateFormat.format(date);

        int user_id = user.getId();
        Message message=new Message(label,detail,date_create,date_edit,user_id);
        messageDao.insert(message);//创建新的留言
        List<Message> messages=null;
        if(pageBean.getMessagesType()==1) {
            messages = messageDao.select(new Message( null, null, null, null, user.getId()));
            pageBean.addTotalRecord();
        }else if(pageBean.getMessagesType()==2){
            messages = messageDao.selectGroup(user);
            pageBean.addTotalRecord();
        }else if(pageBean.getMessagesType()==3){
            messages=messageDao.selectOtherGroup(user);
        }else if(pageBean.getMessagesType()==4){
            messages = messageDao.select(new Message(null,null,null,null,null));
            pageBean.addTotalRecord();
        }else{

        }
        return new Result(true,user,pageBean,messages,message.toString());
    }

    /*
    * 删除留言
    * @param pageBean 分页信息
    * @param messageid 需要删除的留言id
    * @return 封装了留言集合和分页信息的Result对象
    * */
    public Result deleteMessage(User user ,PageBean pageBean,String messageid){
        Message message = messageDao.select(new Message(Integer.valueOf(messageid), null, null, null, null, null)).get(0);
        messageDao.deleteById(Integer.valueOf(messageid));//执行删除操作
        List<Message> messages = null;
        if(pageBean.getMessagesType()==1) {
            messages = messageDao.select(new Message( null, null, null, null, user.getId()));
            pageBean.minusTotalRecord();
        }else if(pageBean.getMessagesType()==2){
            messages = messageDao.selectGroup(user);
            pageBean.minusTotalRecord();
        }else if(pageBean.getMessagesType()==3){
            messages=messageDao.selectOtherGroup(user);
        }else if(pageBean.getMessagesType()==4){
            messages = messageDao.select(new Message(null,null,null,null,null));
            pageBean.minusTotalRecord();
        }else{

        }
        //System.out.println(message);
        return new Result(true,null, pageBean, messages,"删除留言"+message.toString()+"成功");
    }

    /*
    * 进入留言编辑页面前的操作，查询所有所需编辑的留言的信息
    * @param messagid 所需查询的留言id
    * @return 封装了留言集合和分页信息的Result对象
    * */
    public Result intoEditMessage(String messageid){
        List<Message> messages = messageDao.select(new Message(Integer.valueOf(messageid), null, null, null, null, null));
        return new Result(true,null,null,messages);
    }

    /*
    * 实现留言编辑
    * @param messagid 所需编辑的留言id
    * @param label 编辑后的留言标题
    * @param detail 编辑后的留言内容
    * @return 封装了留言集合和分页信息的Result对象
    * */
    public Result commitEditMessage(String messageid,String label,String detail,PageBean pageBean,User user){
        Message oldmessage = messageDao.select(new Message(Integer.valueOf(messageid), null, null, null, null, null)).get(0);
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_edit=dateFormat.format(date);
        List<Message> select = messageDao.select(new Message(Integer.valueOf(messageid), null, null, null, null, null));
        Message message = select.get(0);
        message.setLabel(label);
        message.setDetail(detail);
        message.setDate_edit(date_edit);
        messageDao.update(message);
        Message newmessage = messageDao.select(new Message(Integer.valueOf(messageid), null, null, null, null, null)).get(0);
        List<Message> messages = messageDao.select(new Message(null,null,null,null,null));

        if(pageBean.getMessagesType()==1) {
            messages = messageDao.select(new Message( null, null, null, null, user.getId()));
            pageBean.addTotalRecord();
        }else if(pageBean.getMessagesType()==2){
            messages = messageDao.selectGroup(user);
            pageBean.addTotalRecord();
        }else if(pageBean.getMessagesType()==3){
            messages=messageDao.selectOtherGroup(user);
        }else if(pageBean.getMessagesType()==4){
            messages = messageDao.select(new Message(null,null,null,null,null));
            pageBean.addTotalRecord();
        }else{

        }

        return new Result(true,null,pageBean,messages,"把留言"+oldmessage+"\n修改成"+newmessage);
    }
}
