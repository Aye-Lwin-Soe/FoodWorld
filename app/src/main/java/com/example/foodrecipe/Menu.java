package com.example.foodrecipe;

public class Menu {
    private int title;
    private String img;

    public Menu(String data_, int title, String img) {
        this.title = title;
        this.img = img;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
