import java.io.*;

public class salespoint extends storage{


    public void sell(){
        String temp = "temp.txt";
        File oldfile = new File("productsSalesPoint.txt");
        File newfile = new File (temp);

        int line = 0;
        String currentLine;
        System.out.println("Введите номер позиции продукта, которого хотите продать");
        int deleteLine = scan.nextInt();
        try{
            FileWriter fw = new FileWriter(temp, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("productsSalesPoint.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null){
                line++;
                if(deleteLine != line){
                    pw.println(currentLine);
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldfile.delete();
            File dump = new File("productsSalesPoint.txt");
            newfile.renameTo(dump);
            System.out.println("Вы успешно продали продукт на " + deleteLine + " позиции");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    @Override
    protected void transfer() {
        File salespointfile = new File("productsSalesPoint.txt");
        File newfileSALES = new File ("temp3.txt");

        File warehousefile = new File("productsWarehouse.txt");
        try {


            // Открываем файл для чтения
            BufferedReader readerSALES = new BufferedReader(new FileReader(salespointfile));
            // Открываем файл для записи
            BufferedWriter writer = new BufferedWriter(new FileWriter(warehousefile, true));
            // Открываем временный файл для записи
            BufferedWriter temporSALES = new BufferedWriter(new FileWriter(newfileSALES));

            String line;
            int position = 0;
            System.out.println("Введите номер продукта, которого вы хотите передать на СКЛАД");
            int productPos = scan.nextInt();
            // Читаем данные из файла input.txt
            while ((line = readerSALES.readLine()) != null) {
                position++;
                if (productPos == position){
                    // Записываем данные в файл output.txt
                    writer.write(line);
                    writer.newLine();// Добавляем перенос строки
                }
                if (productPos != position){
                    temporSALES.write(line);
                    temporSALES.newLine();
                }
            }
            // Закрываем потоки
            readerSALES.close();
            writer.close();
            temporSALES.close();

            salespointfile.delete();
            File SALES = new File("productsSalesPoint.txt");
            newfileSALES.renameTo(SALES);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void remove() {
        try {
            File file = new File("productsSalesPoint.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
            System.out.println("Вы удалили продукты пункта продаж!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    @Override
    protected void printInfo() {
        System.out.println("Адрес:" + address + "\nВместимость: " + capacity);
        fileReader_salespoint();
    }
    public void fileReader_salespoint(){
        try(FileReader reader = new FileReader("productsSalesPoint.txt"))
        {
            // читаем посимвольно
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
