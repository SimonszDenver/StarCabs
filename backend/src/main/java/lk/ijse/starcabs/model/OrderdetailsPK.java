/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author STARFLOWER
 */
@Embeddable
public class OrderdetailsPK implements Serializable {

    private Packages packages;
    private Orders orders;
    private Vehicle vehicle;

    @ManyToOne
    @JsonBackReference
    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }

    @ManyToOne
    @JsonBackReference
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JsonBackReference
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderdetailsPK that = (OrderdetailsPK) o;

        if (packages != null ? !packages.equals(that.packages) : that.packages != null) {
            return false;
        }
        if (orders != null ? !orders.equals(that.orders) : that.orders != null) {
            return false;
        }
        if (vehicle != null ? !vehicle.equals(that.vehicle) : that.vehicle != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result;
        result = (packages != null ? packages.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        return result;
    }

}
