package basedemo.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import java.util.Date;


/**
 * @author weimenghua
 * @date 2021-11-17 21:55
 */
public class UserInfo {
    @ExcelProperty(value = "序号")
    private int id;

//  @ExcelProperty(value = {"姓名1", "姓名2"}, index = 0) value第一个是标题，第二个是列的字段名称，index是显示的顺序
    @ExcelProperty(value = {"姓名"})
    private String name;

    @ExcelIgnore // 不导出该字段
    @ExcelProperty(value = "年龄")
    private int age;

    @ColumnWidth(20) // 字段宽度
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "操作时间")
    private Date time;

    public UserInfo() {

    }

    public UserInfo(long l) {
    }

    public UserInfo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
