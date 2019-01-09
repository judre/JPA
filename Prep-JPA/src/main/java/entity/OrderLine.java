/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name="OrderLines")
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int quantity;
    
    @ManyToOne
    private AOrder aOrder;

    public OrderLine(int quantity, AOrder AOrder) {
        this.quantity = quantity;
        this.aOrder = aOrder;
    }

    public OrderLine() {
    }

    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AOrder getAOrder() {
        return aOrder;
    }

    public void setAOrder(AOrder AOrder) {
        this.aOrder = AOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
}
