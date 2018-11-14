/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author STARFLOWER
 */
@Entity
@Table(name = "Orders")
public class Orders implements Serializable {

    private Integer orderID;
    private String times;
    private Date orderDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal advanced;
    private List<Orderdetails> orderdetailsList = new ArrayList<Orderdetails>();
    private Customer customerID;

    public Orders() {
    }

    public Orders(Integer orderID) {
        this.orderID = orderID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderID", unique = true, nullable = false)
    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @Column(name = "times")
    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    @Column(name = "orderDate")
    @Temporal(TemporalType.DATE)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "advanced")
    public BigDecimal getAdvanced() {
        return advanced;
    }

    public void setAdvanced(BigDecimal advanced) {
        this.advanced = advanced;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pk.orders", fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<Orderdetails> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<Orderdetails> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    @JoinColumn(name = "customerID", referencedColumnName = "customerID")
    @ManyToOne(fetch = FetchType.LAZY)
    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "edu.ijse.absd.cab.model.Orders[ orderID=" + orderID + " ]";
//    }
    @Override
    public String toString() {
        return "edu.ijse.semfinal.starcab.model.Orders[ orderID=" + orderID + " ]";
    }

}
