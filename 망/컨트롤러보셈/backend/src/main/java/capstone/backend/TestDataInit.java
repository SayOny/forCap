package capstone.backend;

import capstone.backend.domain.Member;
import capstone.backend.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {

        //디폴트 데이터 추가
        Member member = new Member();
        member.setMemberId("orange");
        member.setPassword("orange13!");
        member.setName("배규리");

        memberRepository.save(member);
    }

}