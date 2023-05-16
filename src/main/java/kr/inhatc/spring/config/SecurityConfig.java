package kr.inhatc.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration //메모리에 위에 설정 파일이라고 선언하는거
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //htt.csrf().disable();
        http.formLogin()
                .loginPage("/member/login") //내가 정한 로그인창띄우기
                .defaultSuccessUrl("/") //로그인이 성공하면 루트 홈페이지로
                .usernameParameter("email") //타임리프 html에 있는 로그인 폼 name으로
                .failureUrl("/member/login/error") //로그인 실패시 에러
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/");
        //접근권한을 하긴했는데 get으로 주소를 입력하면 들어가는걸 방지시키는 코드
        http.authorizeRequests()
                .mvcMatchers("/css/**","js/**","/img/**").permitAll() //css 이런 공통되는걸 모든사람한테 해준다.
                .mvcMatchers("/","/member/**","/item/**","/auth/**").permitAll() //member,item애들한테 루트에 들어오는걸 다허용
                .mvcMatchers("/admin/**").hasRole("ADMIN") //권힌이 어드민인 애들만 들어올수있음
                .anyRequest().authenticated(); //인증을 받은 사람들만 들어올수있게
        http.exceptionHandling() //권힌이 없는데 막 치고 들어올수있는걸 방지하기위하여
                .authenticationEntryPoint(new CustomEntryPoint());

        return http.build();
    }
    @Bean //비밀번호 보안을 위한 객체를 만들어줌
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
