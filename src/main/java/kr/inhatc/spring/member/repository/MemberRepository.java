package kr.inhatc.spring.member.repository;

import kr.inhatc.spring.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByEmail(String email);
}
