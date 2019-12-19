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
public class BFMenu extends Menu{
    Menu breakfastM = new Menu();
    String bfastItem;
    rmServicePay p = new rmServicePay();
    public BFMenu(){ //set all the menu items
        breakfastM.setItem1("Fritters $2.50");
        breakfastM.setItem2("Pancakes with German Sausage $6.50");
        breakfastM.setItem3("Waffles with White Sauce $7.00");
    }
    public void start(Stage primaryStage){
        final ToggleGroup group = new ToggleGroup(); //for the radiobuttons
        
        Label items = new Label("Select an Item.");
        //create the radio buttons for each menu item
        RadioButton rb1 = new RadioButton(breakfastM.getItem1());
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton(breakfastM.getItem2());
        rb2.setToggleGroup(group);
        
        RadioButton rb3 = new RadioButton(breakfastM.getItem3());
        rb3.setToggleGroup(group);
        //create a final butto that submits the order
        Button selection = new Button("Continue");
        selection.setOnAction((ActionEvent event)-> {
            bfastItem = group.getSelectedToggle().toString();
            if (bfastItem.contains("Waffles") == true){
                bfastItem = breakfastM.getItem3();
                p.setPrice(7.0);
            }
            else if (bfastItem.contains("Fritters")== true){
                bfastItem = breakfastM.getItem1();
                p.setPrice(2.5);
            }
            else if (bfastItem.contains("Pancakes")){
                bfastItem = breakfastM.getItem2();
                p.setPrice(6.5);
            }
            rmServicePay p = new rmServicePay();
            primaryStage.close();
            Stage payment = new Stage();
            p.start(payment); //start the payment window
        });
        //create the fitter picture
Image fritterPic = new Image(BFMenu.class.getResourceAsStream("fritters.jpg"));
ImageView fritterView = new ImageView(fritterPic);
//create the pancake picture
Image pancakePic = new Image(BFMenu.class.getResourceAsStream("pancakes.jpg"));
ImageView pancakeView = new ImageView(pancakePic);
//create the waffel picture 
Image wafflePic = new Image(BFMenu.class.getResourceAsStream("waffles.JPG"));
ImageView waffleView = new ImageView(wafflePic);

//Resize the images
fritterView.setFitWidth(100);
fritterView.setPreserveRatio(true);

pancakeView.setFitWidth(100);
pancakeView.setPreserveRatio(true);

waffleView.setFitWidth(100);
waffleView.setPreserveRatio(true);

//add all elements to the grid pane 

GridPane bfBox = new GridPane();
bfBox.add(items, 0, 0);
bfBox.add(rb1, 0, 1);
bfBox.add(fritterView,1,1);
bfBox.add(rb2, 0, 2);
bfBox.add(pancakeView,1,2);
bfBox.add(rb3, 0, 3);//FIXME 
bfBox.add(waffleView,1,3);
bfBox.add(selection,1,4);
     
    //add the gridpane to the scene   
    Scene scene = new Scene(bfBox , 500, 300);
        
        primaryStage.setTitle("Payment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
   
   public String getBreakfastResult(){
       return bfastItem;
   }
}

