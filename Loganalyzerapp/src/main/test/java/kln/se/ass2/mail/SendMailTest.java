package kln.se.ass2.mail;

import kln.se.ass2.mysqlrepostery.Connect;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SendMailTest {


   @Test
    public void should_fetch_mail_addresses_from_Maillist(){

        Connect connect = mock(Connect.class);

        Mail sendMail = mock(Mail.class);



          sendMail.sendmail();

          assertNotNull(connect.getmailaddress());




    }
}