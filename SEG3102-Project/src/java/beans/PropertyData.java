/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbaccess.persistence.Property;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Cole
 */
@Named(value = "propertyData")
@SessionScoped
public class PropertyData implements Serializable {
    private String type;
    private String address;
    private String location;
    private int numBedrooms;
    private int numBathrooms;
    private int numOtherRooms;
    private double rent;
    private double minRent;
    private double maxRent;
    private Property property;
    private String addStatus;
    private List<Property> lookupResults;

    /**
     * Creates a new instance of UserData
     */
    public PropertyData() {
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the username to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     * @return the numBedrooms
     */
    public int getNumBedrooms() {
        return numBedrooms;
    }

    /**
     * @param numBedrooms the numBedrooms to set
     */
    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    /**
     * @return the numBathrooms
     */
    public int getNumBathrooms() {
        return numBathrooms;
    }

    /**
     * @param numBathrooms the numBathrooms to set
     */
    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }
    
    /**
     * @return the numOtherRooms
     */
    public int getNumOtherRooms() {
        return numOtherRooms;
    }

    /**
     * @param numOtherRooms the numOtherRooms to set
     */
    public void setNumOtherRooms(int numOtherRooms) {
        this.numOtherRooms = numOtherRooms;
    }
    
    /**
     * @return the rent
     */
    public double getRent() {
        return rent;
    }

    /**
     * @param rent the rent to set
     */
    public void setRent(double rent) {
        this.rent = rent;
    }
    
    public Property getProperty(){
        return property;
    }
    
    public void setProperty(Property property){
        this.property = property;
        this.type = property.getType();
        this.address = property.getAddress();
        this.location = property.getLocation();
        this.numBathrooms = property.getNumBathrooms();
        this.numBedrooms = property.getNumBedrooms();
        this.numOtherRooms = property.getNumOtherRooms();
        this.rent = property.getRent();
        this.addStatus = "";
    }
    
    public void setLookupResults(List<Property> results) {
        this.lookupResults = results;
    }
    
    public List<Property> getLookupResults() {
        return lookupResults;
    }
    
    public double getMinRent(){
        return minRent;
    }
    
    public void setMinRent(double minRent){
        this.minRent = minRent;
    }
    
    public double getMaxRent(){
        return maxRent;
    }
    
    public void setMaxRent(double maxRent){
        this.maxRent = maxRent;
    }
    
    public String getAddStatus() {
        return addStatus;
    }

    public void setAddStatus(String addStatus) {
        this.addStatus = addStatus;
    }
    
    public void reset() {
        this.property = null;
        this.type = null;
        this.address = null;
        this.location = null;
        this.numBathrooms = 0;
        this.numBedrooms = 0;
        this.numOtherRooms = 0;
        this.rent = 0;
        this.addStatus = null;
    }
}
