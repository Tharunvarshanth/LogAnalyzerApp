package kln.se.ass2.logfile;

import kln.se.ass2.logvariable.Log;
import kln.se.ass2.mail.Mail;
import kln.se.ass2.textcontent.TextFile;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FirstReadLogFileTest extends Logfilehandler{
    TextFile textfile = mock(TextFile.class);
    Log logvariables ;
    Mail sentmail  = mock(Mail.class);

    @Test
    public void should_fetch_lines_from_readlogfile_and_check_if_n_times_error_fount_it_calls_one_time_only_email_class(){

        FirstReadLogFile firstReadLogFile = new FirstReadLogFile(textfile,logvariables,sentmail);
        firstReadLogFile.errorchecking("src\\main\\resources\\example.log");

        assertNotNull(super.readlogfile("src\\main\\resources\\example.log"));
    }

}