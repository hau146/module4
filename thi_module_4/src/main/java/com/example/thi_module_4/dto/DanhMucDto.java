package com.example.thi_module_4.dto;

import com.example.thi_module_4.model.TinTuc;

import javax.persistence.*;
import java.util.Set;


public class DanhMucDto {
    private int id;
    private String tenDanhMuc;
    @OneToMany(mappedBy = "danhMuc")
    private Set<TinTuc> tinTucs;

    public DanhMucDto() {
    }

    public DanhMucDto(String tenDanhMuc, Set<TinTuc> tinTucs) {
        this.tenDanhMuc = tenDanhMuc;
        this.tinTucs = tinTucs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public Set<TinTuc> getTinTucs() {
        return tinTucs;
    }

    public void setTinTucs(Set<TinTuc> tinTucs) {
        this.tinTucs = tinTucs;
    }
}
