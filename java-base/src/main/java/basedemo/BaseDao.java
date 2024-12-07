package basedemo;

import java.lang.reflect.ParameterizedType;

/**
 * @author weimenghua
 * @date 2021-11-17 21:53
 */

/**
 * 抽象类，定义泛型<T>
 */
public abstract class BaseDao<T> {
    public BaseDao(){
        Class clazz = this.getClass();
        ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
        clazz = (Class) pt.getActualTypeArguments()[0];
        System.out.println(clazz);
    }
}
