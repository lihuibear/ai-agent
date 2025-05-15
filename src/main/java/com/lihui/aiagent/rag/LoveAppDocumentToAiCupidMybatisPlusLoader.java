package com.lihui.aiagent.rag;

import com.lihui.aiagent.domain.Userprofile;
import com.lihui.aiagent.mapper.UserprofileMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
class LoveAppDocumentToAiCupidMybatisPlusLoader {

    @Resource
    private UserprofileMapper UserprofileMapper;

    /**
     * 从数据库加载用户资料
     *
     * @return
     */
    public List<Document> loadMarkdowns() {
        List<Document> allDocuments = new ArrayList<>();
        try {
            List<Userprofile> Userprofiles = UserprofileMapper.selectList(null);
            for (Userprofile Userprofile : Userprofiles) {
                String content = String.format("**姓名**：%s，**年龄**：%d岁，**性别**：%s，**星座**：%s，**职业**：%s，**爱好**：%s，**择偶期望**：%s",
                        Userprofile.getName(), Userprofile.getAge(), Userprofile.getGender(),
                        Userprofile.getConstellation(), Userprofile.getOccupation(),
                        Userprofile.getHobbies(), Userprofile.getPartnerexpectation());
                Map<String, Object> metadata = new HashMap<>();
                metadata.put("filename", "user_profile");
                Document document = new Document(content, metadata);
                allDocuments.add(document);
            }
        } catch (Exception e) {
            log.error("用户资料从数据库加载失败", e);
        }
        return allDocuments;
    }
}