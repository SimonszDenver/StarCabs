/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author STARFLOWER
 */
@Entity
@Table(name = "Driver", catalog = "Cab", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findByDriverID", query = "SELECT d FROM Driver d WHERE d.driverID = :driverID"),
    @NamedQuery(name = "Driver.findByLicenceNumber", query = "SELECT d FROM Driver d WHERE d.licenceNumber = :licenceNumber"),
    @NamedQuery(name = "Driver.findByFullName", query = "SELECT d FROM Driver d WHERE d.fullName = :fullName"),
    @NamedQuery(name = "Driver.findByPreferredName", query = "SELECT d FROM Driver d WHERE d.preferredName = :preferredName"),
    @NamedQuery(name = "Driver.findByAddress", query = "SELECT d FROM Driver d WHERE d.address = :address"),
    @NamedQuery(name = "Driver.findByTelNo1", query = "SELECT d FROM Driver d WHERE d.telNo1 = :telNo1"),
    @NamedQuery(name = "Driver.findByTelNo2", query = "SELECT d FROM Driver d WHERE d.telNo2 = :telNo2"),
    @NamedQuery(name = "Driver.findByRating", query = "SELECT d FROM Driver d WHERE d.rating = :rating"),
    @NamedQuery(name = "Driver.findByActiveDate", query = "SELECT d FROM Driver d WHERE d.activeDate = :activeDate"),
    @NamedQuery(name = "Driver.findByStatus", query = "SELECT d FROM Driver d WHERE d.status = :status")})
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "driverID")
    private Integer driverID;
    @Size(max = 20)
    @Column(name = "licenceNumber")
    private String licenceNumber;
    @Size(max = 300)
    @Column(name = "fullName")
    private String fullName;
    @Size(max = 30)
    @Column(name = "preferredName")
    private String preferredName;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 16)
    @Column(name = "TelNo1")
    private String telNo1;
    @Size(max = 16)
    @Column(name = "TelNo2")
    private String telNo2;
    @Size(max = 30)
    @Column(name = "Rating")
    private String rating;
    @Column(name = "ActiveDate")
    @Temporal(TemporalType.DATE)
    private Date activeDate;
    @Size(max = 300)
    @Column(name = "Status")
    private String status;
    @Transient
    @OneToMany
    private List<Vehicle> vehicleList;

    public Driver() {
    }

    public Driver(Integer driverID) {
        this.driverID = driverID;
    }

    public Integer getDriverID() {
        return driverID;
    }

    public void setDriverID(Integer driverID) {
        this.driverID = driverID;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNo1() {
        return telNo1;
    }

    public void setTelNo1(String telNo1) {
        this.telNo1 = telNo1;
    }

    public String getTelNo2() {
        return telNo2;
    }

    public void setTelNo2(String telNo2) {
        this.telNo2 = telNo2;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (driverID != null ? driverID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.driverID == null && other.driverID != null) || (this.driverID != null && !this.driverID.equals(other.driverID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ijse.absd.cab.model.Driver[ driverID=" + driverID + " ]";
    }

}
