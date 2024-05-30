package code.company.netology;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static String rezultString = "";

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

    //Log for Directoryes
    public static void createDirectory(String nameDirectory) {

        StringBuilder sb = new StringBuilder();
        File dir = new File(nameDirectory);
        if (dir.mkdir()) {
            sb.append("Директория " + dir.getName() + " создана" + "\r\n");
            rezultString += sb.toString();

        } else {
            sb.append("Невозможно создать директорию " + dir.getName() + "\r\n");
            rezultString += sb.toString();
        }
    }

    //log for Files
    public static void createFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();

        File file = new File(fileName);
        try {
            if (file.createNewFile()) {

                sb.append("Файл ")
                        .append(file.getName() + " ")
                        .append(" был создан")
                        .append("\r\n");
                rezultString += sb.toString();
            } else {
                sb.append("не удалось создать файл ")
                        .append(file.getName())
                        .append("\r\n");
                rezultString += sb.toString();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, IOException {

        StringBuilder sb = new StringBuilder();

        createDirectory("C:/JAVA/Projects/Serialization/Games/src");
        createDirectory("C:/JAVA/Projects/Serialization/Games/src/main");
        createDirectory("C:/JAVA/Projects/Serialization/Games/src/test");
        createDirectory("C:/JAVA/Projects/Serialization/Games/res");
        createDirectory("C:/JAVA/Projects/Serialization/Games/res/drawables");
        createDirectory("C:/JAVA/Projects/Serialization/Games/res/vectors");
        createDirectory("C:/JAVA/Projects/Serialization/Games/savegames");
        createDirectory("C:/JAVA/Projects/Serialization/Games/temp");

        createFile("C://JAVA//Projects//Serialization//Games/temp//temp.txt");
        createFile("C:/JAVA//Projects//Serialization//Games//src//main//Main.java");
        createFile("C://JAVA//Projects//Serialization//Games//src//main//Utils.java");

        // Record Strings for Temp.txt
        try (FileWriter log = new FileWriter("C:/JAVA/Projects/Serialization/Games/temp/temp.txt", false)) {
            log.write(rezultString);
            log.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            sb.append((e.getMessage()) + '\n');
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
