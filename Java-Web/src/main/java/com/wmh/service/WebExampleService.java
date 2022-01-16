package com.wmh.service;



import com.wmh.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface WebExampleService {

    String StringMethod(String a, String b);

    String StringMethodRequest(UserInfo request);

    UserInfo DtoMethod(String a, String b);

    UserInfo DtoMethodRequest(UserInfo request);

    UserInfo DtoStringMethodRequest(String a, UserInfo request);

    UserInfo DtoStringMethodListRequest(String a, List<UserInfo> userInfoList);

    Map<String,Object> getUserList(String a, String b);

    List<UserInfo> ListMethod(Map<String, Object> param);

    void VoidMethod(String a, String b);

    void VoidMethodRequest(UserInfo request);

    void VoidMethodNoArgs();

    boolean BooleanMethod(String a);

    int IntMetod(String a);
}
