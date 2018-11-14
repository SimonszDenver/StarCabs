package lk.ijse.starcabs.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package edu.ijse.semfinal.starcab.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STARFLOWER
 */
@Entity
@Table(name = "repair", catalog = "Cab", schema = "")
@XmlRootElement
public class Repair implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "repairID")
    private Integer repairID;
    @Column(name = "description")
    private String description;
    @Column(name = "repairDate")
    private Date repairDate;
    @JoinColumn(name = "vehicleTypeID", referencedColumnName = "vehicleTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicletype vehicleTypeID;     

    public Repair(Integer repairID, String description, Date repairDate, Vehicletype vehicleTypeID) {
        this.repairID = repairID;
        this.description = description;
        this.repairDate = repairDate;
        this.vehicleTypeID = vehicleTypeID;
    }

    public Repair() {
    }

    public Integer getRepairID() {
        return repairID;
    }

    public void setRepairID(Integer repairID) {
        this.repairID = repairID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Vehicletype getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(Vehicletype vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

@Override
    public int hashCode() {
        int hash = 0;
        hash += (repairID != null ? repairID.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repair)) {
            return false;
        }
//        Extradaycharge other = (Extradaycharge) object;
//        Damage other = (Damage) object;
//        Insurence other = (Insurence) object;
        Repair other = (Repair) object;
        if ((this.repairID == null && other.repairID != null) || (this.repairID != null && !this.repairID.equals(other.repairID))) {
            return false;
        }
        return true;
    }

    
            @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.repair[ repairID=" + repairID + " ]";
    }  
}
