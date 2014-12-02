/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import beans.UserData;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Simon
 */
public class DBHelper {
    public static UserAccount findUser(EntityManager em, String id){
        UserAccount u = em.find(UserAccount.class, id);
        return u;
    }
    
    private static List performQuery(final Query query){
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } 
        ArrayList<User> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }
    
    public static boolean addUser(EntityManager em, UserTransaction utx, UserData userData){
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
            return true;
        } catch(IllegalArgumentException | NotSupportedException | SystemException | RollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    
}
