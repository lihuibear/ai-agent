package com.lihui.aiagent.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PDFGenerationToolTest {

    @Test
    void generatePDF() {
        PDFGenerationTool tool = new PDFGenerationTool();
        String fileName = "lihuibear介绍.pdf";
        String content = "lihuibear.cn 是个人网站，用于分享个人博客、技术文章、开源项目等。";
        String result = tool.generatePDF(fileName, content);
        assertNotNull(result);
    }
}