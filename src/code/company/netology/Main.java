package code.company.netology;

import code.company.netology.GameProgress;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class Main {
    // Saving Files
    public static void saveGame(String path, GameProgress game) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Packing  ZIP
    private static void packingZip(String filePath, List<String> lpaths) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(filePath))) {
            int count = 1;
            for (String path : lpaths) {
                FileInputStream fis = new FileInputStream(path);
                ZipEntry entry = new ZipEntry("savedGame" + count++ + ".dat");
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
                fis.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Delete Files
    private static void deleteFiles() {
        File file = new File("C:/JAVA/Projects/Serialization/Games/savegames");
        if (file.isDirectory()) {
            for (File files : file.listFiles()) {
                if (!files.getName().contains(".zip")) {
                    files.delete();
                }
            }
        }
    }

    // Unpacking ZIP
    private static void unPackingZip(String filePath1, String filePath2) {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(filePath1))) {

            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
              //  System.out.printf("file name:  %s \n", name);

                FileOutputStream fout = new FileOutputStream(filePath2 + "\\" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Read Fies (Deserialization)

    private static GameProgress openProgress(String pathGame) throws ClassNotFoundException {
        //Task 1. Создание каталогов, фалов. Сохранение файлов.
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream(pathGame);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return gameProgress;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder();

        //Создание подкаталога SRC
        File dirSrc = new File("C:/JAVA/Projects/Serialization/Games/src");

        if (dirSrc.mkdir()) {
            sb.append("Директория ")
                    .append(dirSrc.getName() + " ")
                    .append("создана")
                    .append("\r\n");
        } else {
            sb.append("не удалось создать директорию " + dirSrc.getName())
                    .append("\r\n");
        }

        //Создание подкаталога MAIN

        File dirMain = new File("C:/JAVA/Projects/Serialization/Games/src/main");

        if (dirMain.mkdir()) {
            sb.append("Директория ")
                    .append(dirMain.getName() + " ")
                    .append("создана")
                    .append("\r\n");
        } else {
            sb.append("не удалось создать директорию " + dirMain.getName())
                    .append("\r\n");
        }
        //Создание подкаталога TEST

        File dirTest = new File("C:/JAVA/Projects/Serialization/Games/src/test");

        if (dirTest.mkdir()) {
            sb.append("Директория ")
                    .append(dirTest.getName() + " ")
                    .append("создана")
                    .append("\r\n");
        } else {
            sb.append("не удалось создать директорию " + dirTest.getName())
                    .append("\r\n");
        }
        //Создание подкаталога RES

        File dirRes = new File("C:/JAVA/Projects/Serialization/Games/res");

        if (dirRes.mkdir()) {
            sb.append("Директория ")
                    .append(dirRes.getName() + " ")
                    .append("создана")
                    .append("\r\n");
        } else {
            sb.append("не удалось создать директорию " + dirRes.getName())
                    .append("\r\n");
        }

        //Создание подкаталогa RES/drawables

        File dirDrawables = new File("C:/JAVA/Projects/Serialization/Games/res/drawables");

        if (dirDrawables.mkdir()) {
            sb.append("Директория ")
                    .append(dirDrawables.getName() + " ")
                    .append("создана")
                    .append("\r\n");
            sb.append("не удалось создать директорию " + dirDrawables.getName())
                    .append("\r\n");
        }

        //Создание подкаталогa RES/vectors

        File dirVectors = new File("C:/JAVA/Projects/Serialization/Games/res/vectors");

        if (dirVectors.mkdir()) {
            sb.append("Директория ")
                    .append(dirVectors.getName() + " ")
                    .append("создана")
                    .append("\r\n");
        } else {
            sb.append("не удалось создать директорию " + dirVectors.getName())
                    .append("\r\n");
            //  System.out.println("не удалось создать директорию " + dirVectors.getName());
        }
        //Создание подкаталогa RES/icons

        File dirIcons = new File("C:/JAVA/Projects/Serialization/Games/res/icons");

        if (dirIcons.mkdir()) {
            sb.append("Директория ")
                    .append(dirIcons.getName() + " ")
                    .append("создана")
                    .append("\r\n");
        } else {
            sb.append("не удалось создать директорию " + dirIcons.getName())
                    .append("\r\n");
        }

        //Создание подкаталога SAVEGAMES

        File dirSaveGames = new File("C:/JAVA/Projects/Serialization/Games/savegames");

        if (dirSaveGames.mkdir()) {
            sb.append("Директория ")
                    .append(dirSaveGames.getName() + " ")
                    .append("создана")
                    .append("\r\n");
        } else {
            sb.append("не удалось создать директорию " + dirSaveGames.getName())
                    .append("\r\n");
        }
        //Создание подкаталога TEMP

        File dirTemp = new File("C:/JAVA/Projects/Serialization/Games/temp");

        if (dirTemp.mkdir()) {
            sb.append("Директория ")
                    .append(dirTemp.getName() + " ")
                    .append("создана")
                    .append("\r\n");
        } else {
            sb.append("не удалось создать директорию " + dirTemp.getName())
                    .append("\r\n");
        }

        //Создание файла TEMP.txt
        File fileTemp = new File("C:/JAVA/Projects/Serialization/Games/temp", "temp.txt");

        try {
            if (fileTemp.createNewFile()) {
                sb.append("Файл ")
                        .append(fileTemp.getName() + " ")
                        .append(" был создан")
                        .append("\r\n");
            } else {
                sb.append("не удалось создать файл ")
                        .append(fileTemp.getName())
                        .append("\r\n");
            }
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
            if (fileMain.createNewFile()) {
                sb.append("Файл ")
                        .append(fileMain.getName() + " ")
                        .append(" был создан")
                        .append("\r\n");
            } else {
                sb.append("не удалось создать файл ")
                        .append(fileMain.getName())
                        .append("\r\n");
            }
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
            if (fileUtils.createNewFile()) {
                sb.append("Файл ")
                        .append(fileUtils.getName() + " ")
                        .append(" был создан")
                        .append("\r\n");
            } else {
                sb.append("не удалось создать файл ")
                        .append(fileUtils.getName())
                        .append("\r\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter fileWriter = new FileWriter("C:/JAVA/Projects/Serialization/Games/temp/temp.txt")) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //Task 2.  Cохранение, удаление файлов и упаковка в ZIP
        GameProgress game1 = new GameProgress(50, 20, 10, 45);
        GameProgress game2 = new GameProgress(40, 30, 5, 100);
        GameProgress game3 = new GameProgress(90, 5, 1, 150);
        saveGame("C:/JAVA/Projects/Serialization/Games/savegames/game1.dat", game1);
        saveGame("C:/JAVA/Projects/Serialization/Games/savegames/game2.dat", game2);
        saveGame("C:/JAVA/Projects/Serialization/Games/savegames/game3.dat", game3);
        List<String> paths = new ArrayList<>();
        paths.add("C:/JAVA/Projects/Serialization/Games/savegames/game1.dat");
        paths.add("C:/JAVA/Projects/Serialization/Games/savegames/game2.dat");
        paths.add("C:/JAVA/Projects/Serialization/Games/savegames/game3.dat");
        packingZip("C:/JAVA/Projects/Serialization/Games/savegames/save.zip", paths);
        deleteFiles();


        //TASK 3. Распаковка ZIP, десериализация.
        unPackingZip("C:/JAVA/Projects/Serialization/Games/savegames/save.zip", "C:/JAVA/Projects/Serialization/Games/savegames/");
        System.out.println(openProgress("C:/JAVA/Projects/Serialization/Games/savegames/savedGame1.dat"));
    }
}
