package com.example.lojaPescaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendEmailWithTemplate(String to, String subject, Map<String, Object> templateModel, boolean isClient) throws MessagingException {
        Context context = new Context();
        context.setVariables(templateModel);
        context.setVariable("isClient", isClient);
        String htmlBody = templateEngine.process("emailTemplate", context);

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "UTF-8");

        helper.setTo(to);
        helper.setFrom("elbertjean@zohomail.com");
        helper.setSubject(subject);
        helper.setText(htmlBody, true);

        emailSender.send(message);
    }
}