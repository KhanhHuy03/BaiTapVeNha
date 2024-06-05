package com.QuanLySV.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;

import java.util.Set;

@Data
@Entity(name = "Lop")
@Table(name = "Lop")
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLop")
    private Integer maLop;

    @Size(min = 1, max = 7,message = "Tên Lớp 1-7 ký tự:")
    @NotNull(message="Tên Lớp Không Đc Để Trống !!!")
    @Column(name ="TenLop",length = 7)
    private String tenLop;

    @OneToMany(mappedBy = "lop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<SinhVien> sinhViens;

}
