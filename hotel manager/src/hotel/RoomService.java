/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * 
 */
public class RoomService extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //the lunch button
        Button breakfastBtn = new Button();
        breakfastBtn.setText("Breakfast");
        breakfastBtn.setOnAction((ActionEvent event) -> {
            //Create a menu class that has breakfast menu
            BFMenu breakfast = new BFMenu();
            primaryStage.close();
            Stage bfast = new Stage();
            breakfast.start(bfast);
            
        });
        //the lunch button
        Button lunchDinnerBtn = new Button();
        lunchDinnerBtn.setText("Lunch/Dinner");
        lunchDinnerBtn.setOnAction((ActionEvent event) -> {
            //create a menu class that has a lunch menu
            LunchDinnerMenu ld = new LunchDinnerMenu();
            primaryStage.close();
            Stage lunch = new Stage();
            ld.start(lunch);
        });
        
        //the snacks button
        Button snackBtn = new Button();
        snackBtn.setText("Snacks");
        snackBtn.setOnAction((ActionEvent event) -> {
            //create a menu class that has a dinner menu
            SnackMenu sm = new SnackMenu();
            primaryStage.close();
            Stage snacks = new Stage();
            sm.start(snacks);
            
        });
        VBox orderRS = new VBox(20, breakfastBtn, lunchDinnerBtn, snackBtn);
        orderRS.setAlignment(Pos.CENTER);
        
        StackPane root = new StackPane();
        root.getChildren().add(orderRS);
        
        
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Room Service");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

