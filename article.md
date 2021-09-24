# Introduction to graphics application
### Home Appliance using JavaFX

According to the documentation, JavaFX is a set of graphics and media packages that enables developers to design, create, test, debug, and deploy rich client applications that operate consistently across diverse platforms. And in this application it was necessary to build a simple system that used some buttons with functionality to open a new window, plus or subtract value one on screen, and turn off the system.

To do this, it was used a Scene Builder to assist in the development of application design. Scene Builder allows you to easily layout JavaFX UI controls, charts, shapes, and containers, so that you can quickly prototype user interfaces. Animations and effects can be applied seamlessly for more sophisticated UIs. 

<image>![image](https://user-images.githubusercontent.com/88175144/134718003-c5d8039e-2b22-4694-9418-bb1bd6e51e89.png)
      
## **Building an interface**

Initially, was scoped in Scene builder with all icons images and background to generate the code in FXML and then, some adjustments were made to the code to make it more similar to real example, like image sizes, transparent icons and icons with functionality.

<image>![image](https://user-images.githubusercontent.com/88175144/134718412-f8b3461f-ac96-4fd1-aa5b-6fa74398273d.png)

* The application size was defined, the FX controller and all images views, images and buttons. The images are inside a folder into a project

```fxml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.Cursor?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.layout.Pane?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.text.Font?>

<Pane maxHeight="480.0" maxWidth="800.0" minHeight="480.0" minWidth="800.0" prefHeight="480.0" prefWidth="800.0"
      xmlns="http://javafx.com/javafx/16" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.Controller">
   <children>
      <ImageView fx:id="background" fitHeight="664.0" fitWidth="882.0" layoutX="-41.0" layoutY="-68.0">
         <image>
            <Image url="@assets/background_day.png" />
         </image>
         <cursor>
            <Cursor fx:constant="HAND" />
         </cursor>
      </ImageView>
      <ImageView fx:id="circle" fitHeight="198.0" fitWidth="200.0" layoutX="290.0" layoutY="141.0">
         <image>
            <Image url="@assets/clock_background.png" />
         </image>
      </ImageView>
      <ImageView fx:id="drop" layoutX="53.0" layoutY="208.0">
         <image>
            <Image url="@assets/drop_icon.png" />
         </image>
      </ImageView>
      <ImageView fx:id="thermometerIcon" layoutX="54.0" layoutY="254.0">
         <image>
            <Image url="@assets/thermometer_icon.png" />
         </image>
      </ImageView>
         ...
```

## **Application Controller**
Controller are Classes that control all methods implemented and they connect the archive FXML with java code in the application. 
         
* To change the background and set different image buttons when they are help down or not, it’s necessary create a new images view and images.
```java   
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
```
               
* There are two methods to change the background and buttons and a new method that is responsible to set all image view size.
```java     
/**
* method responsible for change the
* background to light theme
*/
public void changeBackgroundDay() {
  day.setGraphic(dayButtonOn);
  night.setGraphic(nightButtonOff);
  setWidthAndHeight();

  background.setImage(dayImage);
  background.setFitHeight(664);
  background.setFitWidth(882);
}

/**
* method responsible for change the
* background to dark theme
*/
public void changeBackgroundNight() {
  night.setGraphic(nightButtonOn);
  day.setGraphic(dayButtonOff);
  setWidthAndHeight();

  background.setImage(nightImage);
  background.setFitHeight(654);
  background.setFitWidth(972);
}

/**
* method responsible for set the
* width and the height of the day on/off,
* night on/off buttons
*/
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
```
               
The visual effect in the buttons are these

<image>![image](https://user-images.githubusercontent.com/88175144/134719801-bddaf02f-344a-4ad9-b4b8-04e06f30ae77.png) <image>![image](https://user-images.githubusercontent.com/88175144/134719835-5f4a90a3-82ef-4b25-9225-63eb4d3454b6.png)

* The method to turn off the application is very simple and it is connected to the image button in the left top of the application
               
```java 
/**
* method responsible for turnOff the application
*/
public void turnOff() {
  System.exit(0);
}
```
The visual effect in the button is this
      
<image>![image](https://user-images.githubusercontent.com/88175144/134720377-915b9014-e1b7-4b1a-b7e3-0c3fde3268ff.png)
      
* To start the current time clock and the image button and background in light theme, was necessary to instantiate new IntegerProperty, to start the screen always in 16°C, and call the label time and temperature.

```java       
@FXML
private Label time;

@FXML
private Label temperature;

IntegerProperty property = new SimpleIntegerProperty();
```
      
The method instantiate is responsible to do this.

```java  
/**
* method responsible for starts the current time clock,
* set the width and the height of the day on button
*/
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
``` 
      
Its possible to see it here.
      
      <image>![image](https://user-images.githubusercontent.com/88175144/134720973-c8570b2b-04b4-4bc2-866a-9747ac13a33e.png)

* To plus or subtract one on temperature display in the range between 31 and 16°C was used a plusOne and minusOne method.     

```java
/**
* method responsible for add one on the screen of temperature
*/
public void plusOne(){
  if(property.get() >= 16 && property.get() < 31){
      property.set(property.get() + 1);
      temperature.textProperty().bind(property.asString());
  }
}

/**
* method responsible for subtract one on the screen of temperature
*/
public void minusOne(){
  if(property.get() <= 31 && property.get() > 16){
      property.set(property.get() - 1);
      temperature.textProperty().bind(property.asString());
  }
}
```

The effect on screen is 

<image>![image](https://user-images.githubusercontent.com/88175144/134721383-ca8b2c3b-312f-4763-865d-1d1545f49afa.png)

* Lastly, to open a new window when all buttons are helped down, was created a popup method that send a message informing that the button is ok.

```java
/**
* method responsible for popUp window of the buttons
*/
public void popUp(){
  Alert alert = new Alert(Alert.AlertType.INFORMATION);
  alert.setTitle("Pop-Up notification");
  alert.setContentText("Button is ok!");

  Optional<ButtonType> result = alert.showAndWait();
}
```

The effect on application is 
      
<image>![image](https://user-images.githubusercontent.com/88175144/134721663-11415bf1-4f3d-4dac-b010-cfe9ca0e6219.png)
      
## **Main**

Here is a standard, only changed the scene size, set a title, set the locale default as US and used try/catch to exception.

```java
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
```
      
## **Conclusion**
      
By the end, is not difficult to build an application using JavaFX, but it can be very long and verbose code to construct simple things. On the other hand, can be more easier using a Scene Builder to do the scope of the application to after modify the code to introduce new things. Everything can work out if use any strategy and a methodology divided into several parts to build an application using JavaFX.

