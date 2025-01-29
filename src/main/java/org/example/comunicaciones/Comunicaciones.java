package org.example.comunicaciones;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class Comunicaciones {
    public static boolean enviaMensajeTelegram(String mensaje) {
        String direcion; // URL de la API de mi bot en mi conversación
        String fijo = "https://api.telegram.org/bot7733900916:AAEkVPyLonwbbHzR5IGqtDJJkMKexQuwkJo/sendMessage?chat_id=707473081&text=";
        direcion = fijo + mensaje;
        URL url;
        boolean dev;
        dev = false;
        try {
            url = new URL(direcion);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            dev = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dev;
    }

    public static void enviarCorreoGmail(String destinatario, String asunto, String cuerpo) {
        String remitente = "fernando3prueba@gmail.com";
        String clave = "lpmz ghqt dsfsf uccs";

        // Propiedades de la conexión
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        // Se obtiene la sesión en el servidor de correo
        Session session = Session.getDefaultInstance(props);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(cuerpo, "text/html; charset=utf-8");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
