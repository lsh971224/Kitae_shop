package kr.inhatc.spring.item.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.inhatc.spring.item.constant.ItemSellStatus;
import kr.inhatc.spring.item.entity.Item;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import kr.inhatc.spring.item.entity.*;
@SpringBootTest
@RequiredArgsConstructor
class ItemRepositoryTest {
    private final ItemRepository itemRepository;

    private final EntityManager em;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
    }
    public void createItemList(){
        for (int i = 1; i < 10; i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품 " + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명 " + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
        }
    }
    @Test
    @DisplayName("JPQL 테스트 쿼리")
    public void findByItemDetailTest() {
        createItemTest();
        List<Item> itemList = itemRepository.findByItemDetail("테스트");
        for (Item item : itemList) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("querydsl 테스트")
    public void querydslTest(){
        createItemList();
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

    }
}