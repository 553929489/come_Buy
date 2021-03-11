package com.example.comebuy;

import java.util.stream.Stream;

public class Food {
    private String food_name;                       //商品名字
    private int food_image;                         // 图片
    private String food_introduction;               //产品介绍
    private String food_month_much;                 //月销量
    private String food_price;                      //价格
    private int food_add;                    //加法的图片
    private int food_reduce;                        //减法的图片
    private String total;                             //总量
    public Food(String food_name, int food_image, String food_introduction,  String food_month_much, String food_price,int food_add, int food_reduce, String total){
        this.food_add = food_add;
        this.food_reduce = food_reduce;
        this.total = total;
        this.food_image = food_image;
        this.food_introduction = food_introduction;
        this.food_month_much = food_month_much;
        this.food_name = food_name;
        this.food_price = food_price;
    }

    public int getFood_add() {
        return food_add;
    }

    public int getFood_reduce() {
        return food_reduce;
    }

    public String getTotal() {
        return total;
    }

    public String getFood_price() {
        return food_price;
    }

    public String getFood_name() {
        return food_name;
    }

    public int getFood_image() {
        return food_image;
    }

    public String getFood_introduction() {
        return food_introduction;
    }

    public String getFood_month_much() {
        return food_month_much;
    }
}
