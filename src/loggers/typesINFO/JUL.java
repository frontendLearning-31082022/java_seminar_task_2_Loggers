package loggers.typesINFO;

import loggers.StructureLogging;

import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.logging.*;

public class JUL implements StructureLogging {

     Logger log;

     public void init(){
        log = Logger.getLogger(JUL.class.getName());
    }

     public void MessageArgsTypes(){
        String[] stringMessage={"message","message args {0}"};
        Throwable Exception = new Throwable();
        //ресурсы для страны
        ResourceBundle resourceBundle = ResourceBundle.getBundle("logging.jul.bundle");
        //lambda java8 - отложенное выполнение метода, есть .get()
        Supplier<String> stringMessageSupplier = ()->"Сообщение";
    }

     public void  LoggingMethods(){
        log.info("");
        log.log(null);
        log.logp(Level.INFO, "ClassName", "MethodName", "msg");
        log.logrb(Level.INFO,null,"msg");
        log.throwing("ClassName","MethodName",new Throwable());

    }

    public void FormattingLogger(){
//        XML или HTML
    }


     public void OutputChannels() throws Exception {
        new FileHandler();
        new ConsoleHandler();
        new StreamHandler();
        new SocketHandler();
        new MemoryHandler(); // в RAM

    }

     public void config(){
        //handler для всего класса , а не для объекта

//        - Первый вариант в коде main
//        LogManager.getLogManager().readConfiguration(<ваш класс>.class.getResourceAsStream("logging.properties"));
//         logging.properties кладется в /src/


//        handlers =java.util.logging. FileHandler
//        # Конфигурация файлового хендлера
//        java.util.logging.FileHandler.level =ALL
//         java.util.logging.FileHandler.count              // колво выходных файлов
//        java.util.logging.FileHandler.formatter =java.util.logging.SimpleFormatter        //можно XML
//        java.util.logging.FileHandler.limit = 1000000             //макс размер файла лога
//        java.util.logging.FileHandler.pattern   = log.txt      // путь файла лога

    }

     public void LevelsLogging(){
        log.log(Level.INFO,"");
        log.log(Level.WARNING,""); // предупрежденик
        log.log(Level.CONFIG,"");
        log.log(Level.FINEST,"");
        log.log(Level.FINER,"");
        log.log(Level.FINE,"");
        log.log(Level.SEVERE,""); // ошибка
        log.log(Level.ALL,""); // регистр все
        log.log(Level.OFF,""); // все отключить
    }


}
