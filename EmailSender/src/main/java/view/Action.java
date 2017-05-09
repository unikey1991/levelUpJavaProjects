package view;

import java.io.IOException;

/**
 * Created by unike on 04.05.2017.
 */
public interface Action {

    void create();
    void read();
    void update();
    void delete();
    void sendMesage();
    void loadPacket();
    void packetSend() throws InterruptedException, IOException;
}
