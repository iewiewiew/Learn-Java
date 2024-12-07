package basedemo.dto;

import java.io.Serializable;

/**
 * @author weimenghua
 * @time 2022-02-23 18:49
 * @description
 */

// 未实现 Serializable 接口的类在需要对象序列化的上下文中会受到限制，可能导致运行时异常或功能缺失。
public class People implements Serializable {
    private static final long serialVersionUID = 1L; // 可选，但推荐

    private Long id;

    public People(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                '}';
    }
}
