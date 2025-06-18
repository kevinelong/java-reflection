import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            // 1. Get the Class object for a class
            Class<?> myClass = MyClass.class; // Or Class.forName("ReflectionExample.MyClass");

            // 2. Get all public methods declared in the class
            Method[] methods = myClass.getMethods();

            System.out.println("Methods in MyClass:");
            for (Method method : methods) {
                System.out.println("- " + method.getName());
            }

            // 3. Invoke a specific method by name
            Object instance = myClass.getDeclaredConstructor().newInstance(); // Create an instance of MyClass
            Method specificMethod = myClass.getMethod("sayHello", String.class); // Get the 'sayHello' method

            // Invoke the method on the instance with arguments
            specificMethod.invoke(instance, "World");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyClass {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void anotherMethod() {
        System.out.println("This is another method.");
    }
}