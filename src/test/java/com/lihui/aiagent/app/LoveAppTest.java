package com.lihui.aiagent.app;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class LoveAppTest {

    @Resource
    private LoveApp loveApp;

    @Test
    void testChat() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是lihui";
        String answer = loveApp.doChat(message, chatId);
        // 第二轮
        message = "我想让另一半（jjm）更爱我";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第三轮
        message = "我的另一半叫什么来着？刚跟你说过，帮我回忆一下";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
    }


    @Test
    void doChat() {
        String chatId = UUID.randomUUID().toString();
        String message = "我已经结婚了，但是婚后关系不太亲密，怎么办？";
        String answer = loveApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithReport() {
        String chatId = UUID.randomUUID().toString();
        String message = "你好，我是程序员lihui，我想让另一半（jjm）更爱我，但我不知道该怎么做";
        LoveApp.LoveReport loveReport = loveApp.doChatWithReport(message, chatId);
        Assertions.assertNotNull(loveReport);
    }

    @Test
    void doChatWithRag() {
        String chatId = UUID.randomUUID().toString();
        String message = "我已经结婚了，但是婚后关系不太亲密，怎么办？";
        String answer = loveApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(answer);
    }


    @Test
    void doChatWithCloudRag() {
        String chatId = UUID.randomUUID().toString();
        String message = "我已经结婚了，但是婚后关系不太亲密，怎么办？";
        String answer = loveApp.doChatWithCloudRag(message, chatId);
        Assertions.assertNotNull(answer);
    }


    @Test
    void doChatWithRagToAiCupid() {
        String chatId = UUID.randomUUID().toString();
        String message = "我是男生，22岁，喜欢睡觉";
        String answer = loveApp.doChatWithRagToAiCupid(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithRagToAiCupidMybatis() {
        String chatId = UUID.randomUUID().toString();
        String message = "我是男生，22岁，喜欢听音乐";
        String answer = loveApp.doChatWithRagToAiCupidMybatis(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithRagPgVector() {
        String chatId = UUID.randomUUID().toString();
        String message = "你好，我是程序员lihui，我想让另一半（jjm）更爱我，但我不知道该怎么做";
        String answer = loveApp.doChatWithRagPgVector(message, chatId);
        Assertions.assertNotNull(answer);

    }

    @Test
    void doChatWithRagandQR() {
        String chatId = UUID.randomUUID().toString();
        String message = "我已经结婚了，但是婚后关系不太亲密，怎么办？";
        String answer = loveApp.doChatWithRagandQR(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithRagandRagCustomAdvisorFactory() {
        String chatId = UUID.randomUUID().toString();
        String message = "我已经结婚了，但是婚后关系不太亲密，怎么办？";
        String answer = loveApp.doChatWithRagandRagCustomAdvisorFactory(message, chatId);
        Assertions.assertNotNull(answer);
    }
}