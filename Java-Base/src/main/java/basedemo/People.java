package basedemo;

/**
 * @author weimenghua
 * @time 2022-02-23 18:49
 * @description
 */
public class People {
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
