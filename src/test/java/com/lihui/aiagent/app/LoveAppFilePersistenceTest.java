package com.lihui.aiagent.app;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoveAppFilePersistenceTest {

    @Resource
    private LoveAppFilePersistence loveAppFilePersistence;
    @Test
    void testChat() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是lihui";
        String answer = loveAppFilePersistence.doChat(message, chatId);
        // 第二轮
        message = "我想让另一半（jjm）更爱我";
        answer = loveAppFilePersistence.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第三轮
        message = "我的另一半叫什么来着？刚跟你说过，帮我回忆一下";
        answer = loveAppFilePersistence.doChat(message, chatId);
        Assertions.assertNotNull(answer);
    }
}