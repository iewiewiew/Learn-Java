package utils;

import com.csvreader.CsvWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TxtToCsv {
    public static void main(String[] args) throws Exception{
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String txtFilePath = GetPath.getFilePath() + "\\files\\demo.txt";
        String csvFilePath = GetPath.getFilePath() + "\\files\\demo.csv";
        txtToCsv(txtFilePath, csvFilePath);
    }


    public static void txtToCsv(String txtFilePath,String csvFilePath) {
        File file = new File(txtFilePath);

        try {
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', StandardCharsets.UTF_8);

            String[] line = {"列1", "列2", "列3"};
            csvWriter.writeRecord(line);
            for (int i = 0; i < line.length; i++) {
                System.out.println("写入表头：" + line[i]);
            }
            System.out.println("\n");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                String[] s = string.split("\\|");  // | 需要转义
                csvWriter.writeRecord(s);
                for (int i = 0; i < s.length; i++) {
                    System.out.println("写入表行：" + s[i]);
                }
                System.out.println("\n");
            }
            csvWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}