package com.mycompany.myapp.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Exam09FormController {
    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/form/exam01", method = RequestMethod.GET)
    public String joinForm() {
        return "form/exam01";
    }

    @RequestMapping(value = "/form/exam01", method = RequestMethod.POST)
    public String join(String mid, String mname, String mpassword,
            @RequestParam(defaultValue = "0") int mage, //int 타입에는 required=false 사용 불가
            String[] mskill, String mbirth) {
        System.out.println("mid: " + mid);
        System.out.println("mname: " + mname);
        System.out.println("mpassword: " + mpassword);
        System.out.println("mage: " + mage);
        System.out.println("mskill: " + Arrays.toString(mskill));
        System.out.println("mbirth: " + mbirth);
        return "form/exam01";
    }

    @RequestMapping(value = "/form/exam02", method = RequestMethod.GET)
    public String joinForm2() {
        return "form/exam02";
    }

    @RequestMapping(value = "/form/exam02", method = RequestMethod.POST)
    public String join2(String mid, String mname, String mpassword,
            @RequestParam(defaultValue = "0") int mage, //int 타입에는 required=false 사용 불가
            String[] mskill, String mbirth,
            MultipartFile attach) throws IOException {

        //파일 정보 얻기
        String fileName = attach.getOriginalFilename();
        String contentType = attach.getContentType();
        long fileSize = attach.getSize();

        //파일을 서버 하드디스크에 저장
        String realPath = servletContext.getRealPath("/WEB-INF/upload/" + fileName);
        File file = new File(realPath);
        attach.transferTo(file); //build폴더에 저장(실제위치)
        
        System.out.println("fileName: " + fileName);
        System.out.println("contentType: " + contentType);
        System.out.println("fileSize: " + fileSize);
        return "form/exam02";
    }
}
