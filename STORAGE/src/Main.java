import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nМЕНЮ:");
            System.out.println("1. ОПЕРАЦИИ СО СКЛАДОМ");
            System.out.println("2. ОПЕРАЦИИ С ПУНКТОМ ПРОДАЖ");
            System.out.println("3. ОПЕРАЦИИ С СОТРУДНИКАМИ");
            System.out.println("4. ОПЕРАЦИИ С ПОКУПАТЕЛЯМИ");
            System.out.println("0. Выход");
            System.out.println("Ваш выбор: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    warehouse w = new warehouse();
                    int choice1;
                    do {
                        System.out.println("\nВЫБЕРИТЕ ОПЕРАЦИЮ СО СКЛАДОМ");
                        System.out.println("1. ЗАКУПИТЬ ТОВАРЫ НА СКЛАД");
                        System.out.println("2. ПЕРЕДАТЬ ТОВАР НА ПУНКТ ПРОДАЖ");
                        System.out.println("3. УДАЛИТЬ СОДЕРЖИМОЕ СКЛАДА");
                        System.out.println("4. УЗНАТЬ ИНФОРМАЦИЮ О СКЛАДЕ");
                        System.out.println("0. ВЕРНУТЬСЯ В МЕНЮ");
                        choice1 = scan.nextInt();
                        switch (choice1) {
                            case 1:
                                w.buy();
                                break;
                            case 2:
                                w.printInfo();
                                w.transfer();
                                break;
                            case 3:
                                w.remove();
                                break;
                            case 4:
                                w.printInfo();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                        }
                    } while (choice1 != 0);
                    break;
                case 2:
                    salespoint s = new salespoint();
                    int choice2;
                    do {
                        System.out.println("1. ПРОДАТЬ ТОВАР");
                        System.out.println("2. ПЕРЕДАТЬ ТОВАР НА СКЛАД");
                        System.out.println("3. УДАЛИТЬ СОДЕРЖИМОЕ ПУНКТА ПРОДАЖ.");
                        System.out.println("4. УЗНАТЬ ИНФОРМАЦИЮ О ПУНКТЕ ПРОДАЖ");
                        System.out.println("0. ВЕРНУТЬСЯ В МЕНЮ");
                        System.out.println("ВЫБЕРИТЕ ОПЕРЦИЮ");
                        choice2 = scan.nextInt();
                        switch (choice2) {
                            case 1:
                                s.printInfo();
                                s.sell();
                                break;
                            case 2:
                                s.printInfo();
                                s.transfer();
                                break;
                            case 3:
                                s.remove();
                                break;
                            case 4:
                                s.printInfo();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                        }
                    } while (choice2 != 0);
                    break;
                case 3:
                    int choice3;
                    do {
                        System.out.println("ЧЕЛОВЕК НА СОБЕСЕДОВАНИИ.");
                        worker w1 = new worker();
                        System.out.println("ХОТИТЕ ЛИ ВЫ НАНЯТЬ ЕГО? (1 == да) (2 == нет)");
                        choice3 = scan.nextInt();
                        switch (choice3) {
                            case 1:
                                w1.insertInfo();
                                int tempChoice;
                                do {
                                    System.out.println("1. УВОЛИТЬ СОТРУДНИКА");
                                    System.out.println("2. УЗНАТЬ ИНФОРМАЦИЮ О СОТРУДНИКАХ");
                                    System.out.println("0. ВЫХОД");
                                    tempChoice = scan.nextInt();
                                    switch (tempChoice) {
                                        case 1:
                                            w1.printInfo();
                                            w1.removeWorker();
                                            break;
                                        case 2:
                                            w1.printInfo();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                                    }
                                } while (tempChoice != 0);
                                break;
                            case 2:
                                System.out.println("ВЫ СКАЗАЛИ ЧТО ПЕРЕЗВОНИТЕ ЕМУ");
                                break;
                            default:
                                System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                        }
                    } while (choice3 != 2);
                    break;
                case 4:
                    int choice4;
                    do {
                        System.out.println("ПРИШЕЛ НОВЫЙ ПОКУПАТЕЛЬ: ");
                        customer c = new customer();
                        System.out.println("ВВЕСТИ ДАННЫЕ ПОКУПАТЕЛЯ В СИСТЕМУ?(1 == да) (2 == нет)");
                        choice4 = scan.nextInt();
                        switch (choice4) {
                            case 1:
                                c.insertInfo();
                                int choicetemp10;
                                do {
                                    System.out.println("УЗНАТЬ ИНФОРМАЦИЮ О ПОКУПАТЕЛЕ? (1 == да) (2 == нет)");
                                    choicetemp10 = scan.nextInt();
                                    switch (choicetemp10) {
                                        case 1:
                                            c.printInfo();
                                            break;
                                        case 2:
                                            break;
                                        default:
                                            System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                                    }
                                } while (choicetemp10 != 2);
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                        }
                    } while (choice4 != 2);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
            }

        } while (choice != 0);

        scan.close();
    }
}