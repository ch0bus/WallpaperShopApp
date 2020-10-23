package wallpapershopapp.seller;

import java.time.LocalDate;

public class Receipt {
    LocalDate dateReceipt;
    int numberReceipt;
    double amountReceipt;
    public Receipt(LocalDate date, int number, double amount ){
        dateReceipt = date;
        numberReceipt = number;
        amountReceipt = amount;
    }
// getters
    public LocalDate getDateReceipt(){
        return dateReceipt;
    }
    public int getNumberReceipt(){
        return numberReceipt;
    }
    public double getAmountReceipt(){
        return amountReceipt;
    }
    // setters
    public void setDateReceipt(LocalDate date){
        dateReceipt = date;
    }
    public void setNumberReceipt(int number){
        numberReceipt = number;
    }
    public void setAmountReceipt(double amount){
        amountReceipt = amount;
    }    
}
