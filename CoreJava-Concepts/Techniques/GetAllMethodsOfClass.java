package Techniques;

import java.lang.reflect.Method;

public class GetAllMethodsOfClass {
    public static void main(String[] args) {
        Class<?> clazz = String.class; // Get metadata for the String class

        // Print method names
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}