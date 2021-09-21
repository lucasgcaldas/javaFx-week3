package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ImageView circle;
    @FXML
    private ImageView notification;
    @FXML
    private ImageView warning;
    @FXML
    private ImageView wifi;
    @FXML
    private ImageView bt;
    @FXML
    private ImageView thermometerIcon;
    @FXML
    private ImageView clock;
    @FXML
    private ImageView totalcross;
    @FXML
    private ImageView torizon;
    @FXML
    private ImageView dayViwe;
    @FXML
    private Button powerOf;
    @FXML
    private Button calendar;
    @FXML
    private Button tools;
    @FXML
    private Button thermometer;
    @FXML
    private Button home;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button day;
    @FXML
    private Button night;


    @FXML
    private ImageView background;

    Image dayImage = new Image(getClass().getResourceAsStream("assets/background_day.png"));
    Image nightImage = new Image(getClass().getResourceAsStream("assets/background_night.png"));

    public void changeBackgroundDay(){
        background.setImage(dayImage);
        background.setFitHeight(664);
        background.setFitWidth(882);
    }

    public void changeBackgroundNight(){
        background.setImage(nightImage);
        background.setFitHeight(654);
        background.setFitWidth(972);
    }

    public void turnOff(){
        System.exit(0);
    }
}
