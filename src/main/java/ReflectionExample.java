import java.lang.reflect.Method;

class GreeterService extends Object{
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void anotherMethod() {
        System.out.println("This is another method.");
    }
}

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            // 1. Get the Class object for a class
            Class<?> c = GreeterService.class; // Or Class.forName("ReflectionExample.MyClass");

            // 2. Get all public methods declared in the class
            Method[] methods = c.getMethods();

            System.out.println("Methods in MyClass:");
            for (Method method : methods) {
                System.out.println("\t - " + method.getName());
            }

            // 3. Invoke a specific method by name
            Object instance = c.getDeclaredConstructor().newInstance(); // Create an instance of MyClass
            Method specificMethod = c.getMethod("sayHello", String.class); // Get the 'sayHello' method

            // Invoke the method on the instance with arguments
            specificMethod.invoke(instance, "World");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

