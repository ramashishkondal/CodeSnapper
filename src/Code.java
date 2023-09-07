import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Code {
    public static void main(String[] args) {
    }
    public void fileManagement(String path) {
        ParsingString parsedStringHandling= new ParsingString();
        ArrayList<String> parsedName= parsedStringHandling.getParsedName(path);
        String fileName = parsedStringHandling.getFileName(parsedName);
        String code = null;
        String out;
        try{
        code = parsedStringHandling.getCode(path);}
        catch(Exception e){
            e.printStackTrace();
        }
        try {
            compileCode(parsedName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            out = getOutput(parsedName.get(2),parsedName.get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(parsedName);
        String savetoFileName =  "/home/ashu/Documents/example.txt"; // Change this to the path of your file

        try {
            // Create a FileWriter in append mode (true as the second parameter)
            FileWriter writer = new FileWriter(savetoFileName, true);

            // Text to append
            String textToAppend = "\nfile name - " + fileName + " \ncode - " +  code + "\n" + "Output -" + out;

            // Append the text to the file
            writer.write(textToAppend);

            // Close the FileWriter
            writer.close();

            System.out.println("Text appended to the file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }


    public static String getOutput(String directory,String filename) throws IOException{

        String path = directory + "a";

        Process process = Runtime.getRuntime().exec(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        String out = "";
        while ((line = reader.readLine()) != null) {
            out = out + "\n" + line;
        }
        return out;
    }

    public static void compileCode(ArrayList<String> parsedName) throws IOException{

        ProcessBuilder processBuilder = new ProcessBuilder("g++",parsedName.get(2)+parsedName.get(0) + "." + parsedName.get(1),"-o",parsedName.get(2) + "a");
        Process process = null;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
