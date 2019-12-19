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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author megan, michelle, and josh
 */
public class Hotel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Creates a button for the Reservation class
        Button btn = new Button();
        btn.setText("Make a Reservation");
        String css = Hotel.class.getResource("Viper.css").toExternalForm();
        String css2 = Hotel.class.getResource("Venom.css").toExternalForm();
        btn.getStylesheets().add(css);
        btn.setOnAction((ActionEvent event) -> {
           //Action event triggers the opening of the Reservation Screen
           Reservation r = new Reservation();
           primaryStage.close();
            Stage stage2 = new Stage();
            r.start(stage2);
        });
        //Creates a button for the Room Service Class
        Button btn2 = new Button();
        btn2.setText("Order Room Service");
        btn2.getStylesheets().add(css2);
        btn2.setOnAction((ActionEvent event) -> {
            //Action event triggers the opening of the Room Service Screen
            RoomService rs = new RoomService();
            primaryStage.close();
            Stage stage3 = new Stage();
            rs.start(stage3);
        });
        
        
        StackPane root = new StackPane();
        //Creates a nice title
        Image title = new Image(Hotel.class.getResourceAsStream("Welcome.jpg"));
        ImageView welcome = new ImageView(title);
        welcome.setFitWidth(300);
        welcome.setPreserveRatio(true);
        
        HBox hbox = new HBox(50, btn, btn2);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(40, welcome, hbox);
        
       
        Image blu = new Image(Hotel.class.getResourceAsStream("blue.jpg"));
    BackgroundSize backgroundsize = new BackgroundSize(500,500,true,true,true,false);
    BackgroundImage backgroundimage = new BackgroundImage(blu, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundsize);
    Background background = new Background(backgroundimage);
    root.setBackground(background);
        
        root.getChildren().add(vbox);

        
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hotel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
