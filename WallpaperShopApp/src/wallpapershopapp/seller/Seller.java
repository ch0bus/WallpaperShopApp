package wallpapershopapp.seller;

import java.time.LocalDate;
import java.util.ArrayList;

public class Seller {
    static int counterOfSellers=0;
    String firstName;
    String lastName;
    String workPlace;
    String employeePosition;
    String employeeRank;
    LocalDate dateBirth;
    LocalDate dateEmpl;
    String phoneEmployee;
    String addressEmployee;
    static ArrayList<Receipt> receipt;
    public Seller(){}
    public Seller( String nameF,
            String nameL,
            String place,
            String pos,
            String rank,
            LocalDate dateB,
            LocalDate dateE,
            String phone,
            String address
            ){
    ++counterOfSellers;
    firstName = nameF;
    lastName = nameL;
    workPlace = place;
    employeePosition = pos;
    employeeRank = rank;
    dateBirth = dateB;
    dateEmpl = dateE;
    phoneEmployee = phone;
    addressEmployee = address;
   }
    public int getCounterOfSeller(){ return counterOfSellers; }
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getWorkPlace(){ return workPlace; }
    public String getEmployeePosition(){ return employeePosition; }
    public String getEmployeeRank(){ return employeeRank; }
    public LocalDate getDateBirth(){ return dateBirth; }
    public LocalDate getDateEmplpoee(){ return dateEmpl; }
    public String getPhoneEmployee(){ return phoneEmployee; }
    public String getAddressEmployee(){ return addressEmployee; }
    
    public void setFirstName(String name){ firstName = name; }
    public void setLastName(String name){ lastName = name; }
    public void setWorkPlace(String place){ workPlace = place; }
    public void setEmployeePosition(String pos){ employeePosition = pos; }
    public void setEmployeeRank(String rank){ employeeRank = rank; }
    public void setDateBirth(LocalDate date){ dateBirth = date; }
    public void setDateEmpl(LocalDate date){ dateEmpl = date; }
    public void setPhoneEmployee(String phone){ phoneEmployee = phone; }
    public void setAddressEmployee(String address){ addressEmployee = address; }
    
    public void addReceipt( LocalDate date, int number, double amount ){
        
        Receipt newReceipt = new Receipt(date,number,amount);
        
        receipt = new ArrayList<Receipt>();
        receipt.add(newReceipt);
        
    }
    
    public int getNumberOfReceipt(){
        return receipt.size();
    }
    
    public void removeLastReceipt(){
        receipt.remove(receipt.size()-1);
    }
    
   
}
