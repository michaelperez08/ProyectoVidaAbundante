/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author michael
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EnviarCorreo {
    
    public Properties mailServerProperties;
	public Session getMailSession;
	public MimeMessage generateMailMessage;
 
 
	public void generateAndSendEmail(String mensaje, String para, String asunto) throws AddressException, MessagingException {
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test@test.com"));
		generateMailMessage.setSubject(asunto);
		//String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
		String emailBody = mensaje;
		generateMailMessage.setContent(emailBody, "text/html");
		
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "michael.pemu@gmail.com", "uroboros95");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
                JOptionPane.showMessageDialog(null, "Correo Enviado Exitosamente", "Vida Abundante Grecia", JOptionPane.INFORMATION_MESSAGE);
	}       
    
}
