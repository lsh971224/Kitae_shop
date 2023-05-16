package kr.inhatc.spring.cart.entity;

import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.utils.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY) //jpa하면 LAZY를해야 성능이 안떨어짐
    @JoinColumn(name = "member_id") //meber에 있는 기본키랑 조인
    private Member member;
}
