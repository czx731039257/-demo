package com.csx.demo2.controller;

import com.csx.demo2.entity.HeadPortrait;
import com.csx.demo2.service.HeadPortraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
public class testController {

    @Autowired
    private HeadPortraitService headPortraitService;

//    @RequestMapping("/fileupload")
//    public String fileupload(HttpServletRequest req, MultipartFile file) throws IOException {
//        String url = req.getSession().getServletContext().getRealPath("/userhead");
//        url+="/";
//        String originalFilename = file.getOriginalFilename();
//        String filename=UUID.randomUUID()+originalFilename;
//        System.out.println(url);
//        file.transferTo(new File(url+filename));
//        headPortraitService.insert(new HeadPortrait(null,1,"userhead/"+filename));
//        return "redirect:"+"testupload";
//    }

    @RequestMapping("/selectfilelist")
    public String selectfilelist(HttpServletRequest req) throws IOException {
        List<HeadPortrait> headPortraits = headPortraitService.selectByUserId(1);
        Iterator<HeadPortrait> it = headPortraits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        HttpSession session = req.getSession();
        session.setAttribute("headPortraits", headPortraits);
        return "redirect:" + "headlist";
    }

}
