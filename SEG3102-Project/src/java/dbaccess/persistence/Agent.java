/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess.persistence;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="Agent")
public class Agent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aid;
    @OneToMany
    private Collection<UserAccount> accounts;

    public Agent() {
        accounts = new ArrayList<>();
    }
    
    public Long getId() {
        return aid;
    }

    public void setId(Long id) {
        this.aid = id;
    }
    
    public Collection<UserAccount> getAccounts(){
        return accounts;
    }
    
    public void setAccount(Collection<UserAccount> accounts){
        this.accounts = accounts;
    }
    
    public void addAccount(UserAccount account){
        accounts.add(account);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbaccess.persistence.Agent[ id=" + aid + " ]";
    }
    
}
