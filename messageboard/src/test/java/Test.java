import com.demo.dao.*;
import org.junit.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {
    //    @org.junit.Test
//    public void test(){
//        SelectUser selectUser=new SelectUser();
//        boolean b = selectUser.select("张三", "123456");
//        System.out.println(b);
//
//    }
    //@org.junit.Test
    public void test1() {
        SelectMessage selectMessage = new SelectMessage();
        Set<Message> select = selectMessage.selectByUserId(3);
        Iterator<Message> it = select.iterator();
        while (it.hasNext()) {
            Message message = it.next();
            System.out.println(message.getId() + "--" + message.getLabel() + "--");
        }
    }

    //@org.junit.Test
    public void test2() {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.delete(9);
    }

    //@org.junit.Test
    public void test3() {
        Message message = new Message(9, "aa", "aa", "2019-1-1 11:11:11", "2019-1-1 11:11:11", 3);
        UpdateMessage updateMessage = new UpdateMessage();
        updateMessage.update(message);
    }

    //@org.junit.Test
    public void test4() {
        Message message = new Message(10, "aa", "aa", "2019-1-1 11:11:11", "2019-1-1 11:11:11", 1);
        InsertMessage insertMessage = new InsertMessage();
        insertMessage.insert(message);
    }

    //@org.junit.Test
    public void test5() {
        SelectUser selectUser = new SelectUser();
        Set<User> select = selectUser.select("张s", "123456");
        System.out.println(select.size());
        Iterator<User> it = select.iterator();
        while (it.hasNext()) {
            User user = it.next();
            System.out.println(user.getId() + "--" + user.getEmail() + "--");
        }
    }

//    @org.junit.Test
//    public void test6(){
//        SelectMessage selectMessage=new SelectMessage();
//        PageBean all = selectMessage.findALL(1, 4);
//        Iterator<Message> it=all.getData().iterator();
//        while(it.hasNext()){
//            Message message=it.next();
//            System.out.println(message.getId()+"--"+message.getLabel());
//        }
//    }
}
