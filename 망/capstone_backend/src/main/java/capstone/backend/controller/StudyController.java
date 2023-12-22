package capstone.backend.controller;

import capstone.backend.domain.Member;
import capstone.backend.domain.Study;
import capstone.backend.dto.LoginDto;
import capstone.backend.dto.StudyDto;
import capstone.backend.dto.StudyInfoDto;
import capstone.backend.service.StudyService;
import capstone.backend.session.SessionConst;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StudyController {
    private final StudyService studyService;

//    @GetMapping("/name")
//    public String studyName(@Valid @RequestBody StudyInfoDto dto){
//        Study study = studyService.findByStudyId(dto.getId());
//        return study.getStudyName();
//    }
//
//    @GetMapping("/category")
//    public String studyCategory(@Valid @RequestBody StudyInfoDto dto){
//        Study study = studyService.findByStudyId(dto.getId());
//        return study.getCategory().toString();
//    }
//
//    @GetMapping("/members")
//    public String studyMembers(@Valid @RequestBody StudyInfoDto dto){
//        Study study = studyService.findByStudyId(dto.getId());
//        return study.getLeader().getName();
//    }
@PostMapping("/new")
public ResponseEntity<String> save(@Valid @RequestBody StudyDto dto,
                                   BindingResult result,
                                   HttpServletRequest request){
    if (result.hasErrors()) {
        return new ResponseEntity<>("result error", HttpStatus.BAD_REQUEST);
    }
    HttpSession session = request.getSession(false);
    if (session==null){
        return new ResponseEntity<>("no session", HttpStatus.BAD_REQUEST);
    }

    // 스터디를 개설하려는 사람(스터디장: 현재 로그인되어 있는 사람)
    Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
    if(member ==null){
        return new ResponseEntity<>("no member", HttpStatus.BAD_REQUEST);
    }
    Study study = studyService.save(dto, member);

    //스터디 개설에 성공한 경우
    return new ResponseEntity<>("Success study save", HttpStatus.BAD_REQUEST);
}

    /**
     * 최근에 개설된 스터디 상위 15개 리스트
     */
    @GetMapping("/recruit")
    public Page<Study> recentStudy(@PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Study> studies = studyService.recentStudy(pageable);
        return studies;
    }



    /**
     * 스터디 아이디를 PathVariable로 주면 스터디를 찾아 스터디 객체를 반환
     */
    @GetMapping("/study/{id}")
    public ResponseEntity<Study> findByStudyId(@PathVariable("id") Long id){
        Study study = studyService.findByStudyId(id);
        return ResponseEntity.status(HttpStatus.OK).body(study);
    }

    /**
     * 스터디 아이디를 PathVariable로 주면 스터디를 찾아 멤버를(지금은 리더만) 반환
     */
    @GetMapping("/members/{id}")
    public String studyMembers(@PathVariable("id") Long id){
        Study study = studyService.findByStudyId(id);
        return study.getLeader().getName();
    }

    /**
     * 카테고리를 PathVariable로 주면 스터디를 찾아 스터디 페이지를 반환
     */
    @GetMapping("/{category}")
    public Page<Study> findByCategory(@PathVariable("category") String category,
                                      @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Study> study = studyService.findByStudyCategory(category, pageable);
        return study;
    }



    @GetMapping("/my")
    public Page<Study> myStudyList(
            @SessionAttribute(name= SessionConst.LOGIN_MEMBER, required = true)
            Member loginMember, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        if (loginMember==null){
            return null;
        }
        Page<Study> studyList = studyService.findStudyListByMember(loginMember, pageable);
        return studyList;
    }



}
