package Ahola.AholaGroup.service.email;

import Ahola.AholaGroup.dto.EmailDto;

import Ahola.AholaGroup.exception.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService implements EmailServiceImpl {

    private final JavaMailSender javaMailSender;

//    @Value("${spring.mail.username}")
//    private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDto emailDto) {
     if (javaMailSender == null) {
            throw new ApiException("JAVA SENDER NOT AVAILABLE");
        }

        log.info("--> DTO options before {}", emailDto.getRecipient());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("nwajeigoddowell@gmail.com");
        mailMessage.setTo(emailDto.getRecipient());
        mailMessage.setText(emailDto.getMessageBody());
        mailMessage.setSubject(emailDto.getSubject());

        log.info("--> DTO options before {}", javaMailSender);

        try{
            javaMailSender.send(mailMessage);
            System.out.println("Mail sent Succesfully");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }




}
