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

/**
 *
 * @author Simon
 */
@Entity
public class Owner extends User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "owner")
    protected Collection<Property> properties;
    
}
