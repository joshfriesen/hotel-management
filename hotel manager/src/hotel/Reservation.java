/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;


import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 *
 * 
 */
public class Reservation {
    //Variables for the class
    
    //Tells the number of rooms wanted
    public int numRooms;
    //Tells the check in date
    private long checkIn;
    //Tells the check out date
    private long checkOut;
    //FIX ME
    int roomCost;
    //Used in the purchase method
    int totalCost;
    //holds the total number of days stayed
    int numDays;
   StackPane root = new StackPane();
    //used to call this class from the hotelMAIN class
    public void start(Stage primaryStage){
    //Drop down box to select number rooms wanted
        Label promptLabel = new Label("Number of rooms*: ");
        
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("1", "2", "3", "4");
        
     
      //Calendars to show how many days they are staying
       

        DatePicker checkInDatePicker = new DatePicker();
        DatePicker leavingDatePicker = new DatePicker();
        
        String css = Reservation.class.getResource("Regular.css").toExternalForm();
        Label checkInLabel = new Label("Check-In Date:");
        Label leavingLabel = new Label("Check-Out Date: ");
        checkInLabel.getStylesheets().add(css);
        leavingLabel.getStylesheets().add(css);
        
   
        Image pic = new Image(Reservation.class.getResourceAsStream("exa.PNG"));
        ImageView pix = new ImageView(pic);
        pix.setFitWidth(400);
        pix.setPreserveRatio(true);
        pix.setTranslateY(-120);
        promptLabel.getStylesheets().add(css);
        
        //adds all of these to the gridpane
        root.getChildren().add(checkInLabel);
        root.getChildren().add(leavingLabel);
        root.getChildren().add(checkInDatePicker);
        root.getChildren().add(leavingDatePicker);
        root.getChildren().add(pix);
        checkInLabel.setTranslateY(-43);
        checkInLabel.setTranslateX(-148);
        leavingLabel.setTranslateY(-43);
        leavingLabel.setTranslateX(58);
        checkInDatePicker.setTranslateY(-20);
        checkInDatePicker.setTranslateX(-100);
        leavingDatePicker.setTranslateY(-20);
        leavingDatePicker.setTranslateX(100);
        
        //gets a background
        Image blu = new Image(Hotel.class.getResourceAsStream("blue.jpg"));
    BackgroundSize backgroundsize = new BackgroundSize(500,500,true,true,true,false);
    BackgroundImage backgroundimage = new BackgroundImage(blu, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundsize);
    Background background = new Background(backgroundimage);
    root.setBackground(background);
        
        //button confirms everything and passes info to methods
        Button btn = new Button();
        btn.setText("Confirm");
        btn.setOnAction((ActionEvent event) -> {
            String people = choiceBox.getValue();
            //converts the string from choicebox into an int
            switch (people) {
                case "1":
                    numRooms = 1;
                    break;
                case "2":
                    numRooms = 2;
                    break;
                case "3":
                    numRooms = 3;
                    break;
                case "4":
                    numRooms = 4;
                    break;
                default:
                    numRooms = 0;
            }
            //gets the date values from the calendar
            checkIn = checkInDatePicker.getValue().toEpochDay();
            checkOut = leavingDatePicker.getValue().toEpochDay();
            numDays = (int) (checkOut - checkIn);
            setDays(numDays);
            
            //sends the room information into the Hotel class and opens this class
            HotelRooms h = new HotelRooms(numRooms);
            primaryStage.close();
            Stage openH = new Stage();
            h.start(openH);
            
            
        });
        //gives information about the rooms
        Text disclaimerText = new Text("*Each room has 2 queen beds for a maximum \n"
                                            + "of four people per room.");
        //spaces the label and the choicebox
        HBox hbox = new HBox(10, promptLabel, choiceBox);
        hbox.setTranslateX(63);
        hbox.setTranslateY(270);
        
       
        //spaces the button and text
        VBox buttonAndInfo = new VBox(15, btn, disclaimerText);
        buttonAndInfo.setTranslateY(310);
        buttonAndInfo.setTranslateX(63);
        root.getChildren().add(hbox);
        //adds to gridpane
        root.getChildren().add(buttonAndInfo);
 
    //adds the gridpane to the root
    Scene scene = new Scene(root, 500, 500);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Information");
    primaryStage.show();
   
    }
    public static int day;
    //used to get the days in the payment method
    public static void setDays(int n){
       day = n;
       
    }
    
    public static int getDays(){
        return day;
    }
}
