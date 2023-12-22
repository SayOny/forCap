package capstone.backend.service;

import capstone.backend.domain.Member;
import capstone.backend.domain.MemberStudy;
import capstone.backend.domain.Stream;
import capstone.backend.domain.Study;
import capstone.backend.repository.StreamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
@RequiredArgsConstructor
public class StreamService {
//    @Autowired
//    private final StreamRepository streamRepository;
//
//    public List<Stream> findByMember(Member member){
//        int i;
//        List<MemberStudy> studyList = member.getStudyList();
//        List<Stream> streamList = new ArrayList<>();
//        for (i=0; i<studyList.size(); i++){
//            streamList.addAll(streamRepository.findByMemberStudy(studyList.get(i)));
//        }
//        return streamList;
//    }
//
//    public List<Stream> findByStudy(Study study){
//        return streamRepository.findByStudy(study);
//
//    }
}
