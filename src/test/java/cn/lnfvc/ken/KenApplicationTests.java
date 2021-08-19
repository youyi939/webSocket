package cn.lnfvc.ken;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

@SpringBootTest
class KenApplicationTests {

    @Test
    void contextLoads() {
        try {
            String url = "wss://127.0.0.1:9091/message_websocket";
            URI uri = new URI(url);
            WebSocketClient mWs = new WebSocketClient(uri){
                @Override
                public void onOpen(ServerHandshake serverHandshake) {

                }

                @Override
                public void onMessage(String s) {
                    System.out.println(s);
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println(s);
                }

                @Override
                public void onError(Exception e) {
                    System.out.println(e);
                }
            };
            mWs.connect();
            System.out.println("haha");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
