package utils;

import javax.naming.ServiceUnavailableException;
import java.net.ConnectException;

/**
 * This Class simulate the behavior of a remote service call by ou application.
 */
public class ExtServiceConnector {

    public void connect() {
        System.out.println("Connected to external service");
    }

    public boolean isConnectionAlive() {
        System.out.println("Connection is alive");
        return true;
    }

    public boolean isConnectionAliveOrNot() {
        System.out.println("Service is not available");
        return false;
    }

    public void close() {
        System.out.println("Closed connection to ext service");
    }

}
