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
@Table(name = "userinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userinfo.findAll", query = "SELECT u FROM Userinfo u"),
    @NamedQuery(name = "Userinfo.findByPumpid", query = "SELECT u FROM Userinfo u WHERE u.pumpid = :pumpid"),
    @NamedQuery(name = "Userinfo.findByDate", query = "SELECT u FROM Userinfo u WHERE u.date = :date"),
    @NamedQuery(name = "Userinfo.findByPressure", query = "SELECT u FROM Userinfo u WHERE u.pressure = :pressure"),
    @NamedQuery(name = "Userinfo.findByTemperature", query = "SELECT u FROM Userinfo u WHERE u.temperature = :temperature"),
    @NamedQuery(name = "Userinfo.findByVolumeflow", query = "SELECT u FROM Userinfo u WHERE u.volumeflow = :volumeflow"),
    @NamedQuery(name = "Userinfo.findByRationalspeed", query = "SELECT u FROM Userinfo u WHERE u.rationalspeed = :rationalspeed")})
public class Userinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pumpid")
    private Integer pumpid;
    @Column(name = "date")
    private String date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pressure")
    private Double pressure;
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "volumeflow")
    private Double volumeflow;
    @Column(name = "rationalspeed")
    private Double rationalspeed;

    public Userinfo() {
    }

    public Userinfo(Integer pumpid) {
        this.pumpid = pumpid;
    }

    public Integer getPumpid() {
        return pumpid;
    }

    public void setPumpid(Integer pumpid) {
        this.pumpid = pumpid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getVolumeflow() {
        return volumeflow;
    }

    public void setVolumeflow(Double volumeflow) {
        this.volumeflow = volumeflow;
    }

    public Double getRationalspeed() {
        return rationalspeed;
    }

    public void setRationalspeed(Double rationalspeed) {
        this.rationalspeed = rationalspeed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pumpid != null ? pumpid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userinfo)) {
            return false;
        }
        Userinfo other = (Userinfo) object;
        if ((this.pumpid == null && other.pumpid != null) || (this.pumpid != null && !this.pumpid.equals(other.pumpid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userinfo[ pumpid=" + pumpid + " ]";
    }
    
}
