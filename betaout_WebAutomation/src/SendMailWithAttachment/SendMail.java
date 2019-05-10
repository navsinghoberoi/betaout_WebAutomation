package SendMailWithAttachment;

import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common_Classes.Setup_class;

import javax.activation.*;
/**
 * @author - Navpreet
 */
public class SendMail {

	// Note - Attachment sent is not the updated one. Link provided gives the latest report.
	
	
	public static WebDriver driver;

	@Test

	public void sendReportWithAttachment() throws Exception {

		String to = "navpreet@socialcrawler.in";// To username
		final String user = "navpreet@socialcrawler.in";// from username
		final String password = "9999315652";// from password

		// 1) get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "aspmx.l.google.com");
		properties.put("mail.smtp.port", 25);
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// 2) compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Automation - TestSuit - Emailable Report");
			
			Setup_class set = new Setup_class(driver);
			String filename = set.uploadTestNGEmailableReport();
			System.out.println("Path of file = " +filename);
		
			// 3) create MimeBodyPart object and set your message text
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Please find the attached emailable report of the test suite from the link - "+filename);    // Open this link for updated file

			// 4) create new MimeBodyPart object and set DataHandler object to
			// this object
			
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

			// 5) create Multipart object and add MimeBodyPart objects to this
			// object
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);

			// 6) set the multiplart object to the message object
			
			message.setContent(multipart);

			// 7) send message
			
			Transport.send(message);

			System.out.println("Email message sent with attachment....");
		
			
			
			
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}

}