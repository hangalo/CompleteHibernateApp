/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author desenvolvimento
 */
@Entity
@Table(name = "sales")
public class Sale implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;
    @Column(name = "qtd")
    private int qtd;

    @ManyToOne()
    @JoinColumn(name = "ID_OWNER")
    private User ownerOfSale;
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfSale")
    private Date dateOfSale;
    @Column(name = "total")
    private double totalOfSale;

    public Sale() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public User getOwnerOfSale() {
        return ownerOfSale;
    }

    public void setOwnerOfSale(User ownerOfSale) {
        this.ownerOfSale = ownerOfSale;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public double getTotalOfSale() {
        return totalOfSale;
    }

    public void setTotalOfSale(double totalOfSale) {
        this.totalOfSale = totalOfSale;
    }

    public void calculateTotalOfSale() {

        totalOfSale = getQtd() * getProduct().getPrice();
    }

    public boolean isProductOutOfStock() {
        return getProduct().isOutOfStock();
    }

}
