package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileTask {
    private Path path = Paths.get("E:\\");
    private Path pathDirectory;
    private List<Path> directoriesName = new ArrayList<Path>();
    private Path pathFile;
    private final String DEFAULT_FILE_NAME = "Temp_File.txt";
    private final String DEFAULT_DIRECTORY_NAME = "tempFolder";
    private List<Path> filesPath = new ArrayList<Path>();

    public FileTask() {

        Path pathForThisProgtramFiles = Paths.get(path + "\\Temp_Program_Directory");
        if(!Files.isDirectory(pathForThisProgtramFiles)) {
            try {
                Files.createDirectory(pathForThisProgtramFiles);
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
        path = pathForThisProgtramFiles;
        pathDirectory = path;
    }

    //++++++         Create Methods            ++++++++++

    public void createDirectory() {

        pathDirectory = Paths.get(path + "\\" + DEFAULT_DIRECTORY_NAME);
        if (Files.isDirectory(pathDirectory))
            System.out.println("Папка уже существует");
        else {
            try {
                Path pathForSaveFile = Files.createDirectory(pathDirectory);
            } catch (IOException ioex) {
                System.out.println("Folder can't be created");
            }
            directoriesName.add(pathDirectory);
        }


    }

    public void createDirectory(String folderName) {

        pathDirectory = Paths.get(path + "\\" + folderName);
        if (Files.isDirectory(pathDirectory))
            System.out.println("Папка уже существует");
        else {
            try {
                Path pathForSaveFile = Files.createDirectory(pathDirectory);
            } catch (IOException ioex) {
                System.out.println("Директория не может быть создана");
            }

            directoriesName.add(pathDirectory);
        }

    }

    public void createFile(){
        if (directoriesName.isEmpty()) {
            System.out.println(directoriesName.isEmpty());
            pathFile = Paths.get(path + "\\" + DEFAULT_FILE_NAME);
        }
        else
            pathFile = Paths.get(pathDirectory + "\\" + DEFAULT_FILE_NAME);
        if (Files.isRegularFile(pathFile))
            System.out.println("Данный файл уже существует");
        else {
            try {
                Files.createFile(pathFile);
            } catch (IOException e) {
                System.out.println("Файл не может быть создан");
            }

            filesPath.add(pathFile);
        }
    }

    public void createFile(String fileName){
        String tempNameOfFile = fileName + ".txt";
        if (directoriesName.isEmpty())
            pathFile = Paths.get(path + "\\" + tempNameOfFile);
        else
            pathFile = Paths.get(pathDirectory + "\\" + tempNameOfFile);
        if (Files.isRegularFile(pathFile))
            System.out.println("Данный файл уже существует");
        else {
            try {
                Files.createFile(pathFile);
            } catch (IOException e) {
                System.out.println("Файл не может быть создан");
            }
            filesPath.add(pathFile);
        }
    }

    //++++++++  Read File +++++++++++++++++++++++

    public List<String> readFromLastFile(){
        List<String> text = new ArrayList<>();
        try {
            text = Files.readAllLines(pathFile);
        } catch (Exception e) {
            System.out.println("Файл не найден");
        }

        return text;
    }

    public List<String> readFromFile(String directoryName, String fileName){
        Path pathtoFile = Paths.get(path + "\\" + directoryName + "\\" + fileName + ".txt");
        List<String> text = new ArrayList<>();
        if(directoriesName.contains(directoryName)){
            if(Files.isReadable(pathtoFile)){
                try {
                    text = Files.readAllLines(pathtoFile);
                } catch (Exception e) {
                    System.out.println("Файл не Может быть прочитан");
                }

            }
            else
                System.out.println("Файл не Может быть прочитан");
        }
        else
            System.out.println("Директория не найдена");

        return text;
    }

    //+++++    File Redactor Methods    +++++++++++++++++

    // Rewrite

    public void writeToFile(String textForWrite){
        List<String> textWrite = new ArrayList<String>();
        textWrite.add(textForWrite);
        Path tempPath;
        if(filesPath.isEmpty())
            tempPath = Paths.get(pathDirectory + "\\" + DEFAULT_FILE_NAME);
        else
            tempPath = filesPath.get(filesPath.size() - 1);

        if(!Files.isRegularFile(tempPath))
        {
            createFile();
        }

        try {
            Files.write(tempPath, textWrite);
        }catch (IOException e) {
                System.out.println("Файл не может быть записан");
        }

    }

    public void writeToFile(String textForWrite, String fileName){
        Path tempPath = Paths.get(pathDirectory + "\\" + fileName + ".txt");
        List<String> textWrite = new ArrayList<String>();
        textWrite.add(textForWrite);

        if(!Files.isRegularFile(tempPath))
        {
            createFile();
        }


            try {
                Files.write(tempPath, textWrite);
            } catch (IOException e) {
                System.out.println("Файл не может быть записан");
            }

    }

    public void writeToFile(List<String> textWrite){
        Path tempPath;

        if(filesPath.isEmpty())
            tempPath = Paths.get(pathDirectory + "\\" + DEFAULT_FILE_NAME);
        else
            tempPath = filesPath.get(filesPath.size() - 1);
        if(!Files.isRegularFile(tempPath))
        {
            createFile();
        }

        if(Files.isWritable(tempPath)){
            try {
                Files.write(tempPath, textWrite);
            } catch (IOException e) {
                System.out.println("Файл не может быть записан");
            }
        }
        else
            System.out.println("Файл не может быть записан");
    }

    public void writeToFile(List<String> textWrite, String fileName){

        Path tempPath = Paths.get(pathDirectory + "\\" + fileName + ".txt");
        if(!Files.isRegularFile(tempPath))
        {
            createFile(fileName);
        }

        if(Files.isWritable(tempPath)){
            try {
                Files.write(tempPath, textWrite);

            } catch (IOException e) {
                System.out.println("Файл не может быть записан");
            }
        }
        else
            System.out.println("Файл не может быть записан");
    }

    //add to file

    public void addToFile(String textForWrite){
        List<String> textWrite = new ArrayList<String>();
        textWrite.add(textForWrite);
        Path tempPath = Paths.get(pathDirectory + "\\" + DEFAULT_FILE_NAME);
        if(!Files.isRegularFile(tempPath))
        {
            createFile();
        }

        if(Files.isWritable(tempPath)){
            try {
                Files.write(tempPath, textWrite, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Файл не может быть записан");
            }
        }
        else
            System.out.println("Файл не может быть записан");
    }

    public void addToFile(String textForWrite, String fileName){
        Path tempPath = Paths.get(pathDirectory + "\\" + fileName + ".txt");
        List<String> textWrite = new ArrayList<String>();
        textWrite.add(textForWrite);

        if(!Files.isRegularFile(tempPath))
        {
            createFile();
        }

        if(Files.isWritable(tempPath)){
            try {
                Files.write(tempPath, textWrite, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Файл не может быть записан");
            }
        }
        else
            System.out.println("Файл не может быть записан");
    }

    public void addToFile(List<String> textWrite){

        Path tempPath = Paths.get(pathDirectory + "\\" + DEFAULT_FILE_NAME);
        if(!Files.isRegularFile(tempPath))
        {
            createFile();
        }

        if(Files.isWritable(tempPath)){
            try {
                Files.write(tempPath, textWrite, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Файл не может быть записан");
            }
        }
        else
            System.out.println("Файл не может быть записан");
    }

    public void addToFile(List<String> textWrite, String fileName){

        Path tempPath = Paths.get(pathDirectory + "\\" + fileName + ".txt");
        if(!Files.isRegularFile(tempPath))
        {
            createFile(fileName);
        }

        if(Files.isWritable(tempPath)){
            try {
                Files.write(tempPath, textWrite, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Файл не может быть записан");
            }
        }
        else
            System.out.println("Файл не может быть записан");
    }

    //++++++         Delete Methods            ++++++++++

    //Delete last has been created Directory
    public void deleteLastDirectory() {
            try {
                Files.delete(pathDirectory);
            } catch (IOException e) {
                System.out.println("Ваша папка была удалена или перемещена, а может быть и не создавалась");
            }

            directoriesName.remove(pathDirectory);
        System.out.println("Папка удалена");
        }


    //Delete Directory by name
    public void deleteDirectory(String directoryName) {

        Path pathFileTmp = Paths.get(path + "\\" + directoryName);
        try {
            Files.delete(path );
        } catch (IOException e) {
            System.out.println("Ваша папка была удалена или перемещена, а может быть и не создавалась");
        }
        if(directoriesName.contains(pathFileTmp))
            directoriesName.remove(pathFileTmp);

        System.out.println("Папка удалена");
    }

    public void deleteAllDirectories() {
        for(Path nameOfDirectory : directoriesName) {

            try {
                Files.delete(nameOfDirectory);
            } catch (IOException e) {

            }
        }

        directoriesName.clear();
        System.out.println("Все папки удалены");
    }

    public void deleteLastFile(){
        try {
            Files.delete(pathFile);
        } catch (IOException e) {
            System.out.println("Файл был удален или перемещен, а может быть и не создавался");
        }

        filesPath.remove(pathFile);
        System.out.println("Файл удален");
    }

    public void deleteFile(String fileName) {
        String fileNameTxt = fileName + ".txt";

        Path pathFiletmp = Paths.get(path + "\\" + fileNameTxt);
        try {
            Files.delete(pathFiletmp);
        } catch (IOException e) {
            System.out.println("Файл был удален или перемещен, а может быть и не создавался");
        }
        if(filesPath.contains(pathFiletmp))
            filesPath.remove(directoriesName.indexOf(pathFiletmp));
        System.out.println("Файл удален");
    }

    public void deleteAllFiles() {
        for(Path nameOfFile : filesPath) {

            try {
                Files.delete(nameOfFile);
            } catch (IOException e) {

            }
        }

        filesPath.clear();
        System.out.println("Все файлы удалены");
    }
}




