package capstone.backend.service;

import capstone.backend.domain.Category;
import capstone.backend.domain.Member;
import capstone.backend.domain.Study;
import capstone.backend.dto.StudyDto;
import capstone.backend.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
//@Transactional(readOnly = true)
//@Service
public class StudyService {
    @Autowired
    private StudyRepository studyRepository;

    public Study save(StudyDto dto, Member member){
        Study study = new Study();
        study.setStudyName(dto.getName());
        study.setLeader(member);
        study.setCategory(Category.valueOf(dto.getCategory()));
        studyRepository.save(study);
        return study;
    }
    /**
     * 스터디 모집 - 페이징 처리
     */
    public Page<Study> recentStudy(Pageable pageable){
        return studyRepository.findAll(pageable);
    }


    public Study findByStudyId(Long id){
        Optional<Study> study = studyRepository.findById(id);
        return study.orElse(null);
    }

    public Page<Study> findByStudyCategory(String category, Pageable pageable){
        Category strToCategory = Category.valueOf(category);
        Page<Study> studyPage = studyRepository.findByCategory(strToCategory, pageable);
        return studyPage;
    }


    public Page<Study> findStudyListByMember(Member member, Pageable pageable){
        Page<Study> studyList = studyRepository.findByLeader(member, pageable);
        return studyList;
    }

}
