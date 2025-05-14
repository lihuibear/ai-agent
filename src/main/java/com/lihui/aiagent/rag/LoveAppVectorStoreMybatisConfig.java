//package com.lihui.aiagent.rag;
//
//import jakarta.annotation.Resource;
//import org.springframework.ai.document.Document;
//import org.springframework.ai.embedding.EmbeddingModel;
//import org.springframework.ai.vectorstore.SimpleVectorStore;
//import org.springframework.ai.vectorstore.VectorStore;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class LoveAppVectorStoreMybatisConfig {
//
//    @Resource
//    private LoveAppDocumentToAiCupidMybatisPlusLoader loveAppDocumentToAiCupidMybatisPlusLoader;
//
//    @Bean
//    VectorStore loveAppToAiCupidVectorStoreMybatis(EmbeddingModel dashscopeEmbeddingModel) {
//        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(dashscopeEmbeddingModel)
//                .build();
//        // 从数据库加载文档
//        List<Document> documents = loveAppDocumentToAiCupidMybatisPlusLoader.loadMarkdowns();
//        simpleVectorStore.add(documents);
//        return simpleVectorStore;
//    }
//
//}