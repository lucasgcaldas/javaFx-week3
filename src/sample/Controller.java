package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Controller {

    @FXML
    private Button day;
    @FXML
    private Button night;

    @FXML
    private ImageView background;

    Image dayImage = new Image(getClass().getResourceAsStream("assets/background_day.png"));
    ImageView dayButtonOn = new ImageView(getClass().getResource("assets/day_on_button.png").toExternalForm());
    ImageView dayButtonOff = new ImageView(getClass().getResource("assets/day_off_button.png").toExternalForm());
    Image nightImage = new Image(getClass().getResourceAsStream("assets/background_night.png"));
    ImageView nightButtonOn = new ImageView(getClass().getResource("assets/night_on_button.png").toExternalForm());
    ImageView nightButtonOff = new ImageView(getClass().getResource("assets/night_off_button.png").toExternalForm());

    public void changeBackgroundDay() {
        day.setGraphic(dayButtonOn);
        night.setGraphic(nightButtonOff);
        setWidthAndHeight();

        background.setImage(dayImage);
        background.setFitHeight(664);
        background.setFitWidth(882);
    }

    public void changeBackgroundNight() {
        night.setGraphic(nightButtonOn);
        day.setGraphic(dayButtonOff);
        setWidthAndHeight();

        background.setImage(nightImage);
        background.setFitHeight(654);
        background.setFitWidth(972);
    }

    private void setWidthAndHeight() {
        dayButtonOn.setFitWidth(35);
        dayButtonOn.setFitHeight(30);
        dayButtonOff.setFitWidth(35);
        dayButtonOff.setFitHeight(30);
        nightButtonOn.setFitWidth(35);
        nightButtonOn.setFitHeight(30);
        nightButtonOff.setFitWidth(35);
        nightButtonOff.setFitHeight(30);
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
        day.setGraphic(dayButtonOn);
        dayButtonOn.setFitWidth(35);
        dayButtonOn.setFitHeight(30);

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

    public void popUp(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pop-Up notification");
        alert.setContentText("Button is ok!");

        Optional<ButtonType> result = alert.showAndWait();
    }
}
