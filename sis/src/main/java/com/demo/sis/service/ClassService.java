package com.demo.sis.service;

import com.demo.sis.dao.ClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    private ClassDao classDao;
}
