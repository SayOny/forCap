package capstone.backend.service;

import capstone.backend.domain.Member;
import capstone.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    /**
     * 입력받은 아이디와 비번이 일치하면 member객체를 return
     */
    public Member login(String loginId, String password){
        Optional<Member> login = memberRepository.findByLogInId(loginId);
        return login.filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
