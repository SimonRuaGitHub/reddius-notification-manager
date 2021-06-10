package com.reddius.service;

import com.reddius.dto.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender mailSender;
    private MailContentBuilder mailContentBuilder;

    @Value("${service.mail.sender}")
    private String sender;

    @Autowired
    public MailService(JavaMailSender mailSender, MailContentBuilder mailContentBuilder) {
        this.mailSender = mailSender;
        this.mailContentBuilder = mailContentBuilder;
    }

    public void sendMail(Email email){
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(sender);
            messageHelper.setTo(email.getRecipient());
            messageHelper.setSubject(email.getSubject());
            messageHelper.setText(mailContentBuilder.build(email.getBody()));
        };

        try{
            mailSender.send(messagePreparator);
        }catch(MailException mailException){
            System.out.println("Error trying to send mail: "+mailException.getMessage());
            mailException.printStackTrace();
        }
    }

}
