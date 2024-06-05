package com.QuanLySV.demo.services;

import com.QuanLySV.demo.entity.Lop;
import com.QuanLySV.demo.entity.MonHoc;
import com.QuanLySV.demo.repository.IMonHocRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonHocService {
    @Autowired
    private IMonHocRep IMonHocRep;
    public List<MonHoc> getAllMon(){
        return IMonHocRep.findAll();
    }
    public MonHoc getMonById(long id){
        return IMonHocRep.findById(id).orElse(null);
    }
    public void addMon(MonHoc monHoc){
        IMonHocRep.save(monHoc);
    }
    public void deleteMon(long id){
        IMonHocRep.deleteById(id);
    }
    public void updateMon(MonHoc monHoc){
        IMonHocRep.save(monHoc);
    }
    public List<MonHoc> listMonHoc(String tenMon){
        return IMonHocRep.findAll().stream().filter(x -> x.getTenMon().toLowerCase().contains(tenMon.toLowerCase())).collect(Collectors.toList());
    }
}
