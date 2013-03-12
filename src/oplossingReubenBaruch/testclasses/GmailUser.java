package oplossingReubenBaruch.testclasses;

public class GmailUser extends Gmail{


public void sendEmail(String emailAdress) throws EmailSendError
{
	if(emailAdress.equalsIgnoreCase("fail")){
		throw new EmailSendError("Email not send");
	
	}
	
	System.out.print("email send");
}



}
