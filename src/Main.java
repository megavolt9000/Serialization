import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        /*
       ** создаем объект File в качестве каталога
        File dir1 = new File("C:/JAVA//Projects//Serialization//Games");
       ** создаем объект File для файла, находящегося в каталоге
        File file1 = new File("C://SomeDir", "Hello.txt");
       ** создаем объект File для файла, находящегося в каталоге dir1
        File dir1=new File();
        File file2 = new File("C://JAVA//Projects//Serialization//Games", "Hello2.txt");
      */


        //Создание подкаталога SRC

        File dirSrc = new File("C:/JAVA/Projects/Serialization/Games/src");

        if (dirSrc.mkdir()) {
            sb.append("Директория ")
                    .append(dirSrc.getName() + " ")
                    .append("создана")
                    .append("\r\n");
            System.out.println("Директория " + dirSrc.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirSrc.getName())
            .append("\r\n");
            System.out.println("Не удалось создать директорию. " + dirSrc.getName());
        }

        //Создание подкаталога MAIN

        File dirMain = new File("C:/JAVA/Projects/Serialization/Games/src/main");

        if (dirMain.mkdir()) {
            sb.append("Директория ")
                    .append(dirMain.getName() + " ")
                    .append("создана")
                    .append("\r\n");


            System.out.println("Директория " + dirMain.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirMain.getName())
                    .append("\r\n");
            System.out.println("не удалось создать директорию " + dirMain.getName());
        }
        //Создание подкаталога TEST

        File dirTest = new File("C:/JAVA/Projects/Serialization/Games/src/test");

        if (dirTest.mkdir()) {
            sb.append("Директория ")
                    .append(dirTest.getName() + " ")
                    .append("создана")
                    .append("\r\n");


            System.out.println("Директория " + dirTest.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirTest.getName())
                    .append("\r\n");
            System.out.println("не удалось создать директорию " + dirTest.getName());
        }
        //Создание подкаталога RES

        File dirRes = new File("C:/JAVA/Projects/Serialization/Games/res");

        if (dirRes.mkdir()) {
            sb.append("Директория ")
                    .append(dirRes.getName() + " ")
                    .append("создана")
                    .append("\r\n");


            System.out.println("Директория " + dirRes.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirRes.getName())
                    .append("\r\n");
            System.out.println("не удалось создать директорию " + dirRes.getName());
        }

        //Создание подкаталогa RES/drawables

        File dirDrawables = new File("C:/JAVA/Projects/Serialization/Games/res/drawables");

        if (dirDrawables.mkdir()) {
            sb.append("Директория ")
                    .append(dirDrawables.getName() + " ")
                    .append("создана")
                    .append("\r\n");


            System.out.println("Директория " + dirDrawables.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirDrawables.getName())
                    .append("\r\n");
            System.out.println("не удалось создать директорию " + dirDrawables.getName());
        }

        //Создание подкаталогa RES/vectors

        File dirVectors = new File("C:/JAVA/Projects/Serialization/Games/res/vectors");

        if (dirVectors.mkdir()) {
            sb.append("Директория ")
                    .append(dirVectors.getName() + " ")
                    .append("создана")
                    .append("\r\n");


            System.out.println("Директория " + dirVectors.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirVectors.getName())
                    .append("\r\n");
            System.out.println("не удалось создать директорию " + dirVectors.getName());
        }
        //Создание подкаталогa RES/icons

        File dirIcons = new File("C:/JAVA/Projects/Serialization/Games/res/icons");

        if (dirIcons.mkdir()) {
            sb.append("Директория ")
                    .append(dirIcons.getName() + " ")
                    .append("создана")
                    .append("\r\n");


            System.out.println("Директория " + dirIcons.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirIcons.getName())
                    .append("\r\n");
            System.out.println("не удалось создать директорию " + dirIcons.getName());
        }

        //Создание подкаталога SAVEGAMES

        File dirSaveGames = new File("C:/JAVA/Projects/Serialization/Games/savegames");

        if (dirSaveGames.mkdir()) {
            sb.append("Директория ")
                    .append(dirSaveGames.getName() + " ")
                    .append("создана")
                    .append("\r\n");


            System.out.println("Директория " + dirSaveGames.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirSaveGames.getName())
                    .append("\r\n");
            System.out.println("не удалось создать директорию " + dirSaveGames.getName());
        }
        //Создание подкаталога TEMP

        File dirTemp = new File("C:/JAVA/Projects/Serialization/Games/temp");

        if (dirTemp.mkdir()) {
            sb.append("Директория ")
                    .append(dirTemp.getName() + " ")
                    .append("создана")
                    .append("\r\n");


            System.out.println("Директория " + dirTemp.getName() + " создана");
        } else {
            sb.append("не удалось создать директорию " + dirTemp.getName())
                    .append("\r\n");
            System.out.println("не удалось создать директорию " + dirTemp.getName());
        }

        //Создание файла TEMP.txt
        File fileTemp = new File("C:/JAVA/Projects/Serialization/Games/temp", "temp.txt");

        try {
            if (fileTemp.createNewFile())
                sb.append("Файл ")
                        .append(fileTemp.getName() + " ")
                        .append(" был создан")
                        .append("\r\n");
            System.out.println("Файл " + fileTemp.getName() + " был создан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter("C:/JAVA/Projects/Serialization/Games/temp/temp.txt")) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //Создание файла MAIN.java
        File fileMain = new File("C:/JAVA/Projects/Serialization/Games/src/main", "Main.java");

        try {
            if (fileMain.createNewFile())
                sb.append("Файл ")
                        .append(fileMain.getName() + " ")
                        .append(" был создан")
                        .append("\r\n");
            System.out.println("Файл " + fileMain.getName() + " был создан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter("C:/JAVA/Projects/Serialization/Games/temp/temp.txt")) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Создание файла Utils.java
        File fileUtils = new File("C:/JAVA/Projects/Serialization/Games/src/main/", "Utils.java");

        try {
            if (fileUtils.createNewFile())
                sb.append("Файл ")
                        .append(fileUtils.getName() + " ")
                        .append(" был создан")
                        .append("\r\n");
            System.out.println("Файл " + fileUtils.getName() + " был создан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter("C:/JAVA/Projects/Serialization/Games/temp/temp.txt")) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//запись в файл temp.txt

        if (fileTemp.canWrite()) {
            System.out.println("Файл " + fileTemp.getName() + " записан");
        }else {
            System.out.println("Файл " + fileTemp.getName() + " не записан");
        }


        if (fileMain.canWrite()) {
            System.out.println("Файл " + fileMain.getName() + " записан");
        }else {
            System.out.println("Файл " + fileMain.getName() + " не записан");
        }


        if (fileTemp.canWrite()) {
            System.out.println("Файл " + fileUtils.getName() + " записан");
        }else {
            System.out.println("Файл " + fileUtils.getName() + " не записан");
        }
    }
}
