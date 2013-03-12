package superoplossing;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ReflectionTest {
	private Person personObject;
	private Class<?> personClass;
	private Class<?> consumerClass;

	@Before
	public void init(){
		personObject = new Person();
		personObject.setFirstName("Dennis");
		personObject.setLastName("Bullee");
		String[] itemsPerson = {"Schoen", "Laptop", "Telefoon"};
		personObject.setItems(itemsPerson);
		
		personClass = personObject.getClass();
	}

	/**
	 * Tests the retrieval of the Class name 
	 */
	@Test
	public void classNameTest(){
		String className = personClass.getName();
		assertEquals("learning.test.Person", className);
	}

	/**
	 * Tests the retrieval of Fields
	 */
	@Test
	public void fieldsTest(){
		Field[] fields = personClass.getDeclaredFields();
		assertEquals("firstName", fields[0].getName());
		assertEquals("lastName", fields[1].getName());
		assertEquals("items", fields[2].getName());
	}

	/**
	 * Tests the retrieval of declared Methods
	 */
	@Test
	public void methodesTest(){
		Method[] methods = personClass.getDeclaredMethods();
		
		//Array of Methods has random order and sorting can't be done with Method objects
		String[] methodNames = new String[6];
		methodNames[0] = methods[0].getName();
		methodNames[1] = methods[1].getName();
		methodNames[2] = methods[2].getName();
		methodNames[3] = methods[3].getName();
		methodNames[4] = methods[4].getName();
		methodNames[5] = methods[5].getName();
		Arrays.sort(methodNames);
		
		assertEquals("getFirstName", methodNames[0]);
		assertEquals("getItems", methodNames[1]);
		assertEquals("getLastName", methodNames[2]);
		assertEquals("setFirstName", methodNames[3]);
		assertEquals("setItems", methodNames[4]);
		assertEquals("setLastName", methodNames[5]);
	}

	/**
	 * Tests the invocation of getItems (Array) by invoking it via the Reflection API
	 */
	@Test
	public void getItemsTest(){
		try {
			Method getItems = personClass.getMethod("getItems", null);
			String[] items = (String[]) getItems.invoke(personObject, null);
			
			assertEquals(items[0], "Schoen");
			assertEquals(items[1], "Laptop");
			assertEquals(items[2], "Telefoon");
		} catch(Exception e){
			/*Catches: 
			 * NoSuchMethodException
			 * SecurityException
			 * IllegalAccessException
			 * IllegalArgumentException
			 * InvocationTargetException
			 */
			e.printStackTrace();
		}
	}

	/**
	 * Tests the invoking of the method setFirstName by invoking it via the Reflection API
	 */
	@Test
	public void setFirstNameTest(){
		try {
			Method setFirstname = personClass.getMethod("setFirstName", new Class[] { String.class });
			setFirstname.invoke(personObject, "Jan");
			String firstNameAfter = personObject.getFirstName();
			assertEquals("Jan", firstNameAfter);
		} catch(Exception e){
			/*Catches: 
			 * NoSuchMethodException
			 * SecurityException
			 * IllegalAccessException
			 * IllegalArgumentException
			 * InvocationTargetException
			 */
			e.printStackTrace();
		}
	}
}
