import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        String className;

        if (args.length > 0) {
            System.out.println("\nHello, Developer!");
            className = args[0];
            try {
                InsideClass.printClass(className);
            } catch (NullPointerException e) {
                e.printStackTrace();
            } finally {
                System.out.println("\nIt is all)");
                System.out.close();
            }
        }
        className = JOptionPane.showInputDialog("\nHello, Developer!\n" +
                "Enter full class name (e.g. \"java.lang.Double\"): ");
        try {
            InsideClass.printClass(className);
        } catch (NullPointerException e) {
            e.getStackTrace();
        } finally {
            System.out.println("\nIt is all)");
            System.out.close();
        }

    }
}