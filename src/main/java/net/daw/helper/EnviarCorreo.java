/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author kevin
 */
public class EnviarCorreo {

    public static void enviarConGMail(String emailDestinatario, String nombreUsuario, String loginUsuario, String passUsuario, String token) {
        final String REMITENTE = "oncomic.info@gmail.com";
        final String CLAVE = "oncomic123";
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
            props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
            props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
            props.put("mail.smtp.user", "hola");
//            props.put("mail.smtp.clave", clave);    //La clave de la cuenta
            props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave            

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(REMITENTE));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));   //Destinatario
            message.setSubject("OnComics: Validación de email");
            String link = "http://localhost:8080/json?ob=usuario&op=activar&user="+ loginUsuario + 
                    "&pass=" + passUsuario + "&token="+ token;
            message.setText("<h3>Bienvenido a Oncomic " + nombreUsuario + "</h3>"
                    + "<div><a href='" + link + "'> Haz click en este enlace para confirmar tu cuenta </a></div><br>"
                    + "<small>Mensaje automático; por favor, no responda este correo</small>",
                    "utf-8", "html");
            try (Transport transport = session.getTransport("smtp")) {
                transport.connect("smtp.gmail.com", REMITENTE, CLAVE);
                transport.sendMessage(message, message.getAllRecipients());
            }

        } catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }

}
