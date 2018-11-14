package lk.ijse.starcabs.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package edu.ijse.semfinal.starcab.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "damage", catalog = "Cab", schema = "")
@XmlRootElement
public class Damage implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "damageID")
    private Integer damageID;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "vehicleTypeID", referencedColumnName = "vehicleTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicletype vehicleTypeID;  

    public Damage() {
    }

    public Damage(Integer damageID, String description, Vehicletype vehicleTypeID) {
        this.damageID = damageID;
        this.description = description;
        this.vehicleTypeID = vehicleTypeID;
    }

    public Integer getDamageID() {
        return damageID;
    }

    public void setDamageID(Integer damageID) {
        this.damageID = damageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (damageID != null ? damageID.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Damage)) {
            return false;
        }
//        Extradaycharge other = (Extradaycharge) object;
        Damage other = (Damage) object;
        if ((this.damageID == null && other.damageID != null) || (this.damageID != null && !this.damageID.equals(other.damageID))) {
            return false;
        }
        return true;
    }
    
        @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.Damage[ damageID=" + damageID + " ]";
    }
}
