/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Vehicle", catalog = "Cab", schema = "")
@XmlRootElement
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vehicleID")
    private Integer vehicleID;
    @Size(max = 20)
    @Column(name = "colour")
    private String colour;
    @Column(name = "seatCount")
    private Integer seatCount;
    @Size(max = 300)
    @Column(name = "status")
    private String status;
    @Size(max = 20)
    @Column(name = "available")
    private String available;
    @Size(max = 12)
    @Column(name = "regNo")
    private String regNo;
    @Size(max = 150)
    @Column(name = "district")
    private String district;
    @Size(max = 150)
    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "pk.vehicle", fetch = FetchType.LAZY)
    @Transient
    private List<Orderdetails> orderdetailsList = new ArrayList<Orderdetails>(0);
    @JoinColumn(name = "vehicleTypeID", referencedColumnName = "vehicleTypeID")
    //@Transient
    @ManyToOne
    private Vehicletype vehicleTypeID;
    //@Transient
    @JoinColumn(name = "driverID", referencedColumnName = "driverID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Driver driverID;

    public Vehicle() {
    }

    public Vehicle(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Integer getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Orderdetails> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<Orderdetails> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    public Vehicletype getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(Vehicletype vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

    public Driver getDriverID() {
        return driverID;
    }

    public void setDriverID(Driver driverID) {
        this.driverID = driverID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleID != null ? vehicleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.vehicleID == null && other.vehicleID != null) || (this.vehicleID != null && !this.vehicleID.equals(other.vehicleID))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "edu.ijse.absd.cab.model.Vehicle[ vehicleID=" + vehicleID + " ]";
//    }
    @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.Vehicle[ vehicleID=" + vehicleID + " ]";
    }

}
