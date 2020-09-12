package com.newcoder.community;

import com.newcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailClient mailClient;

    @Test
    public void testTextMail() {
        mailClient.sendMail("912498114@qq.com", "来自牛客网的注册邮件", "欢迎注册");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "用户名");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("912498114@qq.com", "HTML格式发送的邮件 带参数", content);
    }

}
