/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STARFLOWER
 */
@Entity
@Table(name = "OrderDetails")
@AssociationOverrides({
    @AssociationOverride(name = "pk.packages", joinColumns = @JoinColumn(name = "packageID")),
    @AssociationOverride(name = "pk.orders", joinColumns = @JoinColumn(name = "orderID")),
    @AssociationOverride(name = "pk.vehicle", joinColumns = @JoinColumn(name = "vehicleID"))})
public class Orderdetails implements Serializable {

    private OrderdetailsPK pk = new OrderdetailsPK();
    private BigDecimal discount;
    private Date arrivalDate;
    private Date dipatureDate;
    private String time1;
    private String time2;
    @Size(max = 300)
    private String origin;
    @Size(max = 300)
    private String destination;

    public Orderdetails() {
    }

    @EmbeddedId
    public OrderdetailsPK getPk() {
        return pk;
    }

    public void setPk(OrderdetailsPK pk) {
        this.pk = pk;
    }

    @Transient
    @JsonBackReference
    public Orders getOrders() {
        return getPk().getOrders();
    }

    public void setOrders(Orders orders) {
        getPk().setOrders(orders);
    }

    @Transient
    public Packages getPackages() {
        return getPk().getPackages();
    }

    public void setPackages(Packages packages) {
        getPk().setPackages(packages);
    }

    @Transient
    public Vehicle getVehicle() {
        return getPk().getVehicle();
    }

    public void setVehicle(Vehicle vehicle) {
        getPk().setVehicle(vehicle);
    }

    @Column(name = "discount")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Column(name = "arrivalDate")
    @Temporal(TemporalType.DATE)
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Column(name = "dipatureDate")
    @Temporal(TemporalType.DATE)
    public Date getDipatureDate() {
        return dipatureDate;
    }

    public void setDipatureDate(Date dipatureDate) {
        this.dipatureDate = dipatureDate;
    }

    @Column(name = "time1")
    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    @Column(name = "time2")
    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    @Column(name = "origin")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Orderdetails that = (Orderdetails) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

//    @Override
//    public String toString() {
//        return "edu.ijse.absd.cab.model.Orderdetails[ orderdetailsPK=" + pk + " ]";
//    }
    @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.Orderdetails[ orderdetailsPK=" + pk + " ]";
    }

}
