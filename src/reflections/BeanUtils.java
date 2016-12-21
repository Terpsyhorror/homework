package reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by daryatretakova on 21.12.16.
 */
public class BeanUtils {
    public static void assign(Object to, Object from) {
        Class<?> aClass = from.getClass();
        Class<?> aClass1 = to.getClass();
        for (Method method : aClass.getMethods()){
            if(method.getName().startsWith("get")) {
                for (Method method1 : aClass1.getMethods()) {
                    if (method1.getName().startsWith("set")) {
                        if (method.getName().substring(3).equals(method1.getName().substring(3)) &&
                                method.getReturnType().equals(method1.getParameterTypes()[0])){
                            try {
                                method1.invoke(to, method.invoke(from, null));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("SSSS");
        person.setAge(12);
        Dog dog = new Dog();
        assign(dog, person);
        System.out.println(dog.getName()  + " " + dog.getAge());
    }
}
