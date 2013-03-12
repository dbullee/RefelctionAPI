package oplossingReubenBaruch.testclasses;

public class EmailSendError extends Exception {

public EmailSendError(String message)
{
super("email not send");	
}

}
