import java.io.*;

public class hard10 {
    public static void main(String[] args) throws IOException {
        File f = new File("yourFileName.txt");
        FileWriter fw = new FileWriter(f);
        /*fw.write("hii word1");
        fw.flush();
        fw.close();*/
        
        String wordToReplace = "word1";
        String replacementWord = "word2";
        int replacements = 0;

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder content = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            String modifiedLine = line.replaceAll(wordToReplace, replacementWord);
            content.append(modifiedLine).append("\n");

            replacements += line.length() - modifiedLine.length();
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content.toString());
        bw.close();
        System.out.println("Replacements: " + replacements);
    }
}
