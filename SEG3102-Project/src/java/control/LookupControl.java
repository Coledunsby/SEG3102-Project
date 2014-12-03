/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import beans.PropertyData;
import beans.UserData;
import dbaccess.persistence.Agent;
import dbaccess.persistence.Customer;
import dbaccess.persistence.OPR;
import dbaccess.persistence.Owner;
import dbaccess.persistence.Property;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Named(value = "lookupControl")
@RequestScoped
public class LookupControl implements Serializable{
    @Inject
    private PropertyData propertyData;
    @Inject
    private UserData userData;
    private Agent agent;
    @PersistenceContext
    EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    /**
     * Creates a new instance of lookupControl
     */
    public LookupControl() {
        agent = new Agent();
    }
    
    public String getUserType() {
        if (userData.getUser() != null){
            return userData.getType();
        } else {
            return "None";
        }
    }
    
    public void login() {
        if (OPR.login(em, userData.getUsername(), userData.getPassword())) {
            userData.setUser(OPR.getUser(em, userData.getUsername()));
            userData.setAddStatus("The User was successfully logged in.");
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LookupControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            userData.setAddStatus("User was not found.");
        }
    }
    
    public void logout() {        
        userData = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LookupControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addProperty(){
        if (userData.getUser() instanceof Owner) {
            OPR.newProperty(em, utx, propertyData, (Owner) userData.getUser());
        }
    }
    
    public void addVisitList(){
        if (userData.getUser() instanceof Customer){
            OPR.addToVisitingList(em, utx, (Customer) userData.getUser(), propertyData.getProperty());
        }
    }
    
    public void viewProperties(){
        if (userData.getUser() instanceof Owner){
            List<Property> results = OPR.viewProperties(em, (Owner) userData.getUser());            
            propertyData.setLookupResults(results);
        }
    }
    
    public void addAccount() {
        if (agent != null) {
            if (OPR.newAccount(em, utx, userData, agent)) {
                userData.setAddStatus("User created!");
            } else {
                userData.setAddStatus("Failed to create user.");
            }
        }
    }
    
    public void deleteProperty(){
        if (userData.getUser() instanceof Owner){
            OPR.deleteProperty(em, utx, propertyData.getProperty());
        }
    }
    
    public void updateProperty(){
        if (userData.getUser() != null){
            OPR.updateProperty(em, utx, propertyData.getProperty(), propertyData);
        }
    }
    
    public void viewAccount(){
        if (userData.getUser() != null){
            userData.setLookupResults(OPR.viewAccount(em, userData.getUser().getUserAccount()));
        }
    }
    
    public void viewVisitList(){
        if (userData.getUser() instanceof Customer){
            userData.setLookupResults(OPR.viewVisitingList(em, (Customer) userData.getUser()));
        }
    }
    
    public void lookupProperty(){
        List<Property> results = new ArrayList();
        if(!"".equals(propertyData.getLocation())){
            results = getPropertiesByLocation(em,propertyData);
        } else if(!"".equals(propertyData.getType())){
            results = getPropertiesByType(em,propertyData);
        } else if(propertyData.getNumBedrooms() != -1){
            results = getPropertiesByBedRooms(em,propertyData);
        } else if(propertyData.getNumBathrooms() != -1){
            results = getPropertiesByBathRooms(em,propertyData);
        } else if(propertyData.getNumOtherRooms() != -1){
            results = getPropertiesByOtherRooms(em,propertyData);
        } else if(propertyData.getMinRent() != -1){
            results = getPropertiesByMinRent(em,propertyData);
        } else if(propertyData.getMaxRent() != -1){
            results = getPropertiesByMaxRent(em,propertyData);
        }
        propertyData.setLookupResults(results);
    }
    
    private List<Property> getPropertiesByLocation(EntityManager em,PropertyData propertyData) {
       List<Property> allresults = OPR.searchPropertiesByLocation(em,propertyData.getLocation());
       if (allresults == null) return null;
       return checkResults(allresults,propertyData);          
    }
    
    private List<Property> getPropertiesByType(EntityManager em,PropertyData propertyData) {
       List<Property> allresults = OPR.searchPropertiesByType(em,propertyData.getType());
       if (allresults == null) return null;
       return checkResults(allresults,propertyData);          
    }
    
    private List<Property> getPropertiesByBedRooms(EntityManager em,PropertyData propertyData) {
       List<Property> allresults = OPR.searchPropertiesByBedRooms(em,propertyData.getNumBedrooms());
       if (allresults == null) return null;
       return checkResults(allresults,propertyData);          
    }
    
    private List<Property> getPropertiesByBathRooms(EntityManager em,PropertyData propertyData) {
       List<Property> allresults = OPR.searchPropertiesByBathRooms(em,propertyData.getNumBathrooms());
       if (allresults == null) return null;
       return checkResults(allresults,propertyData);          
    }
    
    private List<Property> getPropertiesByOtherRooms(EntityManager em,PropertyData propertyData) {
       List<Property> allresults = OPR.searchPropertiesByOtherRooms(em,propertyData.getNumOtherRooms());
       if (allresults == null) return null;
       return checkResults(allresults,propertyData);          
    }
    
    private List<Property> getPropertiesByMinRent(EntityManager em,PropertyData propertyData) {
       List<Property> allresults = OPR.searchPropertiesByMinRent(em,propertyData.getMinRent());
       if (allresults == null) return null;
       return checkResults(allresults,propertyData);          
    }
    
    private List<Property> getPropertiesByMaxRent(EntityManager em,PropertyData propertyData) {
       List<Property> allresults = OPR.searchPropertiesByMaxRent(em,propertyData.getMaxRent());
       if (allresults == null) return null;
       return checkResults(allresults,propertyData);          
    }
    
    private List<Property> checkResults(List<Property> allresults,PropertyData propertyData) {
        ArrayList<Property> results = new ArrayList<>();
        for (Property property: allresults) {
            if (property.matches(propertyData)) results.add(property);
        }
        return results;
    }
}
