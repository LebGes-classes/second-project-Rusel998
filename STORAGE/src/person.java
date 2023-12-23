import java.util.Scanner;

public abstract class person {

    protected Scanner scan = new Scanner(System.in);
    protected String name;
    protected String birthday;
    protected String sex;
    protected String personId;
    person(){
        System.out.println("Введите ФИО: ");
        name = scan.nextLine();
        System.out.println("Мужчина/Женщина ?: ");
        sex = scan.nextLine();
        System.out.println("Введите дату рождения: ");
        birthday = scan.nextLine();
        System.out.println("Введите ID: ");
        personId = scan.nextLine();
    }

    protected abstract void printInfo();
}
