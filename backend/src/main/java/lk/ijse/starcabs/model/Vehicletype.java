/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author STARFLOWER
 */
@Entity
@Table(name = "Vehicletype", catalog = "Cab", schema = "")
@XmlRootElement
public class Vehicletype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vehicleTypeID")
    private Integer vehicleTypeID;
    @Size(max = 10)
    @Column(name = "fuelType")
    private String fuelType;
    @Size(max = 20)
    @Column(name = "typeName")
    private String typeName;
    @Transient
    @OneToMany(mappedBy = "vehicleTypeID", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Extramileagecharge> extramileagechargeList;
    @OneToMany(mappedBy = "vehicleTypeID", fetch = FetchType.LAZY)
    @Transient
    private List<Waitingtimecharge> waitingtimechargeList;
    @OneToMany(mappedBy = "vehicleTypeID", fetch = FetchType.LAZY)
    @Transient
    private List<Extradaycharge> extradaychargeList;
//    @Transient
//    @OneToMany(mappedBy = "vehicleTypeID", fetch = FetchType.LAZY)
//    private List<Packages> packagesList;
//    @Transient
//    @OneToMany(mappedBy = "vehicleTypeID", fetch = FetchType.LAZY)
//    private List<Vehicle> vehicleList;

    public Vehicletype() {
    }

    public Vehicletype(Integer vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

    public Integer getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(Integer vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @XmlTransient
    public List<Extramileagecharge> getExtramileagechargeList() {
        return extramileagechargeList;
    }

    public void setExtramileagechargeList(List<Extramileagecharge> extramileagechargeList) {
        this.extramileagechargeList = extramileagechargeList;
    }

    @XmlTransient
    public List<Waitingtimecharge> getWaitingtimechargeList() {
        return waitingtimechargeList;
    }

    public void setWaitingtimechargeList(List<Waitingtimecharge> waitingtimechargeList) {
        this.waitingtimechargeList = waitingtimechargeList;
    }

    @XmlTransient
    public List<Extradaycharge> getExtradaychargeList() {
        return extradaychargeList;
    }

    public void setExtradaychargeList(List<Extradaycharge> extradaychargeList) {
        this.extradaychargeList = extradaychargeList;
    }

//    @XmlTransient
//    public List<Packages> getPackagesList() {
//        return packagesList;
//    }
//
//    public void setPackagesList(List<Packages> packagesList) {
//        this.packagesList = packagesList;
//    }
//
//    @XmlTransient
//    public List<Vehicle> getVehicleList() {
//        return vehicleList;
//    }
//
//    public void setVehicleList(List<Vehicle> vehicleList) {
//        this.vehicleList = vehicleList;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleTypeID != null ? vehicleTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicletype)) {
            return false;
        }
        Vehicletype other = (Vehicletype) object;
        if ((this.vehicleTypeID == null && other.vehicleTypeID != null) || (this.vehicleTypeID != null && !this.vehicleTypeID.equals(other.vehicleTypeID))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "edu.ijse.absd.cab.model.Vehicletype[ vehicleTypeID=" + vehicleTypeID + " ]";
//    }
    @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.Vehicletype[ vehicleTypeID=" + vehicleTypeID + " ]";
    }

}
