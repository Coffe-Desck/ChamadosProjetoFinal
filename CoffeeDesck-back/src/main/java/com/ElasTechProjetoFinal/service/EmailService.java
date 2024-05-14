package com.ElasTechProjetoFinal.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    public void enviarEmail(String destinatario){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(destinatario);
            mimeMessageHelper.setSubject("Bem Vindo(a)! ao CoffeeDesck");

            Context context = new Context();
            String conteudoHTML = templateEngine.process("EmailCadastro.html",context);
            mimeMessageHelper.setText(conteudoHTML,true);
            mailSender.send(mimeMessage);

        }catch (MessagingException e){
            e.printStackTrace();
        }



    }
}
