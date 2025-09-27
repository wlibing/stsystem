package com.example.studteath.controller;
import com.example.studteath.dto.USER003InputDto;
import com.example.studteath.dto.USER003OutputDto;
import com.example.studteath.dto.UserInfo;
import com.example.studteath.modelform.USER004Response;
import com.example.studteath.service.USER003Service;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.io.File;
import com.example.studteath.common.PdfUtil;




@RestController
public class PdfController {
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    USER003Service serviceEdit;
    @GetMapping("/download-pdf")
    public void generatePdf(HttpServletRequest request, HttpServletResponse response) throws Exception {
        USER004Response from = new USER004Response();


        // ユーザーサービス入力dtoを定義
        USER003InputDto inputDto = new USER003InputDto();
        inputDto.setId("");
        //ユーザーサービスを呼び出し
        USER003OutputDto user003OutputDto = serviceEdit.searAllchUser(inputDto);
        List<UserInfo> userInfoListOut = user003OutputDto.getUserInfoList();
        UserInfo userInfo = userInfoListOut.get(0);
        BeanUtils.copyProperties(userInfo, from);
        from.setId(userInfo.getId().toString());

        WebContext context =  new WebContext(request, response, request.getServletContext());
        context.setVariable("userData", from);
        context.setVariable("title", "PDF 出力テスト");
        context.setVariable("message", "これは Thymeleaf テンプレートから生成した PDF です。");

        // 渲染模板为 HTML
        String html = templateEngine.process("user/info", context);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withHtmlContent(html, null);
        builder.useFont(new File("src/main/resources/fonts/NotoSansJP-Black.ttf"),"Black");
        builder.toStream(baos);
        builder.run();



        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=sample.pdf");
        response.setContentLength(baos.size());

        baos.writeTo(response.getOutputStream());
    }
}
