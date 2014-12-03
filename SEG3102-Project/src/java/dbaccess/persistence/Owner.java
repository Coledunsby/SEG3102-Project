/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Simon
 */
@Entity
@Table(name="Owner")
public class Owner extends User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "owner")
    protected Collection<Property> properties;
    
    public Owner() {
        
    }
    
    public Owner(UserAccount account) {
        super(account);
    }
    
    public Collection<Property> getProperties(){
        return properties;
    }
    
    public void setProperties(Collection<Property> properties){
        this.properties = properties;
    }
    
    public void addProperty(Property property){
        properties.add(property);
    }
    
}
