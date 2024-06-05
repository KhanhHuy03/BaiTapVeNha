package com.QuanLySV.demo.services;

import com.QuanLySV.demo.entity.Lop;
import com.QuanLySV.demo.repository.ILopRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LopService {
    @Autowired
    private ILopRep lopRep;

    public List<Lop> getAllLop(){
        return lopRep.findAll();
    }
    public Lop getLopById(long id){
        return lopRep.findById(id).orElse(null);
    }
    public void addLop(Lop lop){
        lopRep.save(lop);
    }
    public void deleteLop(long id){
        lopRep.deleteById(id);
    }
    public void updateLop(Lop lop){
        lopRep.save(lop);
    }
    public List<Lop> listLop(String tenLop){
        return lopRep.findAll().stream().filter(x -> x.getTenLop().toLowerCase().contains(tenLop.toLowerCase())).collect(Collectors.toList());
    }
}
