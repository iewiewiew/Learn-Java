package utils;

import com.csvreader.CsvReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CsvToTxt{

    public static void main(String[] args) throws Exception{
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
        String csvFilePath = GetPath.getFilePath() + "\\files\\demo.csv";
        String txtFilePath = GetPath.getFilePath() + "\\files\\demo.txt";
        readCsvWriteToTxt(csvFilePath, txtFilePath);
    }


    /**
     * csv转换为txt
     * @param csvFilePath
     * @param txtFilePath
     * @throws Exception
     */
    public static void readCsvWriteToTxt(String csvFilePath,String txtFilePath) throws Exception {
        ArrayList<String> csvList = new ArrayList<String>();
        CsvReader csvReader = new CsvReader(csvFilePath, ',', StandardCharsets.UTF_8);

        csvReader.readHeaders(); //跳过表头,不跳可以注释掉
        while (csvReader.readRecord()) {
            String line = csvReader.getRawRecord(); //按行读取
            csvList.add(csvReader.getRawRecord()); //把每一行的数据添加到csvList集合
            System.out.println("读取csv的值：" + line);
        }
        System.out.println("\n" + "读取的行数：" + csvList.size() + "\n");
        csvReader.close();

        File file = new File(txtFilePath);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw =new BufferedWriter(fileWriter);
        for(int i=0; i<csvList.size(); i++){
            bw.write(csvList.get(i).replace(',','|'));
            bw.newLine(); //换行
            System.out.println("写入txt的值：" + csvList.get(i).replace(',','|'));
        }
        bw.close();
    }
}