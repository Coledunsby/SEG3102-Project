/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Simon
 */
@Entity
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;
    private String type;
    private String address;
    private String location;
    private int numBedrooms;
    private int numBathrooms;
    private int numOtherRooms;
    private double rent;
    private boolean active;

    public Long getId() {
        return pid;
    }

    public void setId(Long id) {
        this.pid = id;
    }

    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public int getNumBedrooms(){
        return numBedrooms;
    }
    
    public void setNumBedrooms(int numBedrooms){
        this.numBedrooms = numBedrooms;
    }
    
    public int getNumBathrooms(){
        return numBathrooms;
    }
    
    public void setNumBathrooms(int numBathrooms){
        this.numBathrooms = numBathrooms;
    }
    
    public int getNumOtherRooms(){
        return numOtherRooms;
    }
    
    public void setNumOtherRooms(int numOtherRooms){
        this.numOtherRooms = numOtherRooms;
    }
    
    public double getRent(){
        return rent;
    }
    
    public void setRent(double rent){
        this.rent = rent;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbaccess.persistence.Property[ id=" + pid + " ]";
    }
    
}
