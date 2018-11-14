/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

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
@Table(name = "Extradaycharge", catalog = "Cab", schema = "")
@XmlRootElement
public class Extradaycharge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "extraDayChargeID")
    private Integer extraDayChargeID;
    @Column(name = "dayCount")
    private Integer dayCount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @JoinColumn(name = "vehicleTypeID", referencedColumnName = "vehicleTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicletype vehicleTypeID;

    public Extradaycharge() {
    }

    public Extradaycharge(Integer extraDayChargeID) {
        this.extraDayChargeID = extraDayChargeID;
    }

    public Integer getExtraDayChargeID() {
        return extraDayChargeID;
    }

    public void setExtraDayChargeID(Integer extraDayChargeID) {
        this.extraDayChargeID = extraDayChargeID;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
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
        hash += (extraDayChargeID != null ? extraDayChargeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extradaycharge)) {
            return false;
        }
        Extradaycharge other = (Extradaycharge) object;
        if ((this.extraDayChargeID == null && other.extraDayChargeID != null) || (this.extraDayChargeID != null && !this.extraDayChargeID.equals(other.extraDayChargeID))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "edu.ijse.absd.cab.model.Extradaycharge[ extraDayChargeID=" + extraDayChargeID + " ]";
//    }
    @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.Extradaycharge[ extraDayChargeID=" + extraDayChargeID + " ]";
    }
    
}
