package basedemo;


import basedemo.dto.UserInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weimenghua
 * @date 2021-11-17 21:54
 */
public class BaseDaoUser extends BaseDao<UserInfo>{
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        BaseDao<UserInfo> userInfoBaseDao = new BaseDaoUser();
        System.out.println(userInfoBaseDao);
    }
}
