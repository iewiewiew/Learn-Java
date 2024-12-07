package utils;

import basedemo.dto.UserInfo;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.fastjson.JSONArray;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author weimenghua
 * @Date 2022-03-26 8:29
 * @Description EasyExcel导出Excel
 */
public class EasyExcelUtil {
    public static void main(String[] args) throws IOException {
        EasyExcelUtil.writeExcel();
        EasyExcelUtil.readExcel();
    }

    /**
     * 写入Exel
     * @throws IOException
     */
    public static void writeExcel() throws IOException {
        WriteCellStyle writeCellStyle = new WriteCellStyle();
        // 设置标题居中
        writeCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        List<UserInfo> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(i);
            userInfo.setName("张艺兴" + i);
            userInfo.setAge(30);
            userInfo.setTime(new Date(System.currentTimeMillis() + i));
            list.add(userInfo);
        }

        String filePath = GetPath.getFilePath() + "\\files\\demo.xlsx";
        FileOutputStream outputStream = new FileOutputStream(new File(filePath));
        EasyExcel.write(outputStream, UserInfo.class).sheet("用户信息").doWrite(list);
        System.out.printf("写入Excel完毕");
    }


    /**
     * 读取Excel
     * @throws IOException
     */
    public static void readExcel() throws IOException {
        String filePath = GetPath.getFilePath() + "\\files\\demo.xlsx";
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        List<UserInfo> list = EasyExcel.read(fileInputStream).head(UserInfo.class).sheet().doReadSync();
        System.out.printf("读取的Excel内容：" + JSONArray.toJSONString(list));
    }
}
