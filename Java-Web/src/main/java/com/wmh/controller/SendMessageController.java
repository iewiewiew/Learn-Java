package com.wmh.controller;

/**
 * @Author weimenghua
 * @Date 2022-06-09 16:22
 * @Description WebScoket服务端发送消息
 */


import com.wmh.service.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/wbtest")
public class SendMessageController {
    @GetMapping("/sendMsg/{content}")
    public void sendMsg(@PathVariable("content") String content){
        List<String> list = WebSocketServer.getList();
        list.stream().forEach(sid ->{
            try {
                WebSocketServer.sendInfo("服务端发送: " + content, sid);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
