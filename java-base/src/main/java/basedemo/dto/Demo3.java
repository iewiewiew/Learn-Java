package basedemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author weimenghua
 * @time 2022-12-03 18:20
 * @description
 */

/**
 * @Entity注解标识了User类是一个持久化的实体
 */
@Entity
@Data
@NoArgsConstructor
public class Demo3 {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    public Demo3(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
