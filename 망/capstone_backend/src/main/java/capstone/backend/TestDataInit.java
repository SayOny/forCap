package capstone.backend;

import capstone.backend.domain.Category;
import capstone.backend.domain.Member;
import capstone.backend.domain.Study;
import capstone.backend.repository.MemberRepository;
import capstone.backend.repository.StudyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

import static capstone.backend.domain.Category.*;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository memberRepository;
    private final StudyRepository studyRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        List<Category> list = new ArrayList<>();
        list.add(IT_PROGRAMMING);
        list.add(IT);
        list.add(CAREER);
        //디폴트 데이터 추가
        Member member = new Member();
        member.setAge(23L);
        member.setSex(1L);
        member.setEmail("32202018@dankook.ac.kr");
        member.setInterest(list);
        member.setBirth(LocalDate.of(2001, 11, 13));
        member.setMemberId("orange");
        member.setPassword("orange13!");
        member.setName("배규리");
        memberRepository.save(member);
        //디폴트 데이터 추가 2
        Member member2 = new Member();
        member2.setAge(1L);
        member2.setSex(0L);
        member2.setEmail("rbflrbfl@naver.com");
        member2.setInterest(list);
        member2.setBirth(LocalDate.of(2000, 11, 11));
        member2.setMemberId("rbfl");
        member2.setPassword("1234");
        member2.setName("귤귤");
        memberRepository.save(member2);

        // 스터디1 데이터 추가
        Study study1 = new Study();
        study1.setStudyName("rbfl의 데이터베이스 스터디");
        study1.setCategory(IT);
        study1.setLeader(member);
        studyRepository.save(study1);

        // 스터디2 데이터 추가
        Study study2 = new Study();
        study2.setStudyName("rbfl의 spring 스터디");
        study2.setCategory(IT_PROGRAMMING);
        study2.setLeader(member);
        studyRepository.save(study2);

        // 스터디3 데이터 추가
        Study study3 = new Study();
        study3.setStudyName("rbfl의 직업 스터디");
        study3.setCategory(CAREER);
        study3.setLeader(member);
        studyRepository.save(study3);
    }

}