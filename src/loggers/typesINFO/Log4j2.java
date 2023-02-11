package loggers.typesINFO;


import loggers.StructureLogging;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.message.MapMessage;


public class Log4j2 implements StructureLogging {
    Logger log;

    @Override
    public void init() {
        log = LogManager.getLogger(Log4j2.class);  // имя класса
        log = LogManager.getLogger("name");  // имя класса
        log = LogManager.getRootLogger();

    }

    @Override
    public void MessageArgsTypes() {
        String[] stringMessage={"message","message args {0}"};
        Throwable Exception = new Throwable();
        Object object = new Object();

        MapMessage mapMessage = new MapMessage(); //msg1="Сообщение 1” msg2="Сообщение 2”
        Marker marker = MarkerManager.getMarker("fileonly"); // маркер по которому фильтровать
    }


    @Override
    public void LoggingMethods() {
        log.info("");
        log.throwing(new Throwable());
        log.log(Level.INFO, "msg");

    }

    @Override
    public void OutputChannels() {
//        AsyncAppender                     асинхронный логгинг
//        ConsoleAppender
//        FailoverAppender                  распределяет между другими аппендерами
//        FileAppender
//        FlumeAppender                     экспорт через Flume агенты   Hadoop — Apache Flume (stream инструмент)
//        JDBCAppender
//        JMSAppender                       через Java Message Service (JMS)
//        JPAAppender                       database через Java Persistence API
//        MemoryMappedFileAppender
//        NoSQLAppender
//        OutputStreamAppender
//        RandomAccessFileAppender
//        RewriteAppender
//        RollingFileAppender
//        RollingRandomAccessFileAppender
//        RoutingAppender                   похож на FailoverApender
//        SMTPAppender
//        SocketAppender
//        SyslogAppender                    на syslog daemon - сетевой протокол
    }

    @Override
    public void config() {
//        log4j.xml или log4j.properties

//        path - project/classes/log4j.properties
//        log4j.rootLogger=DEBUG, stdout, file
//
//        log4j.appender.stdout=org.apache.log4j.ConsoleAppender
//        log4j.appender.stdout.Target=System.out
//        log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
//        log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

//        log4j.appender.file=org.apache.log4j.RollingFileAppender
//        log4j.appender.file.File=C:\log4j-application.log
//        log4j.appender.file.MaxFileSize=5MB
//        log4j.appender.file.MaxBackupIndex=10   //колво бэкапов
//        log4j.appender.file.layout=org.apache.log4j.PatternLayout    // шаблон оформления логов
//        log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n   //формирование структуры

    }

    public void FormattingLogger(){
//        Properties, XML, JSON, YAML

//        path -  src/main/resources/log4j2.xml

//        <Appenders> - STDOUT-пишет в консоль    rollingFile-в файл
//        <TimeBasedTriggeringPolicy interval = "1" />           новый файл кажд день
//        <SizeBasedTriggeringPolicy size="250 MB" />            макс разм файла
//        <Layout type="PatternLayout" pattern="%m %n" />         структура строки

//        <Loggers> <Logger name= "ru.ClassName">               логгер на конкретный класс


    }

    public void Filters(){
//        BurstFilter	            Позволяет управлять частотой сообщений в секунду для заданного уровня логирования.
//        CompositeFilter	        Позволяет задать несколько последовательных фильтров.
//        DynamicThresholdFilter	Позволяет включать детальное логирование, если в логе встретилась определенная информация.
//        MapFilter	                Позволяет построить сложное логическое выражение для фильтра из нескольких параметров.
//        MarkerFilter	            Позволяет фильтровать сообщения по тегам, тег предварительно должен быть добавлен во время логирования события.
//        RegexFilter	            Позволяет задать маску – регулярное выражение.
//        StructuredDataFilter	    Позволяет фильтровать сообщения по наличию в них определенных данных.
//        ThreadContextMapFilter	Позволяет управлять фильтрами на основе данных, взятых из контекста текущего потока.
//        ThresholdFilter	        Управляет логированием на основе уровня сообщения лога.
//        TimeFilter	            Позволяет включать и выключать фильтры в определенное время.
    }

    @Override
    public void LevelsLogging() {
        log.log(Level.TRACE,"");  //мелкие debug данные
        log.log(Level.DEBUG,"");
        log.log(Level.INFO,"");
        log.log(Level.WARN,""); // могут приести к ошибке
        log.log(Level.ERROR,"");
        log.log(Level.FATAL,"");

        log.log(Level.ALL,"");  // все уровни задействуются
        log.log(Level.OFF,"");  // макс ранг, никакие логи иные не пишутся
    }
}
