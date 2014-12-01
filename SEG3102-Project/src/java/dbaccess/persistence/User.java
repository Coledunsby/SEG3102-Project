/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Simon
 */

@Entity
@Table(name="User")
@Inheritance(strategy=JOINED)
public class User implements Serializable{
    @Id
    private String id;
    @OneToOne(mappedBy = "user")
    protected UserAccount account;

    public void setMaxRent(double maxRent) {
    }
    
    public double getMaxRent(){
        return 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
