/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.tools;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author yudafatah
 */
public class sendMailNotif {
    public boolean Send(String email, String subject, String text) {
        boolean hasil = false;
        try {

            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.port", "465");//default port dari smptp

            Session session = Session.getInstance(properties);
            session.setDebug(true);

            MimeMessage pesan = new MimeMessage(session);
//            pesan.setFrom("edummy246@gmail.com"); //isi dengan gmail kalian sendiri, biasanya sama nanti dengan username
            pesan.setRecipient(Message.RecipientType.TO, new InternetAddress(email));//isi dengan tujuan email
            pesan.setSubject(subject);
            pesan.setContent(text, "text/html; charset=UTF-8");

            String username = "edummy246@gmail.com"; //ganti dengan gmail kalian sendiri
            String password = "emaildummy123"; //ganti dengan password kalian sendiri
            Transport.send(pesan, username, password);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return hasil;
    }

}
