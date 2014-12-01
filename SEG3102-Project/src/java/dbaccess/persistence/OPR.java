/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import beans.UserData;
import beans.PropertyData;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */


public class OPR implements Serializable{  

    /**
     * Creates a new instance of Lookup
     */
    public OPR() {
    }
    
    public void newProperty(EntityManager em, UserTransaction utx, PropertyData propdata){
        try{
            utx.begin();
            Property nprop = new Property();
            nprop.setId(propdata.getId());
            nprop.setType(propdata.getType());
            nprop.setAddress(propdata.getAddress());
            nprop.setLocation(propdata.getLocation());
            nprop.setNumBathrooms(propdata.getNumBathrooms);
            nprop.setNumBedrooms(propdata.getNumBedrooms);
            nprop.setNumOtherRooms(propdata.getNumOtherRooms);
            nprop.setRent(propdata.getRent);
            nprop.setActive(true);
        } catch(IllegalArgumentException | NotSupportedException | SystemException | RollbackException | SecurityException | IllegalStateException ex){
            ex.printStackTrace();
        }
    }
    
    public void addToVisitingList(Customer customer, Property property){
        
    }
    
    public void viewProperties(Owner owner){
        
    }
    
    public static boolean newAccount(EntityManager em, UserTransaction utx, UserData userData){
        try{
            utx.begin();
            UserAccount naccount = new UserAccount();
            naccount.setId(userData.getId());
            naccount.setUsername(userData.getUsername());
            naccount.setPassword(userData.getPassword());
            naccount.setEmail(userData.getEmail());
            naccount.setGivenName(userData.getGivenName());
            naccount.setLastName(userData.getLastName());
            long time = System.currentTimeMillis();
            naccount.setCreationDate(new Date(time));
            naccount.setCreationTime(new Time(time));
            naccount.setActive(true);
            naccount.setUser(userData.getType(), Double.parseDouble(userData.getmaxRent()));
            return true;
        } catch(IllegalArgumentException | NotSupportedException | SystemException | RollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public void deleteAccount(){
        
    }
    
    public void deleteProperty(Property property){
        
    }
    
    public void login(String username, String password){
        
    }
    
    public void logout(){
        
    }
    
    public void removeVisitingList(){
        
    }
    
    public void rentProperty(){
        
    }
    
    public void searchProperties(PropertyData propertyData){
        
    }
    
    public void updateAccount(){
        
    }
    
    public void updateProperty(Property property, PropertyData propertyData){
        
    }
    
    public void viewAccount(UserAccount account){
        
    }
    
    public void viewVisitHistory(UserAccount account){
        
    }
    
    public void viewVisitingList(){
        
    }
    
}
