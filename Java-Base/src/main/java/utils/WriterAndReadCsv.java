package utils;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class WriterAndReadCsv {

    public static void main(String[] args) throws IOException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
        String csvPath = GetPath.getFilePath() + "\\files\\demo.csv";
        writeCsvFile(csvPath);
        readCsvFile(csvPath);
    }


    /**
     * 生成csv文件
     */
    public static void writeCsvFile(String filePath) throws IOException {
        //创建CSV Writer对象, 参数说明（写入的文件路径，分隔符，编码格式)
        CsvWriter csvWriter = new CsvWriter(filePath,',', StandardCharsets.UTF_8);

        try {
            //定义表头字段
            String[] headers = {"列一", "列二", "列三"};
            //写入表头字段
            csvWriter.writeRecord(headers);
            //写入行
            for (int i = 1; i <= 5; i++) {
                String col1 = String.valueOf(i);
                String col2 = "第二列" + i;
                String col3 = new SimpleDateFormat("yyyyMMddHHmmss" ).format(new Date()) + new DecimalFormat("000").format(i);

                csvWriter.writeRecord((String[]) Arrays.asList(col1, col2, col3).toArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            csvWriter.close();
        }
    }


    /**
     * 读取csv文件
     */
    public static void readCsvFile(String filePath) {
        // 缓存读取的数据
        List<String[]> content = new ArrayList<>();

        try {
            //创建CSV Reader对象, 参数说明（读取的文件路径，分隔符，编码格式)
            CsvReader csvReader = new CsvReader(filePath, ',', StandardCharsets.UTF_8);
            //跳过表头
            csvReader.readHeaders();
            //读取除表头外的内容
            while (csvReader.readRecord()) {
                //读取一整行
                String line = csvReader.getRawRecord();
                System.out.println("读取整行：" + line);
                content.add(csvReader.getValues());
            }
            csvReader.close();
            System.out.printf("\n");

            for (int row = 0; row < content.size(); row++) {
                for (int i = 0; i < 3; i++) {
                    System.out.println(content.get(row)[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}