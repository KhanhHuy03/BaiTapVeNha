package com.QuanLySV.demo.controller;

import com.QuanLySV.demo.entity.Lop;
import com.QuanLySV.demo.entity.MonHoc;
import com.QuanLySV.demo.entity.SinhVien;
import com.QuanLySV.demo.services.MonHocService;
import com.QuanLySV.demo.services.SvService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/sinhvien")

public class SinhVienController {

    @Autowired
    private SvService svService;

//    @Autowired
//    private MonHocService monHocService;

    @GetMapping
    public String showAllSv(Model model){
        List<SinhVien> dsSv = svService.getAllSv();
        model.addAttribute("dsSv",dsSv);
        return "sinhvien/list";
    }

    @GetMapping("/dsSv/{id}")
    public String showSv(Model model, @PathVariable("id") int id){
        List<SinhVien> dsSv = svService.findSv(id);
        model.addAttribute("dsSv",dsSv);
        return "sinhvien/list_sv";
    }

    @GetMapping("/add")
    public String AddSv(Model model){
//        List<MonHoc> danhSachMonHoc = monHocService.getAllMon();
        model.addAttribute("sinhvien",new SinhVien());
//        model.addAttribute("danhSachMonHoc", danhSachMonHoc);
        return "sinhvien/add";
    }
    @PostMapping("/add")
    public String addLop(@Valid @ModelAttribute("sinhvien")SinhVien sinhvien, BindingResult result){
        if(result.hasErrors()){
            return "sinhvien/add";
        }

        svService.addSv(sinhvien);
        return "redirect:/sinhvien";
    }
    @GetMapping("/edit/{id}")
    public String editLop(@PathVariable("id") int id, Model model){
        SinhVien sinhvien = svService.getSvById(id);
        model.addAttribute("sinhvien",sinhvien);
        return "sinhvien/edit";
    }
    @PostMapping("/edit/{id}")
    public String EditLop( @Valid @ModelAttribute("sinhvien") SinhVien editedBook,BindingResult result){
        if(result.hasErrors()){
            return "sinhvien/edit";
        }
        svService.updateSv(editedBook);
        return "redirect:/sinhvien";
    }
    @GetMapping("/delete/{id}")
    public String deleteLop(@PathVariable("id") String id){
        svService.deleteSv(id);
        return "redirect:/sinhvien";
    }
    @GetMapping("/timkiem")
    public String showAllLSvTimKiem(Model model,String key){
        List<SinhVien> dsSv = svService.findSVId(key);
        model.addAttribute("dsSv", dsSv);
        return "sinhvien/timkiem";
    }
}
