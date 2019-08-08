package com.csx.demo2.service;

import com.csx.demo2.dao.PermissionDao;
import com.csx.demo2.entity.Permission;
import com.csx.demo2.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public void addSessionPermission(HttpSession session, List<Permission> permissions){
        Iterator<Permission> it=permissions.iterator();
        while(it.hasNext()){
            Permission permission=it.next();
            if(permission.getId()==1){
                session.setAttribute("canEditPersonInfo",true);
                continue;
            }if(permission.getId()==2){
                session.setAttribute("canEditGroupInfo",true);
                continue;
            }if(permission.getId()==3){
                session.setAttribute("canEditOtherGroupInfo",true);
                continue;
            }if(permission.getId()==4){
                session.setAttribute("canSelectPersonInfo",true);
                continue;
            }if(permission.getId()==5){
                session.setAttribute("canSelectGroupInfo",true);
                continue;
            }if(permission.getId()==6){
                session.setAttribute("canSelectOtherGroupInfo",true);
                continue;
            }if(permission.getId()==7){
                session.setAttribute("canCreateMessage",true);
                continue;
            }if(permission.getId()==8){
                session.setAttribute("canDeletePersonMessage",true);
                continue;
            }if(permission.getId()==9){
                session.setAttribute("canDeleteGroupMessage",true);
                continue;
            }if(permission.getId()==10){
                session.setAttribute("canDeleteOtherGroupMessage",true);
                continue;
            }if(permission.getId()==11){
                session.setAttribute("canEditPersonMessage",true);
                continue;
            }if(permission.getId()==12){
                session.setAttribute("canEditGroupMessage",true);
                continue;
            }if(permission.getId()==13){
                session.setAttribute("canEditOtherGroupMessage",true);
                continue;
            }if(permission.getId()==14){
                session.setAttribute("canSelectPersonMessage",true);
                continue;
            }if(permission.getId()==15){
                session.setAttribute("canSelectGroupMessage",true);
                continue;
            }if(permission.getId()==16){
                session.setAttribute("canSelectOtherGroupMessage",true);
                continue;
            }if(permission.getId()==17){
                session.setAttribute("canAllocationRole",true);
                continue;
            }if(permission.getId()==18){
                session.setAttribute("canAllocationPermission",true);
                continue;
            }
        }

    }
    public void removeSessionPermission(HttpSession session){
            session.removeAttribute("canEditPersonInfo");
            session.removeAttribute("canEditGroupInfo");
            session.removeAttribute("canEditOtherGroupInfo");
            session.removeAttribute("canSelectPersonInfo");
            session.removeAttribute("canSelectGroupInfo");
            session.removeAttribute("canSelectOtherGroupInfo");
            session.removeAttribute("canCreateMessage");
            session.removeAttribute("canDeletePersonMessage");
            session.removeAttribute("canDeleteGroupMessage");
            session.removeAttribute("canDeleteOtherGroupMessage");
            session.removeAttribute("canEditPersonMessage");
            session.removeAttribute("canEditGroupMessage");
            session.removeAttribute("canEditOtherGroupMessage");
            session.removeAttribute("canSelectPersonMessage");
            session.removeAttribute("canSelectGroupMessage");
            session.removeAttribute("canSelectOtherGroupMessage");
            session.removeAttribute("canAllocationRole");
            session.removeAttribute("canAllocationPermission");

    }

    public List<Permission> selectByRoleId(Integer roleid){
        List<Permission> permissions = permissionDao.selectByRoleId(roleid);
        return permissions;
    }

    public List<Permission> selectAll(){
        List<Permission> permissions = permissionDao.selectAll();
        return permissions;
    }
}
