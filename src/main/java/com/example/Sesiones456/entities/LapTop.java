package com.example.Sesiones456.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LapTop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String fabricante;
    String modelo;
    Double ScreenSize;
    Double price;

    public LapTop() {
    }

    public LapTop(Long id, String fabricante, String modelo, Double screenSize, Double price) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        ScreenSize = screenSize;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getScreenSize() {
        return ScreenSize;
    }

    public void setScreenSize(Double screenSize) {
        ScreenSize = screenSize;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ScreenSize=" + ScreenSize +
                ", price=" + price +
                '}';
    }
}
