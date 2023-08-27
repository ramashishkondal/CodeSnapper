import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParsingString {
     public ArrayList<String> getParsedName(String path){
        ArrayList<String> file = new ArrayList<>();
        String p="";
        int i;
        for (i = path.length() - 1; i>=0 ; i--) {

            if(path.charAt(i) == '.'){
                break;
            }

            p=path.charAt(i) + p;
        }

        file.add(p);
        p = "";

        for (--i; i>=0; i--){
            if(path.charAt(i) == '/'){
                break;
            }
            p=path.charAt(i) + p;
        }

        file.add(0,p);
        p="";

        while(i>=0){
            p=path.charAt(i) + p;
            i--;
        }
        file.add(p);

        return file;
    }


    public String getFileName(ArrayList<String> parsedName){
        if(parsedName.size() < 2){
            return "";
        }
        return parsedName.get(0) + '.' + parsedName.get(1);
    }
    public String getCode(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        String file = "";
        while ((line = br.readLine()) != null) {
            file += "\n" + line;
        }
        return file;
    }
}
