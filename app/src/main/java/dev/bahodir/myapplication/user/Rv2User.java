package dev.bahodir.myapplication.user;

public class Rv2User {
    private int img;
    private String tv1;
    private String tv2;
    private String title;

    public Rv2User(int img, String tv1, String tv2, String title) {
        this.img = img;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
