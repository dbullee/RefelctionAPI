package learning.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
	private Person personObject;

	public ReflectionTest(){
		personObject = new Person();
		personObject.setFirstName("Dennis");
		personObject.setLastName("Bullee");
		String[] items = {"Schoen", "Laptop", "Telefoon"};
		personObject.setItems(items);
		Class<?> personClass = personObject.getClass();

		printClassName(personClass);
		printFields(personClass);
		printMethodes(personClass);
		invokeGetItems(personClass);
		invokeSetFirstName(personClass);
	}

	public void printClassName(Class<?> cls){
		System.out.println("Class: " + cls.getName() + "\n");
	}

	public void printFields(Class<?> cls){
		Field[] fields = cls.getDeclaredFields();
		
		System.out.println("Fields:");
		for(Field f : fields){
			System.out.println(f.getType().getSimpleName() + " " + f.getName());
		}
		System.out.println();
	}

	public void printMethodes(Class<?> cls){
		Method[] methods = cls.getDeclaredMethods();
		
		System.out.println("Methods:");
		for(Method m : methods){
			System.out.println(m.getName());
		}
		System.out.println();
	}

	public void invokeGetItems(Class<?> cls){
		try {
			Method getItems = cls.getMethod("getItems", null);
			String[] items = (String[]) getItems.invoke(personObject, null);
			
			System.out.println("Invoke getItems() results:");
			for(String item : items){
				System.out.println(item);
			}
			System.out.println();
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

	public void invokeSetFirstName(Class<?> cls){
		try {
			Method setFirstname = cls.getMethod("setFirstName", new Class[] { String.class });

			System.out.println("Invoke setFirstName()");
			System.out.println("before:\t" + personObject.getFirstName());
			setFirstname.invoke(personObject, "Jan");
			System.out.println("after:\t" + personObject.getFirstName() + "\n");
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
