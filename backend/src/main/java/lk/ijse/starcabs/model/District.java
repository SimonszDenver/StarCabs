/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STARFLOWER
 */
@Entity
@Table(name = "District", catalog = "Cab", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d"),
//    @NamedQuery(name = "District.findByDistrictID", query = "SELECT d FROM District d WHERE d.districtID = :districtID"),
//    @NamedQuery(name = "District.findByName", query = "SELECT d FROM District d WHERE d.name = :name")})
public class District implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "districtID")
    private Integer districtID;
    @Size(max = 150)
    @Column(name = "name")
    private String name;

    public District() {
    }

    public District(Integer districtID) {
        this.districtID = districtID;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtID != null ? districtID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.districtID == null && other.districtID != null) || (this.districtID != null && !this.districtID.equals(other.districtID))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "edu.ijse.absd.cab.model.District[ districtID=" + districtID + " ]";
//    }
    @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.District[ districtID=" + districtID + " ]";
    }

}
