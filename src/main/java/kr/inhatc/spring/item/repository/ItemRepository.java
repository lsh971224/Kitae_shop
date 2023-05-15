package kr.inhatc.spring.item.repository;

import kr.inhatc.spring.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long>, QuerydslPredicateExecutor<Item> {

    List<Item> findByItemNm(String ItemNm);  //findBy 다음ㅇ ㅔ붙는건 ITEM클래스에 변수이름인데 JAVA 네임 규칙을 준수해서 쓰는거 
    List<Item> findByItemNmOrItemDetail(String ItemNm,String ItemDetail); //findBy+변수이름+Or+변수이름
    @Query("select i from Item i where i.itemDetail like %:itemDetail% " +
            "order by i.price desc") //JPQL임
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

}
