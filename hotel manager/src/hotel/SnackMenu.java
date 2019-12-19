/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * 
 */
public class SnackMenu extends Menu {
//a child class to menu that sets food items
    Menu snackM = new Menu();
    String snackItem;
    rmServicePay p = new rmServicePay();
    public SnackMenu(){
    // set all the menu items
    snackM.setItem1("Zwieback $2.00");
    snackM.setItem2("Roll Kuchen $2.50");
    snackM.setItem3("Backpack Snacks $1.50");
    }
     public void start(Stage primaryStage){
        final ToggleGroup group = new ToggleGroup();//for the radio buttons
        
        Label items = new Label("Select an Item.");
        //create radio buttons for all of the menu items
        RadioButton rb1 = new RadioButton(snackM.getItem1());
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton(snackM.getItem2());
        rb2.setToggleGroup(group);
        
        RadioButton rb3 = new RadioButton(snackM.getItem3());
        rb3.setToggleGroup(group);
        //create a  final button to submit the order
        Button selection = new Button("Continue");
        selection.setOnAction((ActionEvent event)-> {
            snackItem = group.getSelectedToggle().toString();
            //makes the radio buttons do things
            if (snackItem.contains("Backpack") == true){
                snackItem = snackM.getItem3();
                p.setPrice(1.50);
            }
            else if (snackItem.contains("Zwieback")== true){
                snackItem = snackM.getItem1();
                p.setPrice(2.0);
            }
            else if (snackItem.contains("Roll")){
                snackItem = snackM.getItem2();
                p.setPrice(2.50);
            }
            //start the payment window
            primaryStage.close();
            Stage payment = new Stage();
            p.start(payment);
        });
        
        //create the menu pictures
Image zweibackPic = new Image(BFMenu.class.getResourceAsStream("zweiback.jpg"));
ImageView zweibackView = new ImageView(zweibackPic);

Image rollKuchenPic = new Image(BFMenu.class.getResourceAsStream("rolllskuchen.jpg"));
ImageView rollKuchenView = new ImageView(rollKuchenPic);

Image bpPic = new Image(BFMenu.class.getResourceAsStream("backpacks.jpg"));
ImageView bpView = new ImageView(bpPic);

//Resize the images
zweibackView.setFitWidth(100);
zweibackView.setPreserveRatio(true);

rollKuchenView.setFitWidth(100);
rollKuchenView.setPreserveRatio(true);

bpView.setFitWidth(100);
bpView.setPreserveRatio(true);

//add all elements to the gridpane 
GridPane snackBox = new GridPane();
snackBox.add(items, 0, 0);
snackBox.add(rb1, 0, 1);
snackBox.add(zweibackView,1,1);
snackBox.add(rb2, 0, 2);
snackBox.add(rollKuchenView,1,2);
snackBox.add(rb3, 0, 3);
snackBox.add(bpView,1,3);
snackBox.add(selection,1,4);       
         Scene scene = new Scene(snackBox , 500, 300);
        
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
}
