package com.QuanLySV.demo.controller;

import com.QuanLySV.demo.entity.Lop;
import com.QuanLySV.demo.entity.MonHoc;
import com.QuanLySV.demo.entity.SinhVien;
import com.QuanLySV.demo.repository.IMonHocRep;
import com.QuanLySV.demo.services.LopService;
import com.QuanLySV.demo.services.MonHocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/monhoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public String showAllLop(Model model){
        List<MonHoc> dsMonHoc = monHocService.getAllMon();
        model.addAttribute("dsMonHoc",dsMonHoc);
        return "monhoc/list";
    }
    @GetMapping("/add")
    public String showAllAddForm(Model model){
        model.addAttribute("monhoc",new MonHoc());
        return "monhoc/add";
    }
    @PostMapping("/add")
    public String addLop(@Valid @ModelAttribute("monhoc")MonHoc monHoc, BindingResult result){
        if(result.hasErrors()){
            return "monhoc/add";
        }
        monHocService.addMon(monHoc);
        return "redirect:/monhoc";
    }
    @GetMapping("/delete/{id}")
    public String deleteLop(@PathVariable("id") long id){
        monHocService.deleteMon(id);
        return "redirect:/monhoc";
    }
    @GetMapping("/timkiem")
    public String showAllLMonHocTimKiem(Model model,String key){
        List<MonHoc> dsMonHoc = monHocService.listMonHoc(key);
        model.addAttribute("dsMonHoc", dsMonHoc);
        return "monhoc/timkiem";
    }
    @GetMapping("/edit/{id}")
    public String editMon(@PathVariable("id") int id, Model model){
        MonHoc monHoc = monHocService.getMonById(id);
        model.addAttribute("monhoc",monHoc);
        return "monhoc/edit";
    }
    @PostMapping("/edit/{id}")
    public String EditLop( @Valid @ModelAttribute("monhoc") MonHoc editMonHoc,BindingResult result){
        if(result.hasErrors()){
            return "monhoc/edit";
        }
        monHocService.updateMon(editMonHoc);
        return "redirect:/monhoc";
    }


}
