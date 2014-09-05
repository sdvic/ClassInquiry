/*********************************************************
 * Auto Response for Java Class Inquiries
 * version 140904A by Vic
 *********************************************************/
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
		String vic = "gvw@san.rr.com";
		String diane = "dfrw@san.rr.com";
		String june = "joonspoon@joonspoon.com";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.debug", "true");

		Session session = Session.getInstance(props);

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));

			InternetAddress[] address = { new InternetAddress(vic),
					new InternetAddress(diane), new InternetAddress(june) };
			msg.setRecipients(Message.RecipientType.TO, address);

			msg.setSubject("Java Classes");
			msg.setSentDate(new Date());

			msg.setText("hello");
			Transport.send(msg);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
