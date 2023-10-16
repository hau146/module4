package com.example.thi_module_4.dto;

import com.example.thi_module_4.model.DanhMuc;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


public class TinTucDto implements Validator {

    private int id;
    private String tieuDe;
    private String noiDung;
    private String ngayDang;
    private String phongVien;
    @ManyToOne
    @JoinColumn(name = "danhmuc_id", referencedColumnName = "id")
    private DanhMuc danhMuc;

    public TinTucDto() {
    }

    public TinTucDto(int id, String tieuDe, String noiDung, String ngayDang, String phongVien, DanhMuc danhMuc) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDang = ngayDang;
        this.phongVien = phongVien;
        this.danhMuc = danhMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TinTucDto tinTucDto = (TinTucDto) target;
        LocalDate localDate = LocalDate.now();
        if (tinTucDto.ngayDang != null){
            localDate = LocalDate.parse(tinTucDto.ngayDang);
        }
        if (tinTucDto.tieuDe.equals("")) {
            errors.rejectValue("tieuDe", null, "Tiêu đề không được để trống!");
        }
        if (tinTucDto.noiDung.equals("")) {
            errors.rejectValue("noiDung", null, "Nội dung không được để trống!");
        }

        if (tinTucDto.ngayDang == null) {
            errors.rejectValue("ngayDang", null, "Ngày đăng không được để trống!");
        } else if (localDate.getDayOfYear() > LocalDate.now().getDayOfYear()) {
            errors.rejectValue("ngayDang", null, "Ngày đăng phải nhỏ hơn hoặc bằng ngày hiện tại!");
        }

        if (tinTucDto.phongVien.equals("")) {
            errors.rejectValue("phongVien", null, "Tên phóng viên không được để trống!");
        }
        if (tinTucDto.danhMuc == null) {
            errors.rejectValue("danhMuc", null, "Danh mục không được để trống!");
        }
    }
}
