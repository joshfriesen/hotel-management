/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.text.NumberFormat;

/**
 *
 * @author
 */
public class Menu implements menuOutline {  //Acts as a parent class for the breakfast, lunch, and dinner menus 
    protected String item1;                 //also implements menu outline as an interface
    protected String item2;
    protected String item3;
    protected double price;
    public Menu(){
        
    }
    //sets items
    public void setItem1(String a){
        item1 = a;
        
    }
    public void setItem2(String b){
        item2 = b;
        
    }
    public void setItem3(String c){
        item3 = c;
        
    }
    //gets items
    public String getItem1(){
        return item1;
    }
    public String getItem2(){
        return item2;
    }
    public String getItem3(){
        return item3;
    }

    
}
