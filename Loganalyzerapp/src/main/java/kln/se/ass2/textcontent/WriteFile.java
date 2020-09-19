package kln.se.ass2.textcontent;

import java.io.FileWriter;

public class WriteFile implements TextFile {
    public void writetofile(String currenttimestamp){

        try {
            FileWriter fw = new FileWriter(filepath,true);
            fw.write(currenttimestamp+"\n");
            fw.close();
            System.out.println("Current Timestamp notted to text file");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
