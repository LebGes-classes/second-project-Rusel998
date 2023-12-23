import java.io.*;

public class warehouse extends storage {

    @Override
    protected void transfer() {
        File warehousefile = new File("productsWarehouse.txt");
        File newfileWARE= new File ("temp1.txt");

        File salespointfile = new File("productsSalesPoint.txt");
        try {

            // Открываем файл склада для чтения
            BufferedReader readerWARE = new BufferedReader(new FileReader(warehousefile));
            // Открываем файл пп для записи
            BufferedWriter writer = new BufferedWriter(new FileWriter(salespointfile, true));
            // Открываем временный файл для записи
            BufferedWriter temporWARE = new BufferedWriter(new FileWriter(newfileWARE));

            String line;
            int position = 0;
            System.out.println("Введите номер продукта, которого вы хотите передать в ПУНКТ ПРОДАЖ");
            int productPos = scan.nextInt();
            // Читаем данные из файла input.txt
            while ((line = readerWARE.readLine()) != null) {
                position++;
                if (productPos == position){
                    // Записываем данные в файл output.txt
                    writer.write(line);
                    writer.newLine();// Добавляем перенос строки
                }
                if (productPos != position){
                    temporWARE.write(line);
                    temporWARE.newLine();
                }
            }
            // Закрываем потоки
            readerWARE.close();
            writer.close();
            temporWARE.close();

            warehousefile.delete();
            File WARE = new File("productsWarehouse.txt");
            newfileWARE.renameTo(WARE);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void remove() {
        try {
            File file = new File("productsWarehouse.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
            System.out.println("Вы удалили продукты склада!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    @Override
    protected void printInfo() {
        System.out.println("Адрес:" + address + "\nРазмер: " + capacity);
        fileReader_warehouse();
    }

    public void buy() {
        try {
            FileWriter fw = new FileWriter("productsWarehouse.txt", true); // открываем файл для добавления
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            // вводим данные с консоли и добавляем их на новые строки
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите то, что вы хотели бы закупить(название товара): ");
            System.out.println("(для завершения введите 'вых'):");
            int i = 0;
            while (!(productName = reader.readLine()).equalsIgnoreCase("вых")) {
                i++;
                if(i <= capacity){
                    System.out.println("Введите цену товара: ");
                    price =scan.nextInt();
                    scan.nextLine();
                    System.out.println("Введите свежесть товара: ");
                    productFreshness = scan.nextLine();
                    System.out.println("Введите размер товара: ");
                    size = scan.nextLine();
                    System.out.println("Введите описание товара: ");
                    description = scan.nextLine();
                    System.out.println("Что-нибудь еще?(закупить): ");
                    out.println("{ " + productName + "| Цена: " + price + "| Свежесть: " +
                            productFreshness + "| Размер: " + size + "| Описание: " + description + " }");
                }
            }
            out.close(); // закрываем потоки
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void fileReader_warehouse(){
        try(FileReader reader = new FileReader("productsWarehouse.txt"))
        {// читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
            System.out.println();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

