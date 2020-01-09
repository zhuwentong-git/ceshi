package com.mr.zwt.easybuy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName SendEmailService
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2020/1/6
 * @Version V1.0
 **/
@Service
public class SendEmailService {
    @Autowired
    JavaMailSender jms;

    public String send(String sender,String receiver,String title,String text){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送方
        mainMessage.setFrom(sender);
        //接收方
        mainMessage.setTo(receiver);
        //发送的标题
        mainMessage.setSubject(title);
        //发送的内容
        mainMessage.setText(text);
        jms.send(mainMessage);
        return "success";
    }


    public String sendPicture(String sender,String receiver,String subject, String content,
                              String picPath,String picId) throws MessagingException {
        MimeMessage message = jms.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        //发送方
        helper.setFrom(sender);
        //接收方
        helper.setTo(receiver);
        //邮件主题
        helper.setSubject(subject);
        //邮件内容
        helper.setText(content,true);
        //邮件的图片
        FileSystemResource file = new FileSystemResource(new File(picPath));
        helper.addInline(picId,file);
        int ind = 100;
        for (int i = 0 ; i<ind;i++){
            jms.send(message);
        }
        int i=1;
        System.out.println("1" + i++);
        return "sendPicture success";
    }

    public String sendAttachment(String sender,String receiver,String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = jms.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        //发送方
        helper.setFrom(sender);
        //接收方
        helper.setTo(receiver);
        //邮件主题
        helper.setSubject(subject);
        //邮件内容
        helper.setText(content,true);
        //邮件的附件
        FileSystemResource file = new FileSystemResource(new File(filePath));
        //获取附件的文件名
        String fileName = file.getFilename();
        helper.addAttachment(fileName,file);
        jms.send(message);
        return "sendAttachment success";
    }


}
