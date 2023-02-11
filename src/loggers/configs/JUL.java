package loggers.configs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class JUL {

    public static loggers.typesINFO.JUL JULinfoFile=new loggers.typesINFO.JUL();

    public static Logger init(Class classSet, String pathToFile, Level minimumLevelToCatch) throws Exception {
        Logger LOGGER = Logger.getLogger(classSet.getName());


        Handler fileHandler  = new FileHandler(pathToFile);
        LOGGER.addHandler(fileHandler);
        fileHandler.setLevel(minimumLevelToCatch);
        fileHandler.setFormatter(new SimpleFormatter());



        return LOGGER;
    }

    public static Logger initByProperties(String pathToLogProperties) throws Exception {
        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(new FileInputStream(pathToLogProperties));

        return null;
    }



        public static void addFilter(Logger logger,String wordNotShow){
        logger.setFilter(new FilterExample(wordNotShow));
    }

    public static class FilterExample implements Filter{

        String NotShowContainsString=null;

        FilterExample(String NotShowContainsString){

        }

        // будет публиковаться или нет
        @Override
        public boolean isLoggable(LogRecord record) {
            if(record == null)
                return false;

            String message = record.getMessage()==null?"":record.getMessage();


            if (NotShowContainsString==null)return true;
            if(message.contains(NotShowContainsString))return false;

            return true;
        }
    }

}
