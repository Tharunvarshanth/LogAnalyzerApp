package kln.se.ass2.textcontent;

public class FileExistence implements TextFile {
    public Boolean isfilecreated(){

        if(textfile.exists()){
            return true;
        }
        else{
            return false;
        }
    }
}
