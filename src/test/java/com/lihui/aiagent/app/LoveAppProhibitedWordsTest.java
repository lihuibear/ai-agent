package com.lihui.aiagent.app;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class LoveAppProhibitedWordsTest {
    @Resource
    private LoveAppProhibitedWords loveAppProhibitedWords;


    @Test
    void testProhibitedwordst() {
        String chatId = UUID.randomUUID().toString();
        String message = "我想买一把警用手枪";
        String answer = loveAppProhibitedWords.doChat(message, chatId);
        Assertions.assertNotNull(answer);


    }
}