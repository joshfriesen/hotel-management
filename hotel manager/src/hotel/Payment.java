/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.text.NumberFormat;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author
 */
public class Payment {
    //calls the resercation class to get information from it
    Reservation r = new Reservation();
    protected double price;
    public void start(Stage primaryStage) {
        
        //sets up the gridpane
        GridPane gp = new GridPane();
        //information that sets up the name category
        
        Image htl = new Image(Payment.class.getResourceAsStream("blue.jpg"));
    BackgroundSize backgroundsize = new BackgroundSize(500,500,true,true,true,false);
    BackgroundImage backgroundimage = new BackgroundImage(htl, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundsize);
    Background background = new Background(backgroundimage);
    gp.setBackground(background);
        
        Label name = new Label("Name: ");
        TextField nameInput = new TextField();
        gp.add(name, 0, 1);
        gp.add(nameInput, 1, 1);
        //information that sets up and adds the card type category 
        Label typeCard = new Label("Card Type: ");
        ChoiceBox<String> card = new ChoiceBox<>();
        card.getItems().addAll("VISA", "MasterCard", "American Express", "Discover");
        gp.add(typeCard, 0, 2);
        gp.add(card, 1, 2);
        //information that sets up and adds the card number category
        Label creditCard = new Label("Credit Card Number: ");
        TextField cardInput = new TextField();
        cardInput.setPromptText("e.g. xxxx-xxxx-xxxx-xxxx");
        cardInput.setFocusTraversable(false);
        gp.add(creditCard, 0, 3);
        gp.add(cardInput, 1, 3);
        //information that sets up and adds the security code category
        Label security = new Label("Security Code: ");
        TextField securityInput = new TextField();
        gp.add(security, 0, 4);
        gp.add(securityInput, 1, 4);
        //information that sets up and adds the month category
        Label month = new Label("Expiration Date: ");
        TextField monthInput = new TextField();
        gp.add(month, 0, 5);
        gp.add(monthInput, 1, 5);
        //information that sets up and adds the billing address category
        Label address = new Label("Billing Address: ");
        TextField addressInput = new TextField();
        gp.add(address, 0, 6);
        gp.add(addressInput, 1, 6);
        //information that sets up and adds the zipcode category
        Label zipcode = new Label("Zipcode: ");
        TextField zipcodeInput = new TextField();
        gp.add(zipcode, 0, 7);
        gp.add(zipcodeInput, 1, 7);
        //information that sets up and adds the state category
        
        
        Text pay = new Text("Your total price is " + getPrice());
        pay.setFont(Font.font ("Serif", 20));
        gp.add(pay, 0, 0);
        //button tha confirms everything entered into the text fields
        Button confirm = new Button("Confirm Purchase");
        confirm.setOnAction((ActionEvent event) -> {
            Text output = new Text("Payment Confirmed! Enjoy!");
            output.setFont(Font.font ("Serif", 20));
            gp.add(output, 1, 11);
        });
        gp.add(confirm, 1,10);
        //sets up the scene
        Scene scene = new Scene(gp ,  500, 500);
        
        primaryStage.setTitle("Payment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        HotelRooms h = new HotelRooms();
        
        //method to get the room and day price together
        public String getPrice(){
            int day = Reservation.getDays();
            int room = h.getPay();
            price = day * room;
            String pays = formatter.format(price);
            return pays;
        }
        
        
}
