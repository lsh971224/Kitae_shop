package kr.inhatc.spring.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {


    @GetMapping("/admin/item/new") //상품관리 주소
    public String itemForm(){

        return "/item/itemForm";
    }
}
