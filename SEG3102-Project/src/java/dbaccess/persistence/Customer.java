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
import javax.persistence.OneToOne;

/**
 *
 * @author Simon
 */
@Entity
public class Customer extends User implements Serializable {
    @OneToOne
    private Tenant tenant;
    private static final long serialVersionUID = 1L;
    private double maxRent;
    @OneToOne
    protected VisitingList visitingList;
    
    @Override
    public double getMaxRent(){
        return maxRent;
    }
    
    @Override
    public void setMaxRent(double maxRent){
        this.maxRent = maxRent;
    }
    
}
