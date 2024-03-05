package com.example.daaproject;

public class RecyclerModel {
    String objectName;
    String objectWeight;
    String objectProfit;
    int image;

    public RecyclerModel(String objectName, String objectWeight, String objectProfit, int image) {
        this.objectName = objectName;
        this.objectWeight = objectWeight;
        this.objectProfit = objectProfit;
        this.image = image;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getObjectWeight() {
        return objectWeight;
    }

    public String getObjectProfit() {
        return objectProfit;
    }

    public int getImage() {
        return image;
    }
}
