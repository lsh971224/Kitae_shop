package kr.inhatc.spring.item.controller;

import kr.inhatc.spring.item.dto.ItemFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {


    @GetMapping("/admin/item/new") //상품관리 주소
    public String itemForm(Model model){
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "/item/itemForm";
    }

}
