package kr.inhatc.spring.member.service;


import kr.inhatc.spring.item.entity.Item;
import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor // 컨트롤러 서비스에서는 써도 되는데 테스트하는데서는 Autowired로 해야됨
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        validateDuplicate(member);
        return memberRepository.save(member);
    }

    private void validateDuplicate(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember!=null){
            throw new IllegalStateException("이미 등록된 사용자입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            throw new UsernameNotFoundException("해당 사용자가 없습니다." + email);
        }
        log.info("=========================> loadUserByUsername"+member);
        return User.builder().username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
