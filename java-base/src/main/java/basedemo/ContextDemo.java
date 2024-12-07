package basedemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ContextDemo {
    public static void main(String[] args) {
        ContextDemo contextDemo = new ContextDemo();
        contextDemo.show();
    }

    @Autowired
    private ApplicationContext applicationContext;

    public void show (){
        System.out.println(applicationContext.getClass());
    }
}
