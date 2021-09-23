package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

/**
 * Class Main that starts the code
 * @author Lucas Gomes
 */
public class Main extends Application {


    /**
     * Define the parameters of the scene, locale default and exception handling
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage){
        Locale.setDefault(Locale.US);

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Home Appliance");
        primaryStage.setScene(new Scene(root, 800, 480));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
