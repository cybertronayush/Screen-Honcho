
package remotecontrolpc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class RemoteControlPC extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("MainScreen.fxml")
        );
        Parent root = (Parent) fxmlLoader.load();
        MainScreenController mainScreenController = 
                (MainScreenController) fxmlLoader.getController();
        mainScreenController.setMainScreenController(mainScreenController);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Screen-Honcho");
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
