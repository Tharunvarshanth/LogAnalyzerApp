package kln.se.ass2.logfile;

import kln.se.ass2.logvariable.Log;
import kln.se.ass2.logvariable.LogVariables;
import kln.se.ass2.mail.Mail;
import kln.se.ass2.textcontent.TextFile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MoreReadLogFileTest extends Logfilehandler{
    TextFile textfile = mock(TextFile.class);
    Log logvariables ;
    Mail sentmail  = mock(Mail.class);


    @Test
    public void should_fetch_lines_from_readlogfile(){
        MoreReadLogFile moreReadLogFile = new MoreReadLogFile(textfile,logvariables,sentmail);

        moreReadLogFile.getcurrentlogstates("src\\main\\resources\\example.log","2020-09-06T17:24:09Z");

        assertNotNull(super.readlogfile("src\\main\\resources\\example.log"));
    }

    @Test
    public void check_if_n_times_error_fount_it_calls_one_time_only_email_class() {
        MoreReadLogFile moreReadLogFile = new MoreReadLogFile(textfile, logvariables, sentmail);
        List<LogVariables> logVariablesList = new ArrayList<LogVariables>();


        logVariablesList.add(new LogVariables("2020-09-06T17:23:09Z", "INFO", "application started"));
        logVariablesList.add(new LogVariables("2020-09-06T17:23:15Z", "INFO", "application started"));
        logVariablesList.add(new LogVariables("2020-09-06T17:23:20Z", "ERROR", "application started"));
        logVariablesList.add(new LogVariables("2020-09-06T17:24:15Z", "ERROR", "application started"));

       moreReadLogFile.errorchecking(logVariablesList);
       //IF PRINTS ERROR FOUND ONE TIME ONLY THEN NO ERROR
    }
}