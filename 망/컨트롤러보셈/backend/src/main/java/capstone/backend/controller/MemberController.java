package capstone.backend.controller;

import capstone.backend.domain.Member;
import capstone.backend.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @PostMapping("/add")
    public String save(@Valid @RequestBody Member member, BindingResult result){
        if (result.hasErrors()){
            return "error!";
        }
        memberRepository.save(member);
        return "save member: " + member.getMemberId();
    }
}
