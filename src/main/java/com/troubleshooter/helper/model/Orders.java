package com.troubleshooter.helper.model;

public class Orders {

    private int id;
    private int userid;
    private String product;
    private String quantity;
    private String description;

    public Orders() {
    }

    public Orders(int id, int userid, String product, String quantity, String description) {
        this.id = id;
        this.userid = userid;
        this.product = product;
        this.quantity = quantity;
        this.description = description;
    }
}
