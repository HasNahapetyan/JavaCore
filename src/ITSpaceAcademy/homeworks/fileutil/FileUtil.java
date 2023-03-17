package ITSpaceAcademy.homeworks.fileutil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /*
        src/ITSpaceAcademy/chapters/chapter13
        file.txt
        */
        //fileSearch();


        /*
        src/ITSpaceAcademy/chapters/chapter13
        hello!!!
        */
        //contentSearch();

        /*
        src/ITSpaceAcademy/chapters/chapter13/file.txt
        hello!!!
        */
//        findLines();


/*
        src/ITSpaceAcademy/chapters/chapter13
 */
//        printSizeOfPackage();



        /*
        src/ITSpaceAcademy/chapters/chapter13
        myNewFile.txt
        Hello!HereCouldBeSomeMeaningfulContent

        */
        createFileWithContent();


    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        String path = scanner.nextLine();
        String fileName = scanner.next();
        File file = new File(path + File.separator + fileName);

        System.out.println(file.exists());
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() {
        String path = scanner.nextLine();
        String keyword = scanner.next();
        File fileDir = new File(path);
        FilenameFilter filter = new FilenameFilter() {
            private String ext = ".txt";

            @Override
            public boolean accept(File dir, String name) {
                // This method return the file name along with the file extension
                return (name.endsWith(ext));
            }
        };

        File[] files;
        if(fileDir.isDirectory()){
            files = fileDir.listFiles(filter);
            assert files != null;
            for (File file : files) {
                try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
                    String line = "";
                    while ((line = inputStream.readLine()) != null) {
                        if(line.contains(keyword)){
                            System.out.println(file.getName());
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        String txtPath = scanner.nextLine();
        String keyword = scanner.next();
        File file = new File(txtPath);
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = inputStream.readLine()) != null) {
                if(line.contains(keyword)){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        String path = scanner.nextLine();
        File fileDir = new File(path);


        File[] files;
        if(fileDir.isDirectory()){
            files = fileDir.listFiles();
            assert files != null;
            int totalSize = 0;
            for (File file : files) {
                try {
                    totalSize += Files.size(Paths.get(fileDir + File.separator + file.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(totalSize);
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        String path = scanner.nextLine();
        String fileName = scanner.next();
        String content = scanner.next();
        File file = new File(path + File.separator + fileName);
        if(file.exists()){
            System.out.println("file exists");
        }else{
            try {
                boolean newFile = file.createNewFile();
                if (newFile){
                    System.out.println("file created");
                }else
                {
                    System.out.println("file not created");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + File.separator + fileName));
                /*FileWriter fileWriter = new FileWriter(path + File.separator + fileName)*/) {
            bw.write(content);

//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.print(content);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
