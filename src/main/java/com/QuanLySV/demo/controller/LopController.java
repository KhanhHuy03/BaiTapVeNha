package com.QuanLySV.demo.controller;

import com.QuanLySV.demo.entity.Lop;
import com.QuanLySV.demo.services.LopService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/lop")
public class LopController {
    @Autowired
    private LopService lopService;

    @GetMapping
    public String showAllLop(Model model){
        List<Lop> dsLop = lopService.getAllLop();
        model.addAttribute("dsLop",dsLop);
        return "lop/list";
    }

    @GetMapping("/add")
    public String showAllAddForm(Model model){
        model.addAttribute("lop",new Lop());
        return "lop/add";
    }
    @PostMapping("/add")
    public String addLop(@Valid @ModelAttribute("lop")Lop lop, BindingResult result){
        if(result.hasErrors()){
            return "lop/add";
        }
        lopService.addLop(lop);
        return "redirect:/lop";
    }

    @GetMapping("/delete/{id}")
    public String deleteLop(@PathVariable("id") int id){
        lopService.deleteLop(id);
        return "redirect:/lop";
    }

    @GetMapping("/edit/{id}")
    public String editLop(@PathVariable("id") int id, Model model){
        Lop lop = lopService.getLopById(id);
        model.addAttribute("lop",lop);
        return "lop/edit";
    }
    @PostMapping("/edit/{id}")
    public String EditLop( @Valid @ModelAttribute("lop") Lop editedBook,BindingResult result){
        if(result.hasErrors()){
            return "lop/edit";
        }
        lopService.updateLop(editedBook);
        return "redirect:/lop";
    }
    @GetMapping("/timkiem")
    public String showAllLopTimKiem(Model model,String tukhoa){
        List<Lop> dsLop = lopService.listLop(tukhoa);
        model.addAttribute("dsLop",dsLop);
        return "lop/timkiem";
    }


}
