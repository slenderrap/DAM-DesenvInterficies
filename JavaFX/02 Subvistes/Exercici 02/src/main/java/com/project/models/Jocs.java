package com.project.models;

import jakarta.json.JsonObject;

public class Jocs {
    private String nom;
    private int any;
    private String tipus;
    private String descripcio;
    private String imatge;

    public Jocs(String nom, int any, String tipus, String descripcio, String imatge) {
        this.nom = nom;
        this.any = any;
        this.tipus = tipus;
        this.descripcio = descripcio;
        this.imatge = imatge;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public static Jocs fromJson(JsonObject object){
        String nom = object.getString("nom");
        int any = object.getInt("any");
        String tipus = object.getString("tipus");
        String descripcio = object.getString("descripcio");
        String imatge = object.getString("imatge");
        return new Jocs(nom,any,tipus,descripcio,imatge);
    }

    @Override
    public String toString() {
        return "Jocs{" +
                "nom='" + nom + '\'' +
                ", any=" + any +
                ", tipus='" + tipus + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", imatge='" + imatge + '\'' +
                '}';
    }
}
