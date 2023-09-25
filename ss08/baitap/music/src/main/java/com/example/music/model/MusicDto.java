package com.example.music.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicDto implements Validator {
    private int id;
    private String nameMusic;
    private String artist;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto)target;

        if (musicDto.getNameMusic().equals("")) {
            errors.rejectValue("nameMusic", null, "Tên bài hát không được bỏ trống !");
        } else if (!musicDto.getNameMusic().matches("^[a-zA-Z0-9\\s]{1,800}$")) {
            errors.rejectValue("nameMusic", null, "Không thể chứa kí tự đặc biệt và tối đa 800 kí tự");
        }
        if (musicDto.getArtist().equals("")) {
            errors.rejectValue("artist", null, "Nghệ sĩ thể hiện không được bỏ trống !");
        } else if (!musicDto.getArtist().matches("^[a-zA-Z0-9\\s]{1,300}$")) {
            errors.rejectValue("artist", null, "Không thể chứa kí tự đặc biệt và tối đa 300 kí tự");
        }
        if (musicDto.getCategory().equals("")) {
            errors.rejectValue("category", null, "Thể loại nhạc không được bỏ trống");
        } else if (!musicDto.getCategory().matches("[a-zA-Z,]{1,1000}")) {
            errors.rejectValue("category", null, "Không thể chứa kí tự đặc biệt và tối đa 1000 kí tự");
        }
    }
}
