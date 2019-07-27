package com.kolomyiaapp.android.places;

public class Item {
    private String Name;
    private String Description;
    private int Photo;
    private String Coordinates;
    private int[] IMGSlider;

    public Item(String name, String description, String coordinates, int photo, int[] slider) {
        Name = name;
        Description = description;
        Photo = photo;
        Coordinates = coordinates;
        IMGSlider = slider;
    }

    public Item() {
    }

    //Getter
    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getCoordinates() {
        return Coordinates;
    }

    public int getPhoto() {
        return Photo;
    }

    public int[] getIMGSlider() {
        return IMGSlider;
    }

    //Setter
    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCoordinates(String coordinates) {
        Coordinates = coordinates;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public void setIMGSlider(int[] IMGSlider) {
        this.IMGSlider = IMGSlider;
    }
}
