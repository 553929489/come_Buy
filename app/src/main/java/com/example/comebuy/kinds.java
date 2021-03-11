package com.example.comebuy;

/**
 * Created by 张思远 on 2020/12/14.
 */

public class kinds {
    private int image;
    private String shopname;
    public kinds(int image, String shopname){
        this.image = image;
        this.shopname = shopname;
    }

    public int getImage() {
        return image;
    }

    public String getShopname() {
        return shopname;
    }
}
