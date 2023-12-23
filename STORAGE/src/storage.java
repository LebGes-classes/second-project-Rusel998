import java.util.Scanner;

public abstract class storage {
    protected Scanner scan = new Scanner(System.in);
    protected int capacity;
    protected String address;
    protected String productName;
    protected String productFreshness;
    protected double price;
    protected String description;
    protected String size;
    storage() {
        System.out.println("Введите вместимость помещения: ");
        capacity = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите адрес помещения: ");
        address = scan.nextLine();
    }

    protected abstract void transfer();
    protected abstract void remove();
    protected abstract void printInfo();

}
