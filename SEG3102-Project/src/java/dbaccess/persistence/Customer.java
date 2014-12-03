/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Simon
 */
@Entity
@Table(name="Customer")
public class Customer extends User implements Serializable {
<<<<<<< HEAD
    @OneToOne
    protected Tenant tenant;
    protected static final long serialVersionUID = 1L;
    protected double maxRent;
    @OneToOne
=======
    @OneToOne(cascade = CascadeType.PERSIST)
    private Tenant tenant;
    private static final long serialVersionUID = 1L;
    private double maxRent;
    @OneToOne(cascade = CascadeType.PERSIST)
>>>>>>> 84cd1a1599e8dcb5a940eb2a049985404322fd78
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
