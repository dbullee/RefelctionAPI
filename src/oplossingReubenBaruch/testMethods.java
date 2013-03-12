package oplossingReubenBaruch;
import static org.junit.Assert.*;

import java.awt.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.management.remote.TargetedNotification;

import org.junit.Ignore;
import org.junit.Test;

import oplossingReubenBaruch.testclasses.Gmail;
import oplossingReubenBaruch.testclasses.GmailUser;
import oplossingReubenBaruch.testclasses.Imail;
import oplossingReubenBaruch.testclasses.ImailUser;
import oplossingReubenBaruch.testclasses.MethodMan;


public class testMethods {

	
	//here u will test if you will get all the method of the class including the declared methods
	@Test
	public void testIfGetAllMethods()
	
	{
		Gmail g = new Gmail();
		String[] expectedMethods ={"getName","emailAdress"};
		
		assertArrayEquals("begin", expectedMethods, Utils.getAllClassMethods(g));
		
		
	}
	//this is for testing if you can get the declaring methods of the object 
	@Test
	public void testIfGetDeclaredAllMethods()
	
	{
		Gmail g = new Gmail();
		String[] expectedMethods ={"getName","emailAdress"};
		
		assertArrayEquals("begin", expectedMethods, Utils.getAllDeclaredClassMethods(g));
		
		
	}
	

	
	
	
	//this is for testing if you get the class declaring method and the inherited methods
	@Test
	public void testIfGetInheritedAndDeclaredMethods()
	
	{
		GmailUser guser = new GmailUser();
		String[] expectedMethods ={"sendEmail","getName","emailAdress"};
		
		assertArrayEquals("begin2", expectedMethods, Utils.getAllDeclaredClassAndInheritedMethods(guser));
		
		
	}
	//this is a test if the object is instance of a super object.
	@Test 
	public void testIfClassIsSubClass()
	{
		Gmail g=new Gmail();
		GmailUser guser= new GmailUser();
		assertTrue(Utils.isSubClass(guser));
		
		
		
	}
	//this is a test if the object is instance of a interface object.
	@Test 
	public void testIfInterface()
	{
		
	ImailUser imailUser = new ImailUser();
	
		
		assertTrue(Utils.isInterface(imailUser));
		
		
		
	}
	// this is a test if you can get the method  using its name
	@Test
	public void testIfGetMethodByName()throws NoSuchMethodException
	{
		Gmail g=new Gmail();
		GmailUser guser= new GmailUser();
		
		
		Imail mailme = null ;
	String	inputString="getName";
	String outputString="";
		Method m =Utils.getSupportedMethod(guser.getClass(), inputString,null);
		outputString=m.getName();
		assertTrue(inputString.equals(outputString));
		
		
		
		
		
	}
	// this is a test if u can invoke a method using the reflection API
	@Test
	public void testIfCanInvokeMethod() throws NoSuchMethodException,IllegalAccessException,InvocationTargetException
	{
	
	String methodName="callMeMaybe";
	String	inputString="reuben";
	String outputString="";
	String expected="hello Reuben";
	MethodMan methodman = new MethodMan();
	Method m =Utils.getSupportedMethod(MethodMan.class, methodName,new Class[]{String.class});
		
	outputString=(String)	m.invoke(methodman, new Object[]{inputString});
	
	
	assertTrue(expected.equals(outputString));
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
