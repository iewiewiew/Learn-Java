package basedemo.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.index.qual.Positive;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * @author weimenghua
 * @time 2022-12-03 17:08
 * @description
 */

/**
 * 使用Lombok的@Data和@NoArgsConstructor注解来自动生成各参数的Set、Get函数以及不带参数的构造函数
 */
@Data
@NoArgsConstructor
public class Demo2 {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String username;

    private String password;

    /**
     * 判断正数
     */
    @Positive
    private int num;

    /**
     * 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
     */
    @DecimalMax("100")
    private int maxValue;

    /**
     * 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
     */
    @DecimalMin("1")
    private int minValue;

    @Email
    private String email;

    @Pattern(regexp = "0-9")
    private String reg;
}
