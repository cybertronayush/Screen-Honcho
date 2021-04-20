
package ipaddress;

import java.net.ServerSocket;

public class GetFreePort {
    private boolean isPortAvailable(int port) {
        boolean portAvailable = true;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch(Exception e) {
            portAvailable = false;
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch(Exception e) {
                    e.printStackTrace();
                };
            }
        }
        return portAvailable;
    }
    
    public int getFreePort() {
        int port = 3000;
        while (true) {
            if (isPortAvailable(port) == true) {
                break;
            } else {
                port++;
            }
        }
        return port;
    }
    
}
