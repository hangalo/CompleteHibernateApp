/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapp.modelo;

import java.io.Serializable;

/**
 *
 * @author desenvolvimento
 */
public class Product implements Serializable{
    private int code;
    private String name;
    private int numberOfItens;
    private double price;

    public Product() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfItens() {
        return numberOfItens;
    }

    public void setNumberOfItens(int numberOfItens) {
        this.numberOfItens = numberOfItens;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.code;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }
    
    
    
    public String toString(){
    
    return String.valueOf(code);
    }
}
