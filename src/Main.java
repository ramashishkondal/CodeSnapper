import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ParsingString str = new ParsingString();
        String path = "/home/ashu/Documents/305/yum.c";
        ArrayList<String> parsedName = str.getParsedName(path);
        ProcessBuilder processBuilder = new ProcessBuilder("gcc",parsedName.get(2)+parsedName.get(0) + "." + parsedName.get(1),"-o", parsedName.get(0));
        Process process = null;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
}}