package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    private int menuNum = 0;
    private int secondmenuNum = 0;
    private String tempString;
    private List<String> tempList = new ArrayList<>();


    private int userChoose(){
        int chooseInt = 0;
        {
        try {
            chooseInt = sc.nextInt();
        } catch(Exception e){
            System.out.println("Неверный тип");
        }}while(chooseInt<=0);

        return chooseInt;
    }

    private String getName(){
        String tmp = sc2.nextLine();
        return tmp;
    }


    public void Menu(){
        System.out.println("Добро пожаловать!\n Пожалуйста выберете необходимую операцию.");

            chooseBetweenStringAndFileOPerations();

    }

    private void chooseBetweenStringAndFileOPerations(){
        System.out.println("Для выбора работы со строками нажмите - 1;");
        System.out.println("Для выбора работы со файлами нажмите - 2");
        menuNum = userChoose();
        if(menuNum == 1) {
            StringTask stringTask;

            System.out.println("Для иницилизации строки, введите - 1;");

            int menuNumtemp = userChoose();

            if (menuNumtemp == 1) {
                System.out.println("Введите строку: ");
                tempString = getName();
                stringTask = new StringTask(tempString);
            } else
                stringTask = new StringTask();

            do{
                chooseFromStringOPeration(stringTask);
                System.out.println("Для выхода введите - 1");
                menuNumtemp = userChoose();
            }while(menuNumtemp != 1);
        }
        else if(menuNum == 2) {
            FileTask fileTask = new FileTask();
            int menuNumtemp = 0;
            do{
            chooseFromFileOPeration(fileTask);
            System.out.println("Для выхода введите - 1");
            menuNumtemp = userChoose();
            }while(menuNumtemp != 1);

        }
        else
            System.out.println("Введено неверное число");

    }


    private void chooseFromStringOPeration(StringTask stringTask){
        System.out.println("Выбор операции со строками:");
        System.out.println("(1 - просмотр строки; 2 - Изменить строку; 3 - Реверс строки; 4 - Убрать пробелы в начале и в конце;");
        System.out.println("5 - Убрать все пробелы; 6 - Все буквы в строке Заглавные; 7 - Получить часть строки");

        secondmenuNum = userChoose();

        switch (secondmenuNum){
            case 1:
                System.out.println(stringTask);
                break;
            case 2:
                System.out.println("Введите новую строку: ");
                tempString = getName();
                stringTask.setStr(tempString);
                break;
            case 4:
                System.out.println(stringTask.trimStringByStringMethod());
                break;
            case 5:
                System.out.println(stringTask.trimStringByCharArr());
                break;
            case 6:
                System.out.println(stringTask.toUpperCaseString());
                break;
            case 3:
                System.out.println(stringTask.reverseByCharArray());
                break;
            case 7:
                int start, end;

                System.out.println("Введите начальный индекс");
                start = userChoose();

                System.out.println("Введите конечный индекс");
                end = userChoose();
                System.out.println(stringTask.sub(start, end));
                break;
            default:
                System.out.println("Введено неверное число");
                break;
        }
    }

    private void chooseFromFileOPeration(FileTask fileTask){
        System.out.println("Выбор операции с файлами:");
        System.out.println("(1 - Создание директории поумолчанию; 2 - Создание директории с собственным именем; 3 - Создание файла поумолчанию; 4 - Создание файла с собственным именем;");
        System.out.println("5 - Чтение последнего файла; 6 - Чтение в папке с именем файла с именем; 7 - Переписать в последний файл строку; 8 - Переписать в последний файл строки;");
        System.out.println("9 - Переписать в файл с именем строку; 10 - Переписать в файл с именем строки; 11 - Дописать в последний файла строку; 12 - Дописать в последний файл строки;");
        System.out.println("13 - Удалить последнию директорию; 14 - Удалить директорию с именем;");
        System.out.println("15 - Удалить все только что созданные директории (удаляются только те папки в которых нет файлов); 16 - Удалить последний созданный файл;");
        System.out.println("17 - Удалить файл с именем; 18 - Удалить все только что созданные файлы.)");

        secondmenuNum = userChoose();

        switch (secondmenuNum){
            case 1:
                fileTask.createDirectory();
                break;
            case 2:
                System.out.println("Введите название директории: ");
                tempString = getName();
                fileTask.createDirectory(tempString);
                break;
            case 3:
                fileTask.createFile();
                break;
            case 4:
                System.out.println("Введите название файла: ");
                tempString = getName();
                fileTask.createFile(tempString);
                break;
            case 5:
                System.out.println(fileTask.readFromLastFile());
                break;
            case 6:
                System.out.println("Введите название директории: ");
                String dirName = getName();
                System.out.println("Введите название файла: ");
                String fileName = getName();
                fileTask.readFromFile(dirName, fileName);
                break;
            case 7:
                System.out.println("Введите строку для записи");
                 tempString = getName();

                 fileTask.writeToFile(tempString);
                break;
            case 8:
                System.out.println("Введите строки для записи (для выхода введите в новой строке - exit)");
                while (true){
                    tempString = getName();
                    if(tempString.equals("exit"))
                        break;
                    tempList.add(tempString);
                }

                fileTask.writeToFile(tempList);
                tempList.clear();
                break;
            case 9:
                System.out.println("Введите строку для записи");
                tempString = getName();
                System.out.println("Введите название файла для записи");
                String tmpName = getName();

                fileTask.writeToFile(tempString, tmpName);
                break;
            case 10:
                System.out.println("Введите строки для записи (для выхода введите в новой строке - exit)");
                while (true){
                    tempString = getName();
                    if(tempString.equals("exit"))
                        break;
                    tempList.add(tempString);
                }
                System.out.println("Введите название файла для записи");
                String tmpName2 = getName();

                fileTask.writeToFile(tempString, tmpName2);
                tempList.clear();
                break;
            case 11:
                System.out.println("Введите строку для добавления в файл");
                tempString = getName();

                fileTask.addToFile(tempString);
                break;
            case 12:
                System.out.println("Введите строки для добавления в файл (для выхода введите в новой строке - exit)");
                while (true){
                    tempString = getName();
                    if(tempString.equals("exit"))
                        break;
                    tempList.add(tempString);
                }

                fileTask.addToFile(tempList);
                break;
            case 13:
                fileTask.deleteLastDirectory();
                break;
            case 14:
                System.out.println("Введите название директории для удаления");
                tempString = getName();
                fileTask.deleteDirectory(tempString);
                break;
            case 15:
                fileTask.deleteAllDirectories();
                break;
            case 16:
                fileTask.deleteLastFile();
                break;
            case 17:
                System.out.println("Введите название файла для удаления");
                tempString = getName();
                fileTask.deleteFile(tempString);
                break;
            case 18:
                fileTask.deleteAllFiles();
                break;
            default:
                System.out.println("Введено неверное число");
                break;
        }
    }


}
