package oplossingReubenBaruch.testclasses;

public class MethodMan {

	
	public String callMeMaybe(String callername)
	
	{
		String respond="";
		switch (callername) {
		case "reuben":
			 respond="hello Reuben";
			
			break;

		case "rebs":
			 respond="hello rebs";
			
			break;

			
			
			
		default:
			respond="i do not know u"+callername;
			break;
		}
		
		return respond;
	}
}
