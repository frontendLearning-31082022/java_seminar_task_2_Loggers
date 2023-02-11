//Задание 2 *.
//        Дана json строка (можно сохранить в файл и читать из файла)
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
//        Студент [фамилия] получил [оценка] по предмету [предмет].
//
//        Входная строка:
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//
//        Выходная строка:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.


import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task_2 {

    public static void main(String[] args) {

        for (File file : new File("src/task_2_files/").listFiles()) {
            PupilsDataJson pupilsDataJson = new PupilsDataJson(file.toPath());
            pupilsDataJson.printConsole();
        }

    }


    static class PupilsDataJson {
        Path path;
        String dataFile;

        PupilsDataJson(Path path) {
            this.path = path;
            try {
                load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void printConsole() {
            String[] splitObjects = this.dataFile.split("(?<=\\})((?!\\{).)*(?=\\{)");

            System.out.println(jsonToStringByPattern(splitObjects, List.of(2, 3),
                    "Студент %s получил %s по предмету %s.", "фамилия", "оценка", "предмет"));
        }


        public static StringBuilder jsonToStringByPattern(String[] jsonObjects, List<Integer> group, String patternString,
                                                          String... namesFields) {

            StringBuilder stringBuilder = new StringBuilder();
            for (String jsonObject : jsonObjects) {
                stringBuilder.append(jsonToStringByPattern(jsonObject, group, patternString, namesFields) + "\n");
            }

            return stringBuilder;
        }

        public static String jsonToStringByPattern(String jsonObjectText, List<Integer> group,
                                                   String patternString, String... namesFields) {
            String regex = "(,||\\{)[\\s\\n]*\"(.*?)\"[\\s\\n]*:[\\s\\n]*\"(.*?)\"[\\s\\n]*(,||\\})";

            Pattern pattern = Pattern.compile(regex,
                    Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(jsonObjectText);


            HashMap<String, String> parsed = new HashMap<>();
            while (matcher.find()) {
                parsed.put(matcher.group(group.get(0))
                        , matcher.group(group.get(1)));
            }

            return String.format(patternString,
                    Arrays.stream(namesFields).map(s -> parsed.get(s)).toArray());
        }


        void load() throws Exception {
            File file = new File(this.path.toUri());

            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));

            String output = "";
            String st;
            while (true) {
                if (!((st = br.readLine()) != null)) break;
                output = output + st + System.lineSeparator();
            }
            dataFile = output;
        }


    }


}
