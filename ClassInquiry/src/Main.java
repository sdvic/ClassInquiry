import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

	public static void main(String[] args) {
	new Main().getGoing();
	}

	private void getGoing() {

		String host = "smtp-server.san.rr.com";
		String from = "gvw@san.rr.com";
		String to = "gvw@san.rr.com";
		 
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.debug", "true");
		 
		Session session = Session.getInstance(props);
		 
		try {
		    Message msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress(from));
		 
		    // The recipients can be more than one so we use an array but you can
		    // use 'new InternetAddress(to)' for only one address.
		    InternetAddress[] address = {new InternetAddress(to), new InternetAddress("dfrw@san.rr.com")};
		    msg.setRecipients(Message.RecipientType.TO, address);
		 
		    msg.setSubject("Java Classes");
		    msg.setSentDate(new Date());
		 
		    msg.setText("We are a non-profit, after-school institution and teach the Java programming language to kids in an ongoing, year round curriculum, usually starting in the 5th grade.   No previous knowledge about programming is necessary.  Our teachers are all volunteer Java professionals, and we have small classes (usually 4 students).  We teach in kid-appropriate ways by writing fun game programs starting with the very first class.  Our students love the classes and they really learn.  We have had one student pass the computer science advanced placement exam in the seventh grade! ");
		 
		    // Send the message
		    Transport.send(msg);
		}
		catch (MessagingException mex) {
		    mex.printStackTrace();
		}
		
	}

}
