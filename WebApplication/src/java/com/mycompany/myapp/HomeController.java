package com.mycompany.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/") //요청 메세지(/home일경우 ->localhost:8080/WebApplication/home)
    public String home() {
        System.out.println("home");
        return "home";
    }

    @RequestMapping("/html")
    public String html() {
        return "html"; //리턴되는 값-> .jsp와 밀접한 관련
    }

    @RequestMapping("/css/exam01")
    public String cssExam01() {
        return "css/exam01"; //리턴되는 값-> .jsp와 밀접한 관련
    }

    @RequestMapping("/css/exam02")
    public String cssExam02() {
        return "css/exam02"; //리턴값.jsp가 실행된다
    }

    @RequestMapping("/css/exam03")
    public String cssExam03() {
        return "css/exam03"; //리턴값.jsp가 실행된다
    }
    
    @RequestMapping("/javascript/exam01")
    public String javascriptExam01() {
        return "javascript/exam01"; //리턴값.jsp가 실행된다
    }
    
    @RequestMapping("/javascript/exam02")
    public String javascriptExam02() {
        return "javascript/exam02"; //리턴값.jsp가 실행된다
    }
    
    @RequestMapping("/javascript/exam03")
    public String javascriptExam03() {
        return "javascript/exam03"; //리턴값.jsp가 실행된다
    }
    
    @RequestMapping("/javascript/exam04")
    public String javascriptExam04() {
        return "javascript/exam04"; //리턴값.jsp가 실행된다
    }
}
