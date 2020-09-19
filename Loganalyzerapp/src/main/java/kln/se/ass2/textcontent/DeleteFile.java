package kln.se.ass2.textcontent;

public class DeleteFile implements TextFile {
    public void deletefile(){
        textfile.delete();
        System.out.println("File Deleted");
    }
}
