package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);
        // BEGIN
        for (Method method : address.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                String methodName = method.getName();
                Class returnType = method.getReturnType();
                String className[] = returnType.getCanonicalName().split("\\.");
                String name = className[className.length - 1];
                String result = "Method " + methodName + " returns a value of type " + name;
                System.out.println(result);
            }

        }
        // END
    }
}
