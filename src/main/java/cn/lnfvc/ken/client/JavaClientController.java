package cn.lnfvc.ken.client;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/8/19 上午11:01
 */
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jc")
public class JavaClientController {


    @Autowired
    private JavaClient javaClient;

    @GetMapping(value = "open")
    public void hello(@RequestParam String str){


        WebSocketClient client = this.javaClient.getClient("ws://localhost:9091/ws/server");

        if (client != null){
            client.send(str);
            client.send("你好啊");
        }


    }





}