package kr.inhatc.spring.item.dto;

import kr.inhatc.spring.item.entity.Item;
import kr.inhatc.spring.utils.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemFormDto extends BaseEntity {
    private Long id; //상품 코드
    @NotBlank(message = "상품명은 필수 항목입니다.")
    private String itemNm; //상품 이름
    @NotNull(message = "가격은 필수 항목입니다.")
    private int price;  //상품 가격
    @NotNull(message = "재고는 필수 항목입니다.")
    private int stockNumber; //재고 수량
    @NotBlank(message = "상품 설명은 필수 항목입니다.")
    private String itemDetail; //상품 상세 설명
    private String itemSellStatus; //상품 상태

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();


    // DTO -> ENTITY
    public Item createItem(){
        return modelMapper.map(this, Item.class);
    }
    // Entity -> DTO
    public static ItemFormDto of(Item item){
        return modelMapper.map(item, ItemFormDto.class);
    }
}
