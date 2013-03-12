package oplossingReubenBaruch;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import oplossingReubenBaruch.testclasses.Gmail;
import oplossingReubenBaruch.testclasses.Imail;


public class Utils {
	
	
	public static Object[] getAllClassMethods(Object classforgettingmethods)
	{
		Method[] allMethods = classforgettingmethods.getClass().getMethods();
		ArrayList<String> methodNames = new ArrayList<String>();
		
		for(Method method : allMethods)
		{
			methodNames.add(method.getName());
		
		}
		
		
		
		return methodNames.toArray();
		
		
		
	}
	public static Object[] getAllDeclaredClassMethods(Object classforgettingmethods)
	{
		
		Method[] allMethods = classforgettingmethods.getClass().getDeclaredMethods();
		ArrayList<String> methodNames = new ArrayList<String>();
		
		for(Method method : allMethods)
		{
			methodNames.add(method.getName());
			
		}
		
		
	
		return methodNames.toArray();
		
		
		
	}
	
	
	public static Object[] getAllDeclaredClassAndInheritedMethods(Object classforgettingmethods)
	{
		Class subClass = classforgettingmethods.getClass();
		Class superClass = subClass.getSuperclass();
		
		Method[] subClassMethods = subClass.getDeclaredMethods();
		
		Method[] superClassMethods = superClass.getDeclaredMethods();
		
		
		Method[] allMethods= new Method[subClassMethods.length+superClassMethods.length] ;
		 System.arraycopy(subClassMethods, 0, allMethods, 0, subClassMethods.length);
		   System.arraycopy(superClassMethods, 0, allMethods, subClassMethods.length, superClassMethods.length);
		
		ArrayList<String> methodNames = new ArrayList<String>();
		
		for(Method method : allMethods)
		{
			methodNames.add(method.getName());
			
		}
		
		
	
		return methodNames.toArray();
		
		
		
	}
	
	public static boolean isSubClass(Object ifSubclass)
	{
		
		
		Class subclass = ifSubclass.getClass().getSuperclass();
		
		if(subclass == Object.class){return false;}else{return true;}
		
		
		
		
		
	}
	public static boolean isInterface(Object chekIfInterface) {
			
		Class chekMe = chekIfInterface.getClass();
		
		Class[] interfaceClasses =chekMe.getInterfaces();
		
		boolean result = interfaceClasses.length>0 ? true:false;
		
		
		
		return result;
	}
	public static Method getSupportedMethod( Class cls,String name,Class[] paramTypes)throws NoSuchMethodException
			{
			if (cls == null) {
			throw new NoSuchMethodException();
			}
			try {
			
		   return cls.getDeclaredMethod( name, paramTypes );
			}
			catch (NoSuchMethodException ex) {
			return getSupportedMethod( cls.getSuperclass(), name, paramTypes );
			}
			}
	

}
