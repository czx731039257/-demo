package com.demo.serviceimpl;

import javax.annotation.Resource;

import com.demo.dao.StudentDao;
import com.demo.dao.UserDao;
import com.demo.entity.User;
import com.demo.service.UserService;

public class UserServiceImpl implements UserService {

	
	@Resource(name="userDao") 
	private UserDao userdao;
	
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		if(userdao.login(user)>=1) {
			return true;
		}else {
		return false;
		}
	}

}
