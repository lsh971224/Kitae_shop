package kr.inhatc.spring.thymeleaf.controller;

import kr.inhatc.spring.item.dto.ItemFormDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
@Slf4j
public class ThymeleafController {
    @GetMapping("/ex1")
    public String ex1(Model model){
        model.addAttribute("data", "안녕하세요");
        return "/thymeleaf/ex1";
    }

    @GetMapping("/ex2")
    public String ex2(Model model) {
        ItemFormDto itemDto = new ItemFormDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());
        model.addAttribute("itemDto", itemDto);
        return "/thymeleaf/ex2";
    }
    @GetMapping(value = {"/ex3","/ex4"})
    public void ex3(Model model) {
        List<ItemFormDto> list = new ArrayList<>();
        for(int i=0; i<=10;i++){
            ItemFormDto itemDto = new ItemFormDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품1"+i);
            itemDto.setPrice(10000*i);
            itemDto.setRegTime(LocalDateTime.now());
            list.add(itemDto);
        }

        model.addAttribute("list", list);
    }
    @GetMapping("/ex5")
    public String ex5(@RequestParam("param1") String p1, String param2,Model model){
        log.info("============>" + p1 + "," + param2);
        model.addAttribute("param1", p1);
        model.addAttribute("param2", param2);
        return "/thymeleaf/ex5";
    }
    @GetMapping(value={"/ex6","/ex7"})
    public void ex6(){

    }


}
