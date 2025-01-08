package com.project.models;

import jakarta.json.JsonObject;
public class Consoles {
    private String nom;
    private String data;
    private String procesador;
    private String color;
    private int venudes;
    private String imatge;

    public Consoles(String nom, String data, String procesador, String color, int venudes, String imatge) {
        this.nom = nom;
        this.data = data;
        this.procesador = procesador;
        this.color = color;
        this.venudes = venudes;
        this.imatge = imatge;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVenudes() {
        return venudes;
    }

    public void setVenudes(int venudes) {
        this.venudes = venudes;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public static Consoles fromJson(JsonObject object){
        String nom = object.getString("nom");
        String data = object.getString("data");
        String procesador = object.getString("procesador");
        String color = object.getString("color");
        int venudes = object.getInt("venudes");
        String imatge = object.getString("imatge");

        return new Consoles(nom,data,procesador,color,venudes,imatge);
    }





    @Override
    public String toString() {
        return "Consoles{" +
                "nom='" + nom + '\'' +
                ", data='" + data + '\'' +
                ", procesador='" + procesador + '\'' +
                ", color='" + color + '\'' +
                ", venudes=" + venudes +
                ", imatge='" + imatge + '\'' +
                '}';
    }
}


