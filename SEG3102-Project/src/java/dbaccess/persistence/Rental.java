/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Simon
 */
@Entity
@Table(name="Rental")
public class Rental implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rid;
    private String email;
    private double rentAmount;
    private Date rentalDate;
    private Time rentalTime;
    @OneToMany(mappedBy = "rental")
    protected Collection<Tenant> tenants;

    public Long getId() {
        return rid;
    }

    public void setId(Long id) {
        this.rid = id;
    }
    
    public Collection<Tenant> getTenants(){
        return tenants;
    }
    
    public void setTenants(Collection<Tenant> tenants){
        this.tenants = tenants;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rental)) {
            return false;
        }
        Rental other = (Rental) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbaccess.persistence.Rental[ id=" + rid + " ]";
    }
    
}
