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
        // 正常输入测试
        String normalMessage = "你好，我是lihui";
        String answer = loveAppProhibitedWords.doChat(normalMessage, chatId);
        Assertions.assertNotNull(answer);

        // 包含违禁词输入测试，验证是否抛出异常
        String prohibitedMessage = "成人偷拍";
        Assertions.assertThrows(
                com.lihui.aiagent.advisor.ProhibitedWordAdvisor.ProhibitedWordException.class,
                () -> loveAppProhibitedWords.doChat(prohibitedMessage, chatId),
                "Expected ProhibitedWordException for prohibited message"
        );

        // 对话记忆相关测试
        String recallMessage = "我之前说的内容，你能再帮我想想吗？";
        answer = loveAppProhibitedWords.doChat(recallMessage, chatId);
        Assertions.assertNotNull(answer);
    }


}
