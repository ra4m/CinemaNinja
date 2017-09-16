package com.example.raam.cinemaninja;


class Movie {

    private String name, description, director, image, url;
    private int number;

    public Movie (String name, String description, String director, int number, String image, String url) {
        this.name = name;
        this.description = description;
        this.director = director;
        this.number = number;
        this.image = image;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public int getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
