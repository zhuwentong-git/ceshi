package com.mr.zwt.common.controller;

import com.mr.zwt.easybuy.service.impl.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * @ClassName SendEmailService
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2020/1/6
 * @Version V1.0
 **/
@RestController
public class mail {
    @Autowired
    private SendEmailService sendEmailService;

    private String sender = "1297017703@qq.com";   //这个是发送人的邮箱

    private String receiver="2460382560@qq.com";  //这个是接受人的邮箱

    private String title="测试";    //标题


    @GetMapping("/send")
    public String send(){
        String text="【坐在引擎盖上哭】“　66万买辆奔驰,还没开出店门就漏油,请问这种车去哪里买呢,我也想要一辆。";

        String result=sendEmailService.send(sender, receiver, title, text);
        return result;
    }

    @RequestMapping("/picture")
    public String sendPicture() throws MessagingException {
        String picPath = "C:\\Users\\zhuwentong\\Pictures\\Saved Pictures\\pigu.jpg";
        String picId = "PIC001";
        String content = "<html><body>我的这封邮件可是很厉害的,因为它可以显示图片呦!!!\n" +
                "<img src=\'cid:"+picId+"\'></img></body></html>";
        String picture = sendEmailService.sendPicture(sender,receiver,title,content,picPath,picId);
        return picture;
    }

    @RequestMapping("/attachment")
    public String sendAttachment() throws MessagingException {
        String filePath = "E:\\test.txt";
        String content = "我的这封邮件可是很厉害的,因为它可以带附件呦!!!";
        String attachment = sendEmailService.sendAttachment(sender,receiver,title,content,filePath);
        return attachment;
    }



}
