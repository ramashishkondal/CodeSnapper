import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Code {
    public static void main(String[] args) {
        String path= "/home/ashu/Documents/305/a.cpp";
        ParsingString parsedStringHandling= new ParsingString();
        ArrayList<String> parsedName= parsedStringHandling.getParsedName(path);
        String fileName = parsedStringHandling.getFileName(parsedName);
        String code = null;
        String out = null;
        try{
        code = parsedStringHandling.getCode(path);}
        catch(Exception e){
            e.printStackTrace();
        }
//        System.out.println("gcc"+parsedName.get(2)+parsedName.get(0) + "." + parsedName.get(1)+"-o"+ parsedName.get(2) + parsedName.get(0));
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
        System.out.println("file name - " + fileName + " code - " +  code);
        System.out.println("Output -");
        System.out.println(out);
    }


    public static String getOutput(String directory,String filename) throws IOException{

        String path = directory + filename;

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

        ProcessBuilder processBuilder = new ProcessBuilder("g++",parsedName.get(2)+parsedName.get(0) + "." + parsedName.get(1),"-o",parsedName.get(2) + parsedName.get(0));
        Process process = null;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
