package kr.inhatc.spring.member.entity;

import kr.inhatc.spring.member.constant.Role;
import kr.inhatc.spring.member.dto.MemberFormDto;
import kr.inhatc.spring.utils.entity.BaseEntity;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String adderess;
    @Enumerated(EnumType.STRING)  //이넘 타입은 @Enumerated로 String으로 해줘야됨 꼭!
    private Role role;

    //DTO를 엔티티로 변환 시켜줘야됨
    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setAdderess(memberFormDto.getAddress());
        member.setEmail(memberFormDto.getEmail());
        member.setRole(Role.USER);
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        return member;
    }
}
