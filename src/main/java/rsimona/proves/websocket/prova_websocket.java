package rsimona.proves.websocket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Ramon
 */
@ServerEndpoint("/websocket")
public class prova_websocket {

    @OnMessage
    public void onMessage(String message, Session session) {

        System.out.println("Ha arribat al servidor: " + message);
        try {
            session.getBasicRemote().sendText("Resposta desde el websocket '" + message + "'");
        } catch (IOException ex) {
            Logger.getLogger(prova_websocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnOpen
    public void onOpen() {
        System.out.println("Client connectat");
    }

    @OnClose
    public void onClose() {
        System.out.println("Client desconnectat");
    }
}
