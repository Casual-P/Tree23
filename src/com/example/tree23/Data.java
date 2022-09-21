package com.example.tree23;

public class Data {
    private final int id;

    public Data(int id) {
        this.id = id;
    }

    public void disp() {
        System.out.print("/" + this.id);
    }

    public int getId() {
        return id;
    }
}
