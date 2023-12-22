package capstone.backend.repository;

import capstone.backend.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); //static사용
    private static long sequence = 0L;
    public Member save(Member member){
        member.setId(++sequence);
        log.info("save: member={}", member.getMemberId());
        store.put(member.getId(), member);
        return member;
    }

    //고유 ID로 회원 찾기
    public Member findById(Long id){
        return store.get(id);
    }

    //LoginId로 회원 찾기
    public Optional<Member> findByLogInId(String loginId){

        return findAll().stream()
                .filter(m -> m.getMemberId().equals(loginId))
                .findFirst();
    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}