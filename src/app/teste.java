package app;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class teste {
    public static void main(String[] args) throws Exception {
        Email email = new SimpleEmail();
        email.setHostName("smtp.hotmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("samuelpoop28@hotmail.com", "Som@201309"));
        email.setSSLOnConnect(true);
        email.setFrom("samuelpoop28@hotmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("samuelpoop28@hotmail.com");
        email.send();
        System.out.println("deu certo");   


    }      
}
