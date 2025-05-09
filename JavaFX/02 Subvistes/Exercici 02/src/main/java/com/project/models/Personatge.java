package com.project.models;

import jakarta.json.JsonObject;

public class Personatge {
    private String nom;
    private String imatge;
    private String color;
    private String nomVideojoc;

    public Personatge(String nom, String imatge, String color, String nomVideojoc) {
        this.nom = nom;
        this.imatge = imatge;
        this.color = color;
        this.nomVideojoc = nomVideojoc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNomVideojoc() {
        return nomVideojoc;
    }

    public void setNomVideojoc(String nomVideojoc) {
        this.nomVideojoc = nomVideojoc;
    }

    public static Personatge fromJson(JsonObject object){
        String nom = object.getString("nom");
        String imatge = object.getString("imatge");
        String color = object.getString("color");
        String nomVideojoc = object.getString("nom_del_videojoc");
        return new Personatge(nom,imatge,color,nomVideojoc);
    }



    @Override
    public String toString() {
        return "Personatge{" +
                "nom='" + nom + '\'' +
                ", imatge='" + imatge + '\'' +
                ", color='" + color + '\'' +
                ", nomVideojoc='" + nomVideojoc + '\'' +
                '}';
    }
}
