//Задание 1.
//        Дана строка sql-запроса "select * from students where ".
//        Сформируйте часть WHERE этого запроса, используя StringBuilder.
//        Данные приведены ниже в виде json строки.
//        Если значение null, то параметр не должен попадать в запрос.
//
//        Входная строка:
//        {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//
//        Выходная строка:
//        select * from students where name = "Ivanov" and country = "Russia" and city = "Moscow"

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_1 {


    public static void main(String[] args) {

        String initialRequest = "select * from students where ";

        String inputData = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        StringBuilder initialRequestBuild = reqPrepare(inputData, initialRequest);

        System.out.println(initialRequestBuild);
    }

    private static StringBuilder reqPrepare(String inputData, String initialRequest) {
        StringBuilder initialRequestBuild = new StringBuilder(initialRequest.toUpperCase().trim());


        Pattern pattern = Pattern.compile("(,||\\{)\\s{0,}\"(.*?)\":\"(.*?)\"\\s{0,}(,||\\})",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputData);
        while (matcher.find()) {
            String field = matcher.group(2);
            String value = matcher.group(3);

            //sql use '
            if (!value.equals("null")) initialRequestBuild.append(
                    (initialRequest.trim().length() != initialRequestBuild.length() ? " and " : "")
                            + " " + field + " = '" + value + "'");
        }
        initialRequestBuild.append(";");

        return initialRequestBuild;

    }

}
