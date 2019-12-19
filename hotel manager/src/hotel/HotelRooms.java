/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 *
 * 
 */
public class HotelRooms {

//all the data variable definitions
protected static int example; //number of rooms the user can select
protected static int slc = 0;  //number of rooms the user has selected
static int temp = example - slc;
protected static int PPN=0;

//Labeling the final image
protected static Text rooms = new Text("Select " + temp + " more room(s)");
protected static Text ppn = new Text("Total: $" + PPN);

//button defininitions and their effects
protected static InnerShadow in = new InnerShadow();
protected static Button S1 = new Button("Suite");
protected static Button B1 = new Button("B1");
protected static Button B2 = new Button("B2");
protected static Button B3 = new Button("B3");
protected static Button C1 = new Button("C1");
protected static Button C2 = new Button("C2");
protected static Button C3 = new Button("C3");
protected static Button C4 = new Button("C4");
protected static Button C5 = new Button("C5");
protected static Button C6 = new Button("C6");
protected static Button C7 = new Button("C7");
protected static Button C8 = new Button("C8");
protected static Button C9 = new Button("C9");
protected static Button D1 = new Button("D1");
protected static Button D2 = new Button("D2");
protected static Button D3 = new Button("D3");
protected static Button D4 = new Button("D4");
protected static Button D5 = new Button("D5");
protected static Button D6 = new Button("D6");
protected static Button D7 = new Button("D7");
  
//constructos, n brings in number of rooms ordered
    public HotelRooms(int n){
        example = n;
    }
    public HotelRooms(){
        example = 0;
    }
    
    public void start(Stage primaryStage){
    
    //sets the background image as the hotel layout
    Image htl = new Image(HotelRooms.class.getResourceAsStream("hotel.png"));
    BackgroundSize backgroundsize = new BackgroundSize(500,500,true,true,true,false);
    BackgroundImage backgroundimage = new BackgroundImage(htl, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundsize);
    Background background = new Background(backgroundimage);
    
    
    //labels for the final output and setting label position in the pane
    Text prices = new Text("Prices per Night:");
    prices.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.MEDIUM, 15));
    prices.setTranslateX(-180);
    prices.setTranslateY(-50);
    Text price = new Text("Suit:         $300\nB units:    $150\nC units:    $100\nD units:    $80");
    price.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.LIGHT, 10));
    price.setTranslateX(-200);
    price.setTranslateY(-13);
    Text title = new Text("Select your " + example +" room(s)");
    title.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.MEDIUM, 17));
    title.setTranslateX(-160);
    title.setTranslateY(-210);
    
    //label for the text button
    rooms.setTranslateX(130);
    rooms.setTranslateY(200);
    
    //label that says price per night in final output, styling
    ppn.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.MEDIUM, 15));
    ppn.setTranslateX(-205);
    ppn.setTranslateY(40);
    
    //sets error if user picks incorrect number of rooms
    Text error = new Text("");
    error.setTranslateY(225);
    
    //sets suite button effects
    S1.setTranslateX(-111);
    S1.setTranslateY(123);
    S1.setOnAction(new S1Handler());
    S1.setEffect(in);
    S1.setEffect(null);
    
    //sets b room button aesthetics and event handlers
    B1.setTranslateX(-63);
    B1.setTranslateY(-76);
    B1.setOnAction(new B1Handler());
    B2.setTranslateX(-63);
    B2.setTranslateY(-12);
    B2.setOnAction(new B2Handler());
    B3.setTranslateX(-63);
    B3.setTranslateY(52);
    B3.setOnAction(new B3Handler());
    
    //sets c room button aesthetics and event handlers
    C1.setOnAction(new C1Handler());
    C2.setOnAction(new C2Handler());
    C3.setOnAction(new C3Handler());
    C4.setOnAction(new C4Handler());
    C5.setOnAction(new C5Handler());
    C6.setOnAction(new C6Handler());
    C7.setOnAction(new C7Handler());
    C8.setOnAction(new C8Handler());
    C9.setOnAction(new C9Handler());
    C1.setTranslateX(4);
    C1.setTranslateY(-119);
    C2.setTranslateX(4);
    C2.setTranslateY(-91);
    C3.setTranslateX(4);
    C3.setTranslateY(-63);
    C4.setTranslateX(4);
    C4.setTranslateY(-36);
    C5.setTranslateX(4);
    C5.setTranslateY(-7);
    C6.setTranslateX(46);
    C6.setTranslateY(57);
    C7.setTranslateX(73);
    C7.setTranslateY(57);
    C8.setTranslateX(100);
    C8.setTranslateY(57);
    C9.setTranslateX(127);
    C9.setTranslateY(57);
    
    
    //set d room button aesthetics and event handlers
    D1.setOnAction(new D1Handler());
    D2.setOnAction(new D2Handler());
    D3.setOnAction(new D3Handler());
    D4.setOnAction(new D4Handler());
    D5.setOnAction(new D5Handler());
    D6.setOnAction(new D6Handler());
    D7.setOnAction(new D7Handler());
    D1.setTranslateX(-65);
    D1.setTranslateY(132);
    D2.setTranslateX(-38);
    D2.setTranslateY(132);
    D3.setTranslateX(-11);
    D3.setTranslateY(132);
    D4.setTranslateX(17);
    D4.setTranslateY(132);
    D5.setTranslateX(44);
    D5.setTranslateY(132);
    D6.setTranslateX(72);
    D6.setTranslateY(132);
    D7.setTranslateX(98);
    D7.setTranslateY(132);
    
    //sets continue button lambda event handler
    Button Continue = new Button("Continue");
    Continue.setTranslateY(200);
    Continue.setOnAction(cne->{
        if (example == slc){
            primaryStage.close();
            Payment p = new Payment();
            Stage pay = new Stage();
            p.start(pay);
        }
        else {
            error.setText("Incorrect Number of Rooms!");
        }
        
    });
    
    //sets up the stackpane
    StackPane root = new StackPane();
    
    //adds all the buttons and text as children to the stackpane
    root.setBackground(background);
    root.getChildren().add(prices);
    root.getChildren().add(price);
    root.getChildren().add(title);
    root.getChildren().add(S1);
    root.getChildren().add(B1);
    root.getChildren().add(B2);
    root.getChildren().add(B3);
    root.getChildren().add(C1);
    root.getChildren().add(C2);
    root.getChildren().add(C3);
    root.getChildren().add(C4);
    root.getChildren().add(C5);
    root.getChildren().add(C6);
    root.getChildren().add(C7);
    root.getChildren().add(C8);
    root.getChildren().add(C9);
    root.getChildren().add(D1);
    root.getChildren().add(D2);
    root.getChildren().add(D3);
    root.getChildren().add(D4);
    root.getChildren().add(D5);
    root.getChildren().add(D6);
    root.getChildren().add(D7);
    root.getChildren().add(Continue);
    root.getChildren().add(rooms);
    root.getChildren().add(ppn);
    root.getChildren().add(error);
 
    //sets up scene and stage
    Scene scene = new Scene(root, 500, 500);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Hotel Rooms");
    primaryStage.show();
}

    
    //all the event handler classes that couldn't be done in lambdas
    private static class S1Handler implements EventHandler<ActionEvent> {

        public S1Handler() {
        }
        boolean chosen = false;
        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
            chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=300;
                S1.setEffect(in);
            }
            else{
                slc -=1;
                PPN-=300;
                S1.setEffect(null);
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
    }
    }

    private static class B1Handler implements EventHandler<ActionEvent> {

        public B1Handler() {
        }
        boolean chosen = false;
        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=150;
                B1.setEffect(in);
            }
            else{
                slc -=1;
                PPN-=150;
                B1.setEffect(null);
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class B2Handler implements EventHandler<ActionEvent> {

        public B2Handler() {
        }
        boolean chosen = false;
        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=150;
                B2.setEffect(in);
            }
            else{
                B2.setEffect(null);
                slc -=1;
                PPN-=150;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class B3Handler implements EventHandler<ActionEvent> {

        public B3Handler() {
        }
        boolean chosen = false;
        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=150;
                B3.setEffect(in);
            }
            else{
                B3.setEffect(null);
                slc -=1;
                PPN-=150;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C1Handler implements EventHandler<ActionEvent> {

        public C1Handler() {
        }
        boolean chosen = false;
        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C1.setEffect(in);
            }
            else{
                C1.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C2Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public C2Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C2.setEffect(in);
            }
            else{
                C2.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C3Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public C3Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C3.setEffect(in);
            }
            else{
                C3.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C4Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public C4Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C4.setEffect(in);
            }
            else{
                C4.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C5Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public C5Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C5.setEffect(in);
            }
            else{
                C5.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C6Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public C6Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C6.setEffect(in);
            }
            else{
                C6.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C7Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public C7Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C7.setEffect(in);
            }
            else{
                C7.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C8Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public C8Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C8.setEffect(in);
            }
            else{
                C8.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class C9Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public C9Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=100;
                C9.setEffect(in);
            }
            else{
                C9.setEffect(null);
                slc -=1;
                PPN-=100;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class D1Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public D1Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=80;
                D1.setEffect(in);
            }
            else{
                D1.setEffect(null);
                slc -=1;
                PPN-=80;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class D2Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public D2Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=80;
                D2.setEffect(in);
            }
            else{
                D2.setEffect(null);
                slc -=1;
                PPN-=80;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class D3Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public D3Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=80;
                D3.setEffect(in);
            }
            else{
                D3.setEffect(null);
                slc -=1;
                PPN-=80;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class D4Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public D4Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=80;
                D4.setEffect(in);
            }
            else{
                D4.setEffect(null);
                slc -=1;
                PPN-=80;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class D5Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public D5Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=80;
                D5.setEffect(in);
            }
            else{
                D5.setEffect(null);
                slc -=1;
                PPN-=80;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class D6Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public D6Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=80;
                D6.setEffect(in);
            }
            else{
                D6.setEffect(null);
                slc -=1;
                PPN-=80;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
    }

    private static class D7Handler implements EventHandler<ActionEvent> {
        boolean chosen = false;
        public D7Handler() {
        }

        @Override
        public void handle(ActionEvent event) {
            in.setColor(Color.BLUE);
 chosen = !chosen;
            if (chosen == true){
                slc +=1;
                PPN+=80;
                D7.setEffect(in);
            }
            else{
                D7.setEffect(null);
                slc -=1;
                PPN-=80;
            }
            ppn.setText("Total: $" + PPN);
            if (slc>example){
            rooms.setText("Too many rooms selected!");
                
        }
            else{
                int temp = example - slc;
                rooms.setText("Select " + temp + " more room(s)");
            }
        }
        
    }
        public int getPay(){
           return PPN;
     }
}
