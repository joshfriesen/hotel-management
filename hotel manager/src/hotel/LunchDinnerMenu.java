/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author 
 */
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
 * @author michelle
 */
public class LunchDinnerMenu extends Menu {
    Menu m = new Menu();
    String ldItem;
    rmServicePay p = new rmServicePay();
    public LunchDinnerMenu(){
    //set all the menu items 
    m.setItem1("Two Beerocks $8.00");
    m.setItem2("Verenika with German Sausage $15.00");
    m.setItem3("Borscht $5.00");
    }
    public void start(Stage primaryStage){
        final ToggleGroup group = new ToggleGroup();//create for the radio buttons
        
        Label items = new Label("Select an Item.");
        //create radio buttons for all of menu items
        RadioButton rb1 = new RadioButton(m.getItem1());
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton(m.getItem2());
        rb2.setToggleGroup(group);
        
        RadioButton rb3 = new RadioButton(m.getItem3());
        rb3.setToggleGroup(group);
        //create a final button to submit the order
        Button selection = new Button("Continue");
        selection.setOnAction((ActionEvent event)-> {
            ldItem = group.getSelectedToggle().toString();
            if (ldItem.contains("Beerocks") == true){
                ldItem = m.getItem3();
                p.setPrice(8.0);
            }
            else if (ldItem.contains("Verenika")== true){
                ldItem = m.getItem1();
                p.setPrice(15.00);
            }
            else if (ldItem.contains("Borscht")){
                ldItem = m.getItem2();
                p.setPrice(5.0);
            }
           //start the payment window
            primaryStage.close();
            Stage payment = new Stage();
            p.start(payment);
        });
        
        
       //create the menu pictures
Image beerockPic = new Image(BFMenu.class.getResourceAsStream("beerocks.jpg"));
ImageView beerockView = new ImageView(beerockPic);

Image verenikaPic = new Image(BFMenu.class.getResourceAsStream("verenika.jpg"));
ImageView verenikaView = new ImageView(verenikaPic);

Image borschtPic = new Image(BFMenu.class.getResourceAsStream("borscht.JPG"));
ImageView borschtView = new ImageView(borschtPic);

//Resize the images
beerockView.setFitWidth(100);
beerockView.setPreserveRatio(true);

verenikaView.setFitWidth(100);
verenikaView.setPreserveRatio(true);

borschtView.setFitWidth(100);
borschtView.setPreserveRatio(true);

// add the elements to the grid pane 
GridPane ldBox = new GridPane();
ldBox.add(items, 0, 0);
ldBox.add(rb1, 0, 1);
ldBox.add(beerockView,1,1);
ldBox.add(rb2, 0, 2);
ldBox.add(verenikaView,1,2);
ldBox.add(rb3, 0, 3);
ldBox.add(borschtView,1,3);
ldBox.add(selection,1,4);
         Scene scene = new Scene(ldBox , 500, 300);
        
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
