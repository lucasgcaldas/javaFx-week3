#Introduction to graphics application
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
```
