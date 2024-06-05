package com.QuanLySV.demo.repository;

import com.QuanLySV.demo.entity.SinhVien;
import com.QuanLySV.demo.services.SvService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ISinhVienRep extends JpaRepository<SinhVien,Long> {


}
