/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbaccess.persistence.Customer;
import dbaccess.persistence.User;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Cole
 */
@Named(value = "userData")
@SessionScoped
public class UserData implements Serializable {
    private String username;
    private String password;
    private String givenName;
    private String lastName;
    private String email;
    private String type;
    private double maxRent;
    private User user;
    private String addStatus;
    private List<User> lookupResults;
 
    /**
     * Creates a new instance of UserData
     */
    public UserData() {
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the givenName
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * @param givenName the givenName to set
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return the maxRent
     */
    public double getMaxRent() {
        return maxRent;
    }

    /**
     * @param maxRent the maxRent to set
     */
    public void setMaxRent(double maxRent) {
        this.maxRent = maxRent;
    }
    
    public String getAddStatus() {
        return addStatus;
    }

    public void setAddStatus(String addStatus) {
        this.addStatus = addStatus;
    }

    public void setLookupResults(List<User> results) {
        this.lookupResults = results;
    }
    
    public List<User> getLookupResults() {
        return lookupResults;
    }
    // show results if any
    public boolean getShowResults() {
        return (lookupResults != null) && !lookupResults.isEmpty();
    }
    // show message if no result
    public boolean getShowMessage() {
        return (lookupResults != null) && lookupResults.isEmpty();
    }

    public User getUser() {
       return user;
    }
    
    public void setUser(User user){
        this.user = user;
        this.email = user.getUserAccount().getEmail();
        this.givenName = user.getUserAccount().getGivenName();
        this.lastName = user.getUserAccount().getLastName();
        if (user instanceof Customer){
            this.type = "customer";
            this.maxRent = user.getMaxRent();
        } else {
            this.type = "owner";
        }
        this.username = user.getUserAccount().getUsername();
        this.password = user.getUserAccount().getPassword();
    }
    
    public void logout(){
        user = null;
        type = null;
        username = null;
        password = null;
        givenName = null;
        lastName = null;
        email = null;
        lookupResults = null;
        maxRent = 0;
        addStatus = null;
    }
}
