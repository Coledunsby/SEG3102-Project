/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbaccess.persistence.Property;
import dbaccess.persistence.User;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cole
 */
@Named(value = "propertyData")
@RequestScoped
public class PropertyData {
    private String type;
    private String address;
    private String location;
    private int numBedrooms;
    private int numBathrooms;
    private int numOtherRooms;
    private int rent;
    private int minRent;
    private int maxRent;
    private Property property;
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
    public void setNumBedrooms(String numBedrooms) {
        this.numBedrooms = Integer.parseInt(numBedrooms);
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
    public void setNumBathrooms(String numBathrooms) {
        this.numBathrooms = Integer.parseInt(numBathrooms);
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
    public void setNumOtherRooms(String numOtherRooms) {
        this.numOtherRooms = Integer.parseInt(numOtherRooms);
    }
    
    /**
     * @return the rent
     */
    public int getRent() {
        return rent;
    }

    /**
     * @param rent the rent to set
     */
    public void setRent(String rent) {
        this.rent = Integer.parseInt(rent);
    }
    
    public Property getProperty(){
        return property;
    }
    
    public void setProperty(Property property){
        this.property = property;
    }
    
    public void setLookupResults(List<Property> results) {
        this.lookupResults = results;
    }
    
    public List<Property> getLookupResults() {
        return lookupResults;
    }
    
    public int getMinRent(){
        return minRent;
    }
    
    public void setMinRent(int minRent){
        this.minRent = minRent;
    }
    
    public int getMaxRent(){
        return maxRent;
    }
    
    public void setMaxRent(int maxRent){
        this.maxRent = maxRent;
    }
}
