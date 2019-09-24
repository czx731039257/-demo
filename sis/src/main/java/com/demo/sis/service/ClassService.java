package com.demo.sis.service;

import com.demo.sis.dao.ClassDao;
import com.demo.sis.dao.StudentDao;
import com.demo.sis.entity.Class;
import com.demo.sis.entity.Page;
import com.demo.sis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassDao classDao;

    public Page findpage(Page page){
        List<Class> classes = classDao.findpage(page);
        int total = classDao.select(page.getC()).size();
        page.setRows(classes);
        page.setTotal(total);
        return page;
    }

    public boolean insert(Class c){
        int i = classDao.insert(c);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Class c){
        int i = classDao.update(c);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteById(Integer id){
        int i = classDao.deleteById(id);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }
}
