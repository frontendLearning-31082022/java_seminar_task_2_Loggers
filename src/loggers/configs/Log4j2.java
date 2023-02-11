package loggers.configs;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4j2 {

    public static loggers.typesINFO.Log4j2 info=new loggers.typesINFO.Log4j2();

    public static Logger init_byXML(Class classInput, String s, Level all) {
        Logger logger = LogManager.getLogger(classInput);

        //файл конфига в src/log4j2.xml
        return logger;
    }



}
