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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
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
    
    public static User getUser(EntityManager em, String username) {
        try{            
            Query query = em.createQuery("Select u From User u, UserAccount ua where ua.username = :username AND u.account = ua");
            query.setParameter("username", username);
            return (User) performQuery(query).get(0);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static boolean newProperty(EntityManager em, UserTransaction utx, PropertyData propdata, Owner owner){
        try{
            utx.begin();
            Property nprop = new Property();
            //nprop.setId(propdata.getId());
            nprop.setType(propdata.getType());
            nprop.setAddress(propdata.getAddress());
            nprop.setLocation(propdata.getLocation());
            nprop.setNumBathrooms(propdata.getNumBathrooms());
            nprop.setNumBedrooms(propdata.getNumBedrooms());
            nprop.setNumOtherRooms(propdata.getNumOtherRooms());
            nprop.setRent(propdata.getRent());
            nprop.setActive(true);
            nprop.setOwner(owner);
            utx.commit();
            return true;
        } catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean addToVisitingList(EntityManager em, UserTransaction utx, Customer customer, Property property){
        try{
            utx.begin();
            customer.addVisit(property);
            utx.commit();
            return true;
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex){
            ex.printStackTrace();
        }  
        return false;
    }
    
    public static List viewProperties(EntityManager em, Owner owner){
        try{            
            Query query = em.createQuery("Select p From Property p where p.owner = :owner");
            query.setParameter("owner", owner);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static boolean newAccount(EntityManager em, UserTransaction utx, UserData userData, Agent agent){
        try{
            utx.begin();
            UserAccount naccount = new UserAccount();
            //naccount.setId(userData.getId());
            naccount.setUsername(userData.getUsername());
            naccount.setPassword(userData.getPassword());
            naccount.setEmail(userData.getEmail());
            naccount.setGivenName(userData.getGivenName());
            naccount.setLastName(userData.getLastName());
            long time = System.currentTimeMillis();
            naccount.setCreationDate(new Date(time));
            naccount.setCreationTime(new Time(time));
            naccount.setActive(true);
            naccount.setUser(userData.getType(), Double.parseDouble(userData.getMaxRent()));
            agent.addAccount(naccount);
            em.persist(naccount);
            utx.commit();
            return true;
        } catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean deleteAccount(EntityManager em, UserTransaction utx, UserAccount account){
        try{
            utx.begin();
            account.setActive(false);
            utx.commit();
            return true;
        } catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean deleteProperty(EntityManager em, UserTransaction utx, Property property){
        try{
            utx.begin();
            property.setActive(false);
            utx.commit();
            return true;
        } catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean login(EntityManager em, String username, String password){
        try{      
            UserAccount user = new UserAccount();
            Query query = em.createQuery("Select u From UserAccount u "
                    + "where u.username = :username AND u.password = :password");
            query.setParameter(":username", username);
            query.setParameter(":password", password);
            user = (UserAccount) performQuery(query).get(0);
            return true;
        } catch(IllegalArgumentException e){}
        return false;
    }
    
    public static List searchPropertiesByLocation(EntityManager em, String location){
        try{            
            Query query = em.createQuery("Select p From Property p "
                    + "where p.location = :location");
            query.setParameter(":locaton", location);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static List searchPropertiesByType(EntityManager em, String type){
        try{            
            Query query = em.createQuery("Select p From Property p "
                    + "where p.type = :type");
            query.setParameter(":type", type);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static List searchPropertiesByBedRooms(EntityManager em, int bedRooms){
        try{            
            Query query = em.createQuery("Select p From Property p "
                    + "where p.numBedrooms = :bedRooms");
            query.setParameter(":bedRooms", bedRooms);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static List searchPropertiesByBathRooms(EntityManager em, int bathRooms){
        try{            
            Query query = em.createQuery("Select p From Property p "
                    + "where p.numBathrooms = :bathRooms");
            query.setParameter(":bathRooms", bathRooms);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static List searchPropertiesByOtherRooms(EntityManager em, int otherRooms){
        try{            
            Query query = em.createQuery("Select p From Property p "
                    + "where p.numOtherRooms = :otherRooms");
            query.setParameter(":otherRomos", otherRooms);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static List searchPropertiesByMinRent(EntityManager em, double minRent){
        try{            
            Query query = em.createQuery("Select p From Property p "
                    + "where p.rent >= :minRent");
            query.setParameter(":minRent", minRent);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static List searchPropertiesByMaxRent(EntityManager em, double maxRent){
        try{            
            Query query = em.createQuery("Select p From Property p "
                    + "where p.rent <= :maxRent");
            query.setParameter(":maxRent", maxRent);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static boolean updateAccount(EntityManager em, UserTransaction utx, UserAccount account, UserData userData){
        try{
            utx.begin();
            //account.setId(userData.getId());
            account.setUsername(userData.getUsername());
            account.setPassword(userData.getPassword());
            account.setEmail(userData.getEmail());
            account.setGivenName(userData.getGivenName());
            account.setLastName(userData.getLastName());
            account.setActive(true);
            account.setUser(userData.getType(), Double.parseDouble(userData.getMaxRent()));
            utx.commit();
            return true;
        } catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean updateProperty(EntityManager em, UserTransaction utx, Property property, PropertyData propertyData){
        try{
            utx.begin();
            //property.setId(propertyData.getId());
            property.setType(propertyData.getType());
            property.setAddress(propertyData.getAddress());
            property.setLocation(propertyData.getLocation());
            property.setNumBathrooms(propertyData.getNumBathrooms());
            property.setNumBedrooms(propertyData.getNumBedrooms());
            property.setNumOtherRooms(propertyData.getNumOtherRooms());
            property.setRent(propertyData.getRent());
            utx.commit();
            return true;
        } catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static List viewAccount(EntityManager em, UserAccount account){
        try{
            String id = account.getId();
            Query query = em.createQuery("Select a From UserAccount a "
                    + "where a.userID = :id");
            query.setParameter(":id", id);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }
    
    public static List viewVisitingList(EntityManager em, Customer customer){
        try{
            String id = customer.getId();
            Query query = em.createQuery("Select c.visitingList From Customer c "
                    + "where c.id = :id");
            query.setParameter(":id", id);
            return performQuery(query);
        } catch(IllegalArgumentException e){}
        return null;
    }

    private static List performQuery(final Query query) {
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } 
        ArrayList results;
        results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }
    
}
