package com.nmys.story.utils;

import com.nmys.story.exception.TipException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

/**
 * Description: 邮件工具类
 *
 * @Author hongfei.zhang
 */
@Component
@Slf4j
public class MailUtil {

    @Autowired
    private Environment env;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;


    /**
     * Description: 邮件模板解析
     * Author:hongfei.zhang
     * Param [templateName, model]
     * Return java.lang.String
     */
    public String resolveTemplate(String templateName, Context context) {
        try {
            final String emailContent = templateEngine.process(templateName, context);
            return emailContent;
        } catch (Exception e) {
//            log.error("邮件模板解析失败！" + e.getMessage());
            throw new TipException("邮件模板解析失败！", e);
        }
    }

    /**
     * Description: 邮件发送
     * @Author:hongfei.zhang
     * @param template thymeleaf模板的路径
     * @param to 发送给谁
     * @param title 邮件的主题
     * @param context 邮件内容
     */
    public void sendEmail(String template, String to, String title, Context context) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(resolveTemplate(template, context), true);
            javaMailSender.send(mimeMessage);
//            log.info("邮件发送成功！");
        } catch (Exception e) {
//            log.error(e.getMessage(), e);
            throw new TipException("邮件发送失败！", e);
        }
    }

}
