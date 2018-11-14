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
@Table(name = "service", catalog = "Cab", schema = "")
@XmlRootElement
public class Service implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceID")
    private Integer serviceID;
    @Column(name = "description")
    private String description;
    @Column(name = "ServiceDate")
    private Date ServiceDate;
    @JoinColumn(name = "vehicleTypeID", referencedColumnName = "vehicleTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicletype vehicleTypeID;      

    public Service() {
    }

    public Service(Integer serviceID, String description, Date ServiceDate, Vehicletype vehicleTypeID) {
        this.serviceID = serviceID;
        this.description = description;
        this.ServiceDate = ServiceDate;
        this.vehicleTypeID = vehicleTypeID;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getServiceDate() {
        return ServiceDate;
    }

    public void setServiceDate(Date ServiceDate) {
        this.ServiceDate = ServiceDate;
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
        hash += (serviceID != null ? serviceID.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
//        Extradaycharge other = (Extradaycharge) object;
//        Damage other = (Damage) object;
//        Insurence other = (Insurence) object;
        Service other = (Service) object;
        if ((this.serviceID == null && other.serviceID != null) || (this.serviceID != null && !this.serviceID.equals(other.serviceID))) {
            return false;
        }
        return true;
    }

    

    
            @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.service[ serviceID=" + serviceID + " ]";
    }      
}
