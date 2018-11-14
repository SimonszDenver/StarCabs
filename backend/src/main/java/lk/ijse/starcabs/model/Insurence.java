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
@Table(name = "insurence", catalog = "Cab", schema = "")
@XmlRootElement
public class Insurence implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "insurenceID")
    private Integer insurenceID;
    @Column(name = "description")
    private String description;
    @Column(name = "insurenceDate")
    private Date insurenceDate;
    @JoinColumn(name = "vehicleTypeID", referencedColumnName = "vehicleTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicletype vehicleTypeID;     

    public Insurence() {
    }

    public Insurence(Integer insurenceID, String description, Date insurenceDate, Vehicletype vehicleTypeID) {
        this.insurenceID = insurenceID;
        this.description = description;
        this.insurenceDate = insurenceDate;
        this.vehicleTypeID = vehicleTypeID;
    }

    public Integer getInsurenceID() {
        return insurenceID;
    }

    public void setInsurenceID(Integer insurenceID) {
        this.insurenceID = insurenceID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInsurenceDate() {
        return insurenceDate;
    }

    public void setInsurenceDate(Date insurenceDate) {
        this.insurenceDate = insurenceDate;
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
        hash += (insurenceID != null ? insurenceID.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insurence)) {
            return false;
        }
//        Extradaycharge other = (Extradaycharge) object;
//        Damage other = (Damage) object;
        Insurence other = (Insurence) object;
        if ((this.insurenceID == null && other.insurenceID != null) || (this.insurenceID != null && !this.insurenceID.equals(other.insurenceID))) {
            return false;
        }
        return true;
    }


        @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.insurence[ insurenceID=" + insurenceID + " ]";
    }    
}
