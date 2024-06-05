package com.QuanLySV.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "MonHoc")
@Table(name = "MonHoc")
public class MonHoc {
    @Id
    @Column(name = "MaMon",length = 10)
    @Size(min = 1, max = 10,message = "Mã môn phải từ 1-10 ký tự")
    private String maMon;

    @Size(min = 5,max = 50, message = "Tên môn phải 5-50 ký tự")
    @Column(name = "TenMonHoc", length = 50)
    private String tenMon;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SinhVien_MonHoc",
            joinColumns = {@JoinColumn(name = "MaMon")},
            inverseJoinColumns = {@JoinColumn(name = "MSSV")}
    )
    private Set<SinhVien> sinhViens;
}
