/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STARFLOWER
 */
@Entity
@Table(name = "Waitingtimecharge", catalog = "Cab", schema = "")
@XmlRootElement
public class Waitingtimecharge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "waitingTimeChargeID")
    private Integer waitingTimeChargeID;
    @Column(name = "times")
    @Temporal(TemporalType.TIME)
    private Date times;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @JoinColumn(name = "vehicleTypeID", referencedColumnName = "vehicleTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicletype vehicleTypeID;

    public Waitingtimecharge() {
    }

    public Waitingtimecharge(Integer waitingTimeChargeID) {
        this.waitingTimeChargeID = waitingTimeChargeID;
    }

    public Integer getWaitingTimeChargeID() {
        return waitingTimeChargeID;
    }

    public void setWaitingTimeChargeID(Integer waitingTimeChargeID) {
        this.waitingTimeChargeID = waitingTimeChargeID;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        hash += (waitingTimeChargeID != null ? waitingTimeChargeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waitingtimecharge)) {
            return false;
        }
        Waitingtimecharge other = (Waitingtimecharge) object;
        if ((this.waitingTimeChargeID == null && other.waitingTimeChargeID != null) || (this.waitingTimeChargeID != null && !this.waitingTimeChargeID.equals(other.waitingTimeChargeID))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "edu.ijse.absd.cab.model.Waitingtimecharge[ waitingTimeChargeID=" + waitingTimeChargeID + " ]";
//    }
    @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.Waitingtimecharge[ waitingTimeChargeID=" + waitingTimeChargeID + " ]";
    }

}
