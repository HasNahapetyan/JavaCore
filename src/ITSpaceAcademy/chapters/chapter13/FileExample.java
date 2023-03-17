package ITSpaceAcademy.chapters.chapter13;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FileExample {
    public static void main(String[] args) {
        String path = "src/ITSpaceAcademy/chapters/chapter13/file.txt";
        File file = new File(path);//abstract file ksarke ete chkar
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
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
        String dirpath = "src/ITSpaceAcademy/chapters/chapter13";
        File dir = new File(dirpath);
        String[] list = dir.list();
        for (String l:list) {
            System.out.println(l);
        }
        System.out.println(file.length());

        File[] files = dir.listFiles();
        assert files != null;
        for (File l:files) {
            System.out.println(l.getName() + "   " + l.length());
        }

        String newdirpath = "src/ITSpaceAcademy/chapters/chapter13/newFolder";
        File nedir = new File(newdirpath);
        nedir.mkdirs();
        File[] files1 = nedir.listFiles();
        for (File f:files1) {
            System.out.println(f.getName() + "   " + f.length());
        }

        String newdirspath = "src/ITSpaceAcademy/chapters/chapter13/newFolder/newF1/newF2/NewF3";
        File nedirs = new File(newdirpath);
        nedirs.mkdirs();
        File[] files2 = nedir.listFiles();
        for (File f:files2) {
            System.out.println(f.getName() + "   " + f.length());
        }

        System.out.println(file.getFreeSpace());

        long lastModified = file.lastModified();
        System.out.println(lastModified);
        Date date = new Date(lastModified);
        System.out.println(date);


        System.out.println(File.separator);//JVM-ից կվերցնե

        if(file.exists()) {
            //file.delete();
        }

        //file.deleteOnExit();//կջնջի երբ ծրագիրը պրծնի

        System.out.println("last");
        
    }

}
