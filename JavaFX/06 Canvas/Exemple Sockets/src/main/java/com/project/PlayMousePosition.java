package com.project;

public class PlayMousePosition {
    private String clientId;
    private double x;
    private double y;
    private int row;
    private int col;

    public PlayMousePosition(String clientId, double x, double y, int row, int col) {
        this.clientId = clientId;
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
    }

    public String getClientId() {
        return clientId;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "ClientID: " + clientId + ", X: " + x + ", Y: " + y + ", Row: " + row + ", Col: " + col;
    }
}