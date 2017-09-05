/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ruhi ÇELİK
 */
@Entity
@Table(name = "gorev")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gorev.findAll", query = "SELECT g FROM Gorev g"),
    @NamedQuery(name = "Gorev.findById", query = "SELECT g FROM Gorev g WHERE g.id = :id"),
    @NamedQuery(name = "Gorev.findByDeger", query = "SELECT g FROM Gorev g WHERE g.deger = :deger")})
public class Gorev implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "deger")
    private String deger;

    public Gorev() {
    }

    public Gorev(Integer id) {
        this.id = id;
    }

    public Gorev(Integer id, String deger) {
        this.id = id;
        this.deger = deger;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeger() {
        return deger;
    }

    public void setDeger(String deger) {
        this.deger = deger;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gorev)) {
            return false;
        }
        Gorev other = (Gorev) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Gorev[ id=" + id + " ]";
    }
    
}