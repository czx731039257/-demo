package com.csx.ems.controller;

import com.alibaba.fastjson.JSON;
import com.csx.ems.entity.JsonEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class JosnController {

    @ResponseBody
    @RequestMapping("jsontest")
    public String xx(){
        LinkedList<String> list=new LinkedList<>();
        list.add("dianyin");
        list.add("youxi");
        Date data=new Date();
        JsonEntity jsonEntity=new JsonEntity("czx","123456",list,data);
        String s = JSON.toJSONString(jsonEntity);
        return s;
    }

    @RequestMapping("jsontest1")
    public void rr(@RequestBody HashMap<String, Object> map){
        Set<String> strings = map.keySet();
        System.out.println("ss");
        strings.stream().forEach((key)->{
            System.out.println(map.get(key));
        });
    }
}
