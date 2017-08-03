package com.mycompany.myapp;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) // Junit Runner는 @Annotation을 인식하지 못하기 때문에 Spring 제공해주는 Runner를 사용
// Spring을 구동하기 위한 설정파일
@ContextConfiguration({
	"file:WebContent/WEB-INF/spring/applicationContext.xml",
	"file:WebContent/WEB-INF/spring/dispatcher-servlet.xml" })

// @WebAppConfiguration => 웹 컨텐트가 src/main/webapp 에 존재(STS)
// WebContent의 작성 위치를 알려줌
@WebAppConfiguration("WebContent")
public class ApplicationContextLoader {

}
