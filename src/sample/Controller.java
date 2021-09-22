package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Controller {

    @FXML
    private ImageView background;

    Image dayImage = new Image(getClass().getResourceAsStream("assets/background_day.png"));

    Image nightImage = new Image(getClass().getResourceAsStream("assets/background_night.png"));
    public void changeBackgroundDay() {
        background.setImage(dayImage);
        background.setFitHeight(664);
        background.setFitWidth(882);
    }

    public void changeBackgroundNight() {
        background.setImage(nightImage);
        background.setFitHeight(654);
        background.setFitWidth(972);
    }

    public void turnOff() {
        System.exit(0);
    }

    @FXML
    private Label time;

    @FXML
    private Label temperature;

    IntegerProperty property = new SimpleIntegerProperty();

    @FXML
    public void initialize() {
        property.set(16);
        temperature.textProperty().bind(property.asString());

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime currentTime = LocalTime.now();
            time.setText(dtf.format(currentTime));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void plusOne(){
        if(property.get() >= 16 && property.get() < 31){
            property.set(property.get() + 1);
            temperature.textProperty().bind(property.asString());
        }
    }

    public void minusOne(){
        if(property.get() <= 31 && property.get() > 16){
            property.set(property.get() - 1);
            temperature.textProperty().bind(property.asString());
        }
    }
}
