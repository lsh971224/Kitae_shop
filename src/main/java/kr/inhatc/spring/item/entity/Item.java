package kr.inhatc.spring.item.entity;

import kr.inhatc.spring.item.constant.ItemSellStatus;
import kr.inhatc.spring.utils.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "my_item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id; //상품 코드
    @Column(nullable = false,length = 50)
    private String itemNm; //상품 이름
    @Column(nullable = false)
    private int price;  //상품 가격
    @Column(nullable = false, name = "number")
    private int stockNumber; //재고 수량
    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품 상세 설명
    private ItemSellStatus itemSellStatus;
}
