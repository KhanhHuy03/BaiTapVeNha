package com.QuanLySV.demo.services;

import com.QuanLySV.demo.entity.*;
import com.QuanLySV.demo.repository.ISinhVienRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SvService {
    @Autowired
    private ISinhVienRep sinhVienRep;

    public List<SinhVien> getAllSv(){
        return sinhVienRep.findAll();
    }
    public SinhVien getSvById(long id){
        return sinhVienRep.findById(id).orElse(null);
    }
    public void addSv(SinhVien sinhVien){
        sinhVienRep.save(sinhVien);
    }
    public void deleteSv(String id){
        sinhVienRep.deleteById(Long.valueOf(id));
    }
    public void updateSv(SinhVien sinhVien){
        sinhVienRep.save(sinhVien);
    }
    public List<SinhVien> findSv(int id){
        var sv = sinhVienRep.findAll().stream().filter(x -> x.getLop().getMaLop() == id).toList();
        return sv;
    }
    public List<SinhVien> findSVId(String tenSV){
        return sinhVienRep.findAll().stream().filter(x -> x.getHoTen().toLowerCase().contains(tenSV.toLowerCase())).collect(Collectors.toList());
    }
}
