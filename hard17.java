import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class hard17 {
    public static void main(String[] args) throws Exception {
        File f = new File("number.txt");
        f.createNewFile();
        FileWriter fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("1");
        bw.newLine();
        bw.write("2");
        bw.newLine();
        bw.write("3");
        bw.newLine();
        bw.write("4");
        bw.newLine();
        bw.flush();
        /*File f1 = new File("even.txt");
        f1.createNewFile();
        File f2 = new File("odd.txt");
        f2.createNewFile();*/
        BufferedReader reader = new BufferedReader(new FileReader("number.txt"));
        BufferedWriter evenWriter = new BufferedWriter(new FileWriter("even.txt"));
        BufferedWriter oddWriter = new BufferedWriter(new FileWriter("odd.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            int num = Integer.parseInt(line);
            if (num % 2 == 0) {
                evenWriter.write(line);
                evenWriter.newLine();
            } else {
                oddWriter.write(line);
                oddWriter.newLine();
            }
        }
        bw.close();
        reader.close();
        evenWriter.close();
        oddWriter.close();
    }
}
