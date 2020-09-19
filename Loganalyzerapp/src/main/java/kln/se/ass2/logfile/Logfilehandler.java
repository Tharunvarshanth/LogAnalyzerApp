package kln.se.ass2.logfile;

import kln.se.ass2.logvariable.LogVariables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Logfilehandler {


    public  List<LogVariables> readlogfile(String logfilepath) {

        List<LogVariables> loglist = new ArrayList<LogVariables>();
        LogVariables logvariables;

        try {
            FileReader fr = new FileReader(logfilepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String previousline = "";

            while ((line = br.readLine()) != null) {
                String[] strings= line.split(" ");
                loglist.add(new LogVariables(strings[0],strings[1],strings[2]));

                previousline = line;
            }

        } catch (IOException ioException) {
            System.out.println(ioException);
        }

        return loglist;
    }


}
