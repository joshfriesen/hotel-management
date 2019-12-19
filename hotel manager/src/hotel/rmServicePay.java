/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * 
 */
public class rmServicePay extends Payment{
    public void setPrice(double p){
        price = p;
    }
    @Override
    public String getPrice(){
        String pay = formatter.format(price);
        return pay;
    }
}
