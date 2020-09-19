package kln.se.ass2.logfile;

import kln.se.ass2.mail.Mail;
import kln.se.ass2.logvariable.Log;
import kln.se.ass2.logvariable.LogVariables;
import kln.se.ass2.textcontent.TextFile;
import kln.se.ass2.textcontent.WriteFile;

import java.util.ArrayList;
import java.util.List;

//After text file created log file manage
public class MoreReadLogFile extends Logfilehandler {
      TextFile textfile;
      Log logvariables;
      Mail sentmail;
    public MoreReadLogFile(TextFile textfile, Log logvariables, Mail sentmail) {
        this.textfile=textfile;
        this.logvariables=logvariables;
        this.sentmail=sentmail;
    }

    public List<LogVariables> getcurrentlogstates(String logfilepath, String pretimestamp){

            List<LogVariables> loglines = super.readlogfile(logfilepath);
            List<LogVariables> templog = new ArrayList<LogVariables>();


            int state = 0;

            for (LogVariables b : loglines) {

                if((b.getTimestatmp()).equals(pretimestamp)) {
                    state=1;

                    continue;
                }
                if(state==1){
                    templog.add(b);
                }

            }//End Loop

            //return statements

         if(!templog.isEmpty()) {
             //Second time reading file
             System.out.println("Second time reading file");
             return templog;
         }
         else{
              //Text already created new path files
             if(!(pretimestamp.equals(loglines.get(loglines.size() - 1).getTimestatmp()))) {
                 System.out.println("Text file already Now checking new path files");
                 return loglines;
             }
             else{
                 //
                 System.out.println("\nThis "+logfilepath+"file is already read or containe faults statements and not contain new states\n");
                 System.out.println("Program Terminated");
                 return templog;
             }
         }

        }


      public void errorchecking(List<LogVariables> newlog) {

          int errorstate=0;
            for (LogVariables s : newlog) {
                if ((s.getLoglevel()).contains("ERROR")) {

                    if(errorstate==0) {
                        errorstate = 1;
                        System.out.println("Error Found");
                        sentmail.sendmail();
                        
                    }
                    //Calling Email Class

                }
            }

             logvariables = newlog.get(newlog.size() - 1);
            new WriteFile().writetofile(logvariables.getTimestatmp());
        }


    }



