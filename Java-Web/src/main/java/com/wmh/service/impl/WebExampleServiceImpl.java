package com.wmh.service.impl;

import com.wmh.domain.UserInfo;
import com.wmh.service.WebExampleService;

import java.util.List;
import java.util.Map;

public class WebExampleServiceImpl implements WebExampleService {
    @Override
    public String StringMethod(String a, String b) {
        return null;
    }

    @Override
    public String StringMethodRequest(UserInfo request) {
        return null;
    }

    @Override
    public UserInfo DtoMethod(String a, String b) {
        return null;
    }

    @Override
    public UserInfo DtoMethodRequest(UserInfo request) {
        return null;
    }

    @Override
    public UserInfo DtoStringMethodRequest(String a, UserInfo request) {
        return null;
    }

    @Override
    public UserInfo DtoStringMethodListRequest(String a, List<UserInfo> userInfoList) {
        return null;
    }

    @Override
    public Map<String, Object> getUserList(String a, String b) {
        return null;
    }

    @Override
    public List<UserInfo> ListMethod(Map<String, Object> param) {
        return null;
    }

    @Override
    public void VoidMethod(String a, String b) {

    }

    @Override
    public void VoidMethodRequest(UserInfo request) {

    }

    @Override
    public void VoidMethodNoArgs() {

    }

    @Override
    public boolean BooleanMethod(String a) {
        return false;
    }

    @Override
    public int IntMetod(String a) {
        return 0;
    }
}
