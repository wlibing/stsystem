package com.example.studteath.common;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;



public class PdfUtil {
    /**
     * 生成包含中文的 PDF
     * @param text   要写入的文本
     * @param output 输出的 PDF 路径
     * @throws Exception
     */
    public static void createChinesePdf(String text, String output) throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            // 加载并嵌入中文字体
            File fontFile = new File("src/main/resources/fonts/NotoSerifCJKjp-Regular.otf");
            PDType0Font font = PDType0Font.load(document, fontFile);

            try (PDPageContentStream cs = new PDPageContentStream(document, page)) {
                cs.beginText();
                cs.setFont(font, 18);
                cs.newLineAtOffset(100, 700);
                cs.showText(text);
                cs.endText();
            }

            document.save(output);
        }
    }
}
