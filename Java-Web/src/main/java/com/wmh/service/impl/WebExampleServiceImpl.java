package com.wmh.service.impl;

import com.wmh.dto.WebExampleDto;
import com.wmh.service.WebExampleService;
import java.util.List;
import java.util.Map;

public class WebExampleServiceImpl implements WebExampleService {
    @Override
    public String StringMethod(String a, String b) {
        return null;
    }

    @Override
    public String StringMethodRequest(WebExampleDto request) {
        return null;
    }

    @Override
    public WebExampleDto DtoMethod(String a, String b) {
        return null;
    }

    @Override
    public WebExampleDto DtoMethodRequest(WebExampleDto request) {
        return null;
    }

    @Override
    public WebExampleDto DtoStringMethodRequest(String a, WebExampleDto request) {
        return null;
    }

    @Override
    public WebExampleDto DtoStringMethodListRequest(String a, List<WebExampleDto> webExampleDtoList) {
        return null;
    }

    @Override
    public Map<String, Object> getUserList(String a, String b) {
        return null;
    }

    @Override
    public List<WebExampleDto> ListMethod(Map<String, Object> param) {
        return null;
    }

    @Override
    public void VoidMethod(String a, String b) {

    }

    @Override
    public void VoidMethodRequest(WebExampleDto request) {

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
