import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InsideClass {

    public static void printClass(String className) {
        try {
            Class<?> givenClass = Class.forName(className);
            System.out.println("\nInformation\n");
            String modifier;
            if (Modifier.toString(givenClass.getModifiers()).equals("")) {
                modifier = "";
                System.out.print(modifier);
            } else {
                modifier = Modifier.toString(givenClass.getModifiers());
                System.out.print(modifier + " ");
            }

            System.out.print("class " + givenClass.getName());

            printSuperClass(givenClass);
            printsInterfaces(givenClass);
            System.out.print(" {\n");

            System.out.println("\nConstructors");
            printConstructors(givenClass);
            System.out.println("\nFields");
            printFields(givenClass);
            System.out.println("\nMethods");
            printMethods(givenClass);
            System.out.println("\n}");
        } catch (ClassNotFoundException e) {
            System.out.println("The name of searching class is incorrect! Starts program again with correct name of class!");
            e.printStackTrace();
        } finally {
            System.out.println("\nIt is all)");
            System.out.close();
        }
    }

    private static void printSuperClass(Class<?> clas) {
        Class<?> superClass = clas.getSuperclass();
        if (superClass != null && superClass != Object.class) {
            System.out.print(" extends " + superClass.getName());
        }
    }
    private static void printsInterfaces(Class<?> clas) {
        Class<?>[] interfaces = clas.getInterfaces();
        if (interfaces.length != 0) {
            System.out.print(" implements ");
        }
        for (int i = 0; i < interfaces.length; i++) {
            String interfaceName = interfaces[i].getName();
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(interfaceName);
        }
    }
    private static void printConstructors(Class<?> clas) {
        Constructor<?>[] constructors = clas.getDeclaredConstructors();

        for (Constructor<?> construct : constructors) {

            String modifier;
            if (Modifier.toString(construct.getModifiers()).equals("")) {
                modifier = "";
                System.out.print(modifier);
            } else {
                modifier = Modifier.toString(construct.getModifiers());
                System.out.print(modifier + " ");
            }

            String constructName = construct.getName();
            System.out.print(constructName + "(");

            Class<?>[] constructParameters = construct.getParameterTypes();
            for (int i = 0; i < constructParameters.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                switch (constructParameters[i].getName().substring(0, 2)) {
                    case "[B":
                        System.out.print("byte[]");
                        break;
                    case "[I":
                        System.out.print("int[]");
                        break;
                    case "[C":
                        System.out.print("char[]");
                        break;
                    case "[L":
                        System.out.print(constructParameters[i].getName().substring(3, constructParameters[i].getName().length() - 1) + "[]");
                        break;
                    default:
                        System.out.print(constructParameters[i].getName());
                }
            }
            System.out.print(");\n");
        }
    }
    private static void printFields(Class<?> clas) {
        Field[] fields = clas.getDeclaredFields();
        for (Field field : fields) {

            String modifier;
            if (Modifier.toString(field.getModifiers()).equals("")) {
                modifier = "";
                System.out.print(modifier);
            } else {
                modifier = Modifier.toString(field.getModifiers());
                System.out.print(modifier + " ");
            }

            Class<?> typeField = field.getType();
            String fieldType = typeField.getName();
            switch (fieldType.substring(0, 2)) {
                case "[B":
                    System.out.print("boolean[]" + " ");
                    break;
                case "[I":
                    System.out.print("int[]" + " ");
                    break;
                case "[C":
                    System.out.print("char[]" + " ");
                    break;
                case "[L":
                    System.out.print(typeField.getName()
                            .substring(2, typeField.getName().length() - 1) + "[]" + " ");
                    break;
                default:
                    System.out.print(fieldType + " ");
            }

            String fieldName = field.getName();
            System.out.print(fieldName + ";\n");
        }
    }
    private static void printMethods(Class<?> clas) {
        Method[] methods = clas.getDeclaredMethods();

        for (Method meth : methods) {
            String modifier;
            if (Modifier.toString(meth.getModifiers()).equals("")) {
                modifier = "";
                System.out.print(modifier);
            } else {
                modifier = Modifier.toString(meth.getModifiers());
                System.out.print(modifier + " ");
            }

            String methodName = meth.getName();
            String methodRetType = meth.getReturnType().getName();
            switch (methodRetType.substring(0, 2)) {
                case "[B":
                    System.out.print("byte[]" + " ");
                    break;
                case "[I":
                    System.out.print("int[]" + " ");
                    break;
                case "[C":
                    System.out.print("char[]" + " ");
                    break;
                case "[L":
                    System.out.print(meth.getReturnType().getName()
                            .substring(2, meth.getReturnType().getName().length() - 1) + "[]" + " ");
                    break;
                default:
                    System.out.print(meth.getReturnType().getName() + " ");
            }
            System.out.print(methodName + "(");
            Class<?>[] methParameters = meth.getParameterTypes();
            for (int i = 0; i < methParameters.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                switch (methParameters[i].getName().substring(0, 2)) {
                    case "[B":
                        System.out.print("byte[]");
                        break;
                    case "[I":
                        System.out.print("int[]");
                        break;
                    case "[C":
                        System.out.print("char[]");
                        break;
                    case "[L":
                        System.out.print(methParameters[i].getName().substring(2, methParameters[i].getName().length() - 1) + "[]");
                        break;
                    default:
                        System.out.print(methParameters[i].getName());
                }
            }
            System.out.print(");\n");
        }
    }

}
