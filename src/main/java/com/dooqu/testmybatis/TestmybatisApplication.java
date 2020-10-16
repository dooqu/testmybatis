package com.dooqu.testmybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;

@SpringBootApplication
@RestController
public class TestmybatisApplication {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    People people;

    @GetMapping("/people")
    public People people() {
        return people;
    }


    @GetMapping("/question")
    public Question question() throws Exception {
        Question question = null;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "development");
        SqlSession session = sqlSessionFactory.openSession();
        question = session.selectOne("com.dooqu.testmybatis.QuestionDao.getOneQuestion");
        session.close();
        //Question question = questionDao.getOneQuestion();
        return question;
    }
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestmybatisApplication.class);
        springApplication.run(args);
    }
}
