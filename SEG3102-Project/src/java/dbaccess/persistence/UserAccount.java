/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Simon
 */
@Entity
@Table(name="UserAccount")
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userID;
    private String username;
    private String password;
    private String givenName;
    private String lastName;
    private String email;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    private Time creationTime;
    private boolean active;
    @OneToOne
    private User user;

    public String getId() {
        return userID;
    }

    public void setId(String id) {
        this.userID = id;
    }

    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getGivenName(){
        return givenName;
    }
    
    public void setGivenName(String givenName){
        this.givenName = givenName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public Date getCreationDate(){
        return creationDate;
    }
    
    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }
    
    public Time getCreationTime(){
        return creationTime;
    }
    
    public void setCreationTime(Time creationTime){
        this.creationTime = creationTime;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(String user, double maxRent){
        if(user.equals("customer")){
            this.user = new Customer(this);
            this.user.setMaxRent(maxRent);
        } else{
            this.user = new Owner(this);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbaccess.persistence.UserAccount[ id=" + userID + " ]";
    }
    
}
