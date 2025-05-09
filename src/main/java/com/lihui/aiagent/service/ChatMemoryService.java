package com.lihui.aiagent.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.lihui.aiagent.domain.ChatMemory;
import com.lihui.aiagent.domain.Userprofile;
import org.springframework.ai.chat.messages.Message;

import java.util.List;

/**
 * 聊天记忆服务接口
 */
public interface ChatMemoryService extends IService<ChatMemory> {

    /**
     * 添加多条消息
     *
     * @param conversationId 会话ID
     * @param messages       消息列表
     */
    void addMessages(String conversationId, List<Message> messages);

    /**
     * 获取会话消息
     *
     * @param conversationId 会话ID
     * @param lastN          获取的消息数量，正数表示获取前N条，0或负数表示获取全部
     * @return 消息列表
     */
    List<Message> getMessages(String conversationId, int lastN);

    /**
     * 清除会话消息（逻辑删除）
     *
     * @param conversationId 会话ID
     */
    void clearMessages(String conversationId);

    /**
    * @author lihui
    * @description 针对表【userprofile】的数据库操作Service
    * @createDate 2025-05-08 18:19:59
    */
    interface UserprofileService extends IService<Userprofile> {

    }
}