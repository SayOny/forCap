package capstone.backend.controller;

import capstone.backend.domain.*;
import capstone.backend.dto.PostingDto;
import capstone.backend.service.PostingService;
import capstone.backend.service.StreamService;
import capstone.backend.service.StudyService;
import capstone.backend.session.SessionConst;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final PostingService postingService;
    private final StudyService studyService;
    private final StreamService streamService;

    @GetMapping("/test")
    public String test(
            @SessionAttribute(name= SessionConst.LOGIN_MEMBER, required = true)
            Member loginMember){
        if (loginMember==null){
            return "fail session";
        }
        return "success, member name:"+loginMember.getName()+"category:"+loginMember.getInterest();

    }
////////마이페이지
    // 마이페이지에서 회원 정보 불러올 때 회원정보 업데이트
    @GetMapping("/profile")
    public Member profile(
            @SessionAttribute(name= SessionConst.LOGIN_MEMBER, required = true)
            Member loginMember){
        if (loginMember==null){
            return null ;
        }
        return loginMember;
    }

    /////////// 홈페이지
    // 홈페이지에서 내학습
//    @GetMapping("/my/stream")
//    public List<Stream> myStream(
//            @SessionAttribute(name= SessionConst.LOGIN_MEMBER, required = true)
//            Member loginMember){
//        if (loginMember==null){
//            return null ;
//        }
//        return streamService.findByMember(loginMember);
//    }

    // 홈페이지에서 내 스터디 불러오기
    @GetMapping("/my/study")
    public List<MemberStudy> myStudy(
            @SessionAttribute(name= SessionConst.LOGIN_MEMBER, required = true)
            Member loginMember){
        if (loginMember==null){
            return null ;
        }
        return loginMember.getStudyList();
    }

//    // 홈페이지에서 스터디 모집글 불러오기
//    @GetMapping("/view/posting")
//    public List<Posting> allPosting(){
//        return postingService.findAll();
//    }
//
////////// 스터디 모집
    // 스터디 전체목록
    @GetMapping("/view/study")
    public List<Study> allStudy(){
        return studyService.findAll();
    }
//
//    // 스터 카테고리 별로 찾기
//    @GetMapping("/view/{category}")
//    public List<Study> studyByCategory(@PathVariable("category") String category){
//        Category strToCategory = Enum.valueOf(Category.class, category);
//        return studyService.findByCategory(strToCategory);
//    }
//
///////// 스터디 상세 (다른 부분은 스터디 객체에서 가져오거나 위의 api에서 가져올 수 있을 것 같아서)
//    @GetMapping("/{studyId}/stream")
//    public List<Stream> selectedStudy(@PathVariable("study") Long studyId){
//        Study study = studyService.findById(studyId);
//        return streamService.findByStudy(study);
//}
//
//
//////// 글쓰기
//    @PostMapping("/posting")
//    public void writePosting(@Valid @RequestBody PostingDto dto) {
//        postingService.write(dto.getTitle(), dto.getBody(), dto.getStudyName());
//        return ;
//    }




}
