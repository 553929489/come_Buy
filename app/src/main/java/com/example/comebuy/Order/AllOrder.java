package com.example.comebuy.Order;

public class AllOrder {
    private int shop_image  ;
    private String order_state;
    private int food_image ;

    private String food_all;
    private String  food_total;
    private String price_text;
    private String RMB_image;
    private String price;

     AllOrder(int shop_image, String order_state, int food_image , String food_all,
              String  food_total, String price_text, String RMB_image, String price){
         this.shop_image = shop_image;
         this.order_state = order_state;
         this.food_image = food_image;
         this.food_all = food_all;
         this.food_total= food_total;
         this.price_text = price_text;
         this.RMB_image = RMB_image;
         this.price = price;
     }

    public int getShop_image() {
        return shop_image;
    }

    public void setShop_image(int shop_image) {
        this.shop_image = shop_image;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public int getFood_image() {
        return food_image;
    }

    public void setFood_image(int food_image) {
        this.food_image = food_image;
    }

    public String getFood_all() {
        return food_all;
    }

    public void setFood_all(String food_all) {
        this.food_all = food_all;
    }

    public String getFood_total() {
        return food_total;
    }

    public void setFood_total(String food_total) {
        this.food_total = food_total;
    }

    public String getPrice_text() {
        return price_text;
    }

    public void setPrice_text(String price_text) {
        this.price_text = price_text;
    }

    public String getRMB_image() {
        return RMB_image;
    }

    public void setRMB_image(String RMB_image) {
        this.RMB_image = RMB_image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
