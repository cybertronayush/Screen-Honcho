
package filesharing;

import file.AvatarFile;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class SendFilesList {
    public void sendFilesList(final FileAPI fileAPI, final String path, final ObjectOutputStream out) {
        new Thread() {
            public void run() {
                ArrayList<AvatarFile> myFiles = fileAPI.getFiles(path);
                System.out.println(path);
                try {
                    out.writeObject(myFiles);
                    out.flush();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
