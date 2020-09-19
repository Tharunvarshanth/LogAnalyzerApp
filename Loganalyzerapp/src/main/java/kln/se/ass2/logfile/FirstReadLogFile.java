package kln.se.ass2.logfile;

import kln.se.ass2.mail.Mail;
import kln.se.ass2.logvariable.Log;
import kln.se.ass2.logvariable.LogVariables;
import kln.se.ass2.textcontent.TextFile;
import kln.se.ass2.textcontent.WriteFile;

import java.util.List;
//First Reading AFTER log file created
public class FirstReadLogFile extends Logfilehandler {
   TextFile textfile;
    Log logvariables;
     Mail sentmail;
    public FirstReadLogFile(TextFile textfile, Log logvariables, Mail sentmail) {
      this.textfile=textfile;
      this.logvariables=logvariables;
      this.sentmail=sentmail;
    }

    public void errorchecking(String logfilepath) {

        int errorstate=0;
        List<LogVariables> loglines = super.readlogfile(logfilepath);
        for (LogVariables s : loglines) {
            if ((s.getLoglevel()).contains("ERROR")) {
                if(errorstate==0) {
                    System.out.println("Error Found");
                    errorstate = 1;
                    sentmail.sendmail();
                }
            }
        }

        logvariables = loglines.get(loglines.size() - 1);
        new WriteFile().writetofile(logvariables.getTimestatmp());
    }




    }

