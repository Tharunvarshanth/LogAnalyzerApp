package kln.se.ass2;

import kln.se.ass2.input.Input;
import kln.se.ass2.logfile.FirstReadLogFile;
import kln.se.ass2.logfile.MoreReadLogFile;
import kln.se.ass2.logvariable.LogVariables;
import kln.se.ass2.textcontent.CreateFile;
import kln.se.ass2.textcontent.FileExistence;
import kln.se.ass2.textcontent.ReadLastLine;
import kln.se.ass2.textcontent.TextFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LogAnalyzerApp {
    TextFile textfile;
    FirstReadLogFile firstReadLogFile;
    MoreReadLogFile moreReadLogFile;
    Input input;
    public LogAnalyzerApp(TextFile textfile, FirstReadLogFile firstReadLogFile, MoreReadLogFile moreReadLogFile, Input input)
    {
        this.textfile=textfile;
        this.firstReadLogFile = firstReadLogFile;
        this.moreReadLogFile = moreReadLogFile;
        this.input=input;
    }

    public void show() throws FileNotFoundException {

        String logfilepath=input.readFilepath();

        //Checkinh Log file or other file
        if(logfilepath==null){
            return;
        }

        if (!new FileExistence().isfilecreated()) {
            new CreateFile().createnewfile();
            firstReadLogFile.errorchecking(logfilepath);
        }

        else {
            String previoustimestamp = new ReadLastLine().readinglastline();
            List<LogVariables> newlogslist = new ArrayList<LogVariables>();
            newlogslist = moreReadLogFile.getcurrentlogstates(logfilepath, previoustimestamp);
            if(newlogslist.isEmpty()){
                return ;
            }
            moreReadLogFile.errorchecking(newlogslist);
        }

    }
}