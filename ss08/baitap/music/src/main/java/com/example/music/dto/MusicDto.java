package com.example.music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MusicDto {
    private int id;
    @NotBlank(message = "Tên bài hát không được bỏ trống !")
    @Min(1)
    @Max(800)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]$")
    private String nameMusic;
    @NotBlank(message = "Tên nghệ sĩ không được bỏ trống !")
    @Min(1)
    @Max(300)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]$")
    private String artist;
    @NotBlank(message = "Thể loại nhạc không được bỏ trống !")
    @Min(1)
    @Max(1000)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]$")
    private String category;

    public MusicDto() {
    }

    public MusicDto(int id, String nameMusic, String artist, String category) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.artist = artist;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
