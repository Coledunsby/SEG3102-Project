/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Simon
 */
@Entity
@Table(name="User")
@DiscriminatorValue("c")
public class Customer extends User implements Serializable {
    @OneToOne(cascade = CascadeType.PERSIST)
    private Tenant tenant;
    private static final long serialVersionUID = 1L;
    private double maxRent;
    @OneToOne(cascade = CascadeType.PERSIST)

    protected VisitingList visitingList = new VisitingList();

    public Customer() {
        
    }
    
    public Customer(UserAccount account) {
        super(account);
    }
    
    @Override
    public double getMaxRent(){
        return maxRent;
    }
    
    @Override
    public void setMaxRent(double maxRent){
        this.maxRent = maxRent;
    }
    
    public VisitingList getVisitingList(){
        return visitingList;
    }
    
    public void addVisit(Property property){
        visitingList.addProperty(property);
    }
    
}
