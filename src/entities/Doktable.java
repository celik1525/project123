/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ruhi ÇELİK
 */
@Entity
@Table(name = "doktable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doktable.findAll", query = "SELECT d FROM Doktable d"),
    @NamedQuery(name = "Doktable.findByDocumentId", query = "SELECT d FROM Doktable d WHERE d.documentId = :documentId"),
    @NamedQuery(name = "Doktable.findByComments", query = "SELECT d FROM Doktable d WHERE d.comments = :comments"),
    @NamedQuery(name = "Doktable.findByPath", query = "SELECT d FROM Doktable d WHERE d.path = :path")})
public class Doktable implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DoktablePK doktablePK;
    @Basic(optional = false)
    @Column(name = "DocumentId")
    private int documentId;
    @Column(name = "Comments")
    private String comments;
    @Column(name = "path")
    private String path;

    public Doktable() {
    }

    public Doktable(DoktablePK doktablePK) {
        this.doktablePK = doktablePK;
    }

    public Doktable(DoktablePK doktablePK, int documentId) {
        this.doktablePK = doktablePK;
        this.documentId = documentId;
    }

    public DoktablePK getDoktablePK() {
        return doktablePK;
    }

    public void setDoktablePK(DoktablePK doktablePK) {
        this.doktablePK = doktablePK;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doktablePK != null ? doktablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doktable)) {
            return false;
        }
        Doktable other = (Doktable) object;
        if ((this.doktablePK == null && other.doktablePK != null) || (this.doktablePK != null && !this.doktablePK.equals(other.doktablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Doktable[ doktablePK=" + doktablePK + " ]";
    }
    
}
