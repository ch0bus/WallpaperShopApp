package wallpapershopapp.shop;

import java.time.LocalDate;
import java.util.ArrayList;

public class Shop {
    String shopName;
    String managerName;
    LocalDate dateBirth;
    String phoneShop;
    String addressShop;
    static ArrayList<Proceeds> proceeds;
    public Shop(){}
    public Shop( String shopN,
            String managerN,
            LocalDate dateB,
            String phone,
            String address
            ){
    shopName = shopN;
    managerName = managerN;
    dateBirth = dateB;
    phoneShop = phone;
    addressShop = address;
   }
    public String getShopName(){ return shopName; }
    public String getManagerName(){ return managerName; }
    public LocalDate getDateBirth(){ return dateBirth; }
    public String getPhoneShop(){ return phoneShop; }
    public String getAddressShop(){ return addressShop; }
    
    public void setFirstName(String name){ shopName = name; }
    public void setLastName(String name){ managerName = name; }
    public void setDateBirth(LocalDate date){ dateBirth = date; }
    public void setPhoneEmployee(String phone){ phoneShop = phone; }
    public void setAddressShop(String address){ addressShop = address; }
    
    public void addReceipt( LocalDate date, int number, double amount ){
        
        //Proceeds newProceeds = new Proceeds(date,amount);        
        //proceeds = new ArrayList<Proceeds>();
        //proceeds.add(newProceeds);
        
    }
    
    public int getNumberOfReceipt(){ return proceeds.size(); }
    
    public void removeLastReceipt(){ proceeds.remove(proceeds.size()-1); }    
   
}
