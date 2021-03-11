package com.example.comebuy.Message;

public class Message {
    private int image;
    private String title;
    private String time;
    private String end_message;

    public Message(int image, String title,String time, String end_message){
         this.image = image;
         this.title = title;
         this.time = time;
         this.end_message= end_message;

    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEnd_message() {
        return end_message;
    }

    public void setEnd_message(String end_message) {
        this.end_message = end_message;
    }
}
