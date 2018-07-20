package com.xznn.controller;

import com.xznn.pojo.UploadedImageFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class AnnotationIndexController {

    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mav = new ModelAndView("index.jsp");
//        mav.addObject("message", "Hello Spring MVC");
//        return mav;

//        request.setAttribute("message", "Hello Spring MVC 2");
//        request.getRequestDispatcher("index.jsp").forward(request, response);
//        return null;

        return new ModelAndView("index","message", "Hello Spring MVC by Annotation");
    }

    @RequestMapping("/jump2Index")
    public ModelAndView jump2Index() {
        // 客户端跳转
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        count++;
        session.setAttribute("count", count);
        return new ModelAndView("checkPager", "count", count);
    }

    @RequestMapping("/clear")
    public ModelAndView clear(HttpSession session) {
        session.setAttribute("count", 0);
        return new ModelAndView("redirect:/check");
    }

    @RequestMapping("/uploadImage")
    public ModelAndView uploadImage(HttpServletRequest request, UploadedImageFile file) {
        /*
        1. 方法的第二个参数UploadedImageFile 中已经注入好了 image
        2. 通过 RandomStringUtils.randomAlphanumeric(10);获取一个随机文件名。 因为用户可能上传相同文件名的文件，为了不覆盖原来的文件，通过随机文件名的办法来规避
        3. 根据request.getServletContext().getRealPath 获取到web目录下的image目录，用于存放上传后的文件。
        4. 调用file.getImage().transferTo(newFile); 复制文件
        5. 把生成的随机文件名提交给视图，用于后续的显示
        */

        String newFileName = System.currentTimeMillis() + ".jpg";
        File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
//        boolean mkdirs = newFile.getParentFile().mkdirs();
        boolean mkdirs = newFile.mkdirs();
        System.out.println("mkdirs = [" + mkdirs + "], newFile = [" + newFile + "]");
        try {
            file.getImage().transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("showUploadedFile", "imageName", newFileName);
    }
}
