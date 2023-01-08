package com.brigelabz;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInfo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("F:/Bridelabz/myFile/xyz.txt");
        int i = fr.read();
        while(i != -1){
            System.out.print((char)i);
            i = fr.read();
        }

    }
}
