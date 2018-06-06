 
import javax.mail.internet.*;

import java.util.*;
import javax.mail.*;

public class TaskSchedule {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("ENter To Address");
	String toemail=sc.nextLine();
	
	System.out.println("Enter Subject");
	String sub=sc.nextLine();
	
	System.out.println("Enter mail.conten");
	String content=sc.nextLine();
	
	final String username="nagendrasankatala0@gmail.com";
	final String password="xxxxxxx";
	
	Properties props=new Properties();
	props.put("mail.smtp.auth","true");
	props.put("mail.smtp.starttls.enable","true");
	props.put("mail.smtp.host","smtp.gmail.com");
	props.put("mail.smtp.port","587");
	
	Session ses=Session.getInstance(props,
			new javax.mail.Authenticator()
			{
		protected PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication(username, password);
		}
			});
	try {
		
	MimeMessage message=new MimeMessage(ses);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toemail));
		message.setSubject(sub);
		message.setText(content);
	    Transport.send(message);
	    System.out.println("Email sent SUccessfully...!");
	}
	catch(MessagingException e)
	{ throw new RuntimeException(e);
	
	}
	
}
}






