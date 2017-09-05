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
@Table(name = "employeeinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeeinfo.findAll", query = "SELECT e FROM Employeeinfo e"),
    @NamedQuery(name = "Employeeinfo.findByEmployeeid", query = "SELECT e FROM Employeeinfo e WHERE e.employeeid = :employeeid"),
    @NamedQuery(name = "Employeeinfo.findByName", query = "SELECT e FROM Employeeinfo e WHERE e.name = :name"),
    @NamedQuery(name = "Employeeinfo.findBySirname", query = "SELECT e FROM Employeeinfo e WHERE e.sirname = :sirname"),
    @NamedQuery(name = "Employeeinfo.findByAge", query = "SELECT e FROM Employeeinfo e WHERE e.age = :age"),
    @NamedQuery(name = "Employeeinfo.findByUsername", query = "SELECT e FROM Employeeinfo e WHERE e.username = :username"),
    @NamedQuery(name = "Employeeinfo.findByPassword", query = "SELECT e FROM Employeeinfo e WHERE e.password = :password"),
    @NamedQuery(name = "Employeeinfo.findByImage", query = "SELECT e FROM Employeeinfo e WHERE e.image = :image")})
public class Employeeinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeeid")
    private Integer employeeid;
    @Column(name = "name")
    private String name;
    @Column(name = "sirname")
    private String sirname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "image")
    private String image;

    public Employeeinfo() {
    }

    public Employeeinfo(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeeinfo)) {
            return false;
        }
        Employeeinfo other = (Employeeinfo) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employeeinfo[ employeeid=" + employeeid + " ]";
    }
    
}
