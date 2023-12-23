import java.io.*;

public class customer extends person{
    @Override
    protected void printInfo() {
        try(FileReader reader = new FileReader("customers.txt"))
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
    public void insertInfo(){
        File cust = new File("customers.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(cust, true));
            bw.write("{ ФИО: " + name + "| Пол: " + sex + "| ДР: " + birthday +
                    "| Id сотрудника: " + personId + " }");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
