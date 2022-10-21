package entidades;

import org.apache.commons.mail.SimpleEmail;

public class Notificacao {
    
    private String senhaDoEmail = "som@201309";
    private String emailDoBanco = "trabalho.samueloliv@gmail.com";


    public String getemailDoBanco() {
        return senhaDoEmail;
    }
    
    public boolean enviarEmail(double valor,String meuEmail){
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthentication(this.emailDoBanco, this.senhaDoEmail);
        email.setSSLOnConnect(true);
    
        try{
            email.setFrom(emailDoBanco);
            email.setSubject("Notificação de Tranferencia.");
            email.setMsg("Parabens! Você realizou com sucesso uma tranferencia de "+valor);
            email.addTo(meuEmail);
            email.send();
            return true;
        
        }catch(Exception e){
            return false;
        }
    
    
    }    


}
