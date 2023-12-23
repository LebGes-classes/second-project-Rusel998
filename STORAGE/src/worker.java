import java.io.*;

public class worker extends person {

    @Override
    protected void printInfo() {
        try (FileReader reader = new FileReader("workers.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
    public void insertInfo() {
        System.out.println("ВВЕДИТЕ ДОЛЖНОСТЬ СОТРУДНИКА");
        String job = scan.nextLine();
        File cust = new File("workers.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(cust, true));
            bw.write("{ ФИО: " + name + "| Пол: " + sex + "| ДР: " + birthday +
                    "| Id сотрудника: " + personId + "| Должность: " + job + " }");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void removeWorker() {
        File workerFILE = new File("workers.txt");
        File newfileWORK = new File("temp0.txt");
        try {

            // Открываем файл для чтения
            BufferedReader readerWORK = new BufferedReader(new FileReader(workerFILE));
            // Открываем временный файл для записи
            BufferedWriter temporWORK = new BufferedWriter(new FileWriter(newfileWORK));

            String line;
            int position = 0;
            System.out.println("Введите id сотрудника, которого вы хотите уволить");
            int workID = scan.nextInt();
            // Читаем данные из файла input.txt
            while ((line = readerWORK.readLine()) != null) {
                position++;
                if (workID != position) {
                    temporWORK.write(line);
                    temporWORK.newLine();
                }
            }
            // Закрываем потоки
            readerWORK.close();
            temporWORK.close();

            workerFILE.delete();
            File worker1 = new File("workers.txt");
            newfileWORK.renameTo(worker1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
