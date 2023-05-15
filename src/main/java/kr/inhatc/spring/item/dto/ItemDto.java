package kr.inhatc.spring.item.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {
    private Long id; //상품 코드
    private String itemNm; //상품 이름
    private int price;  //상품 가격
    private int stockNumber; //재고 수량
    private String itemDetail; //상품 상세 설명
    private LocalDateTime regTime; //등록 시간
    private LocalDateTime updateTime; //수정 시간
    private String itemSellStatus;
}
