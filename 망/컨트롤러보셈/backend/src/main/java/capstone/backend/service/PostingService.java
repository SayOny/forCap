package capstone.backend.service;

import capstone.backend.domain.Posting;
import capstone.backend.repository.PostingRepository;
import capstone.backend.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class PostingService {

//    private final PostingRepository postingRepository;
//    private final StudyRepository studyRepository;
//
//
//    public List<Posting> findAll() {
//        return postingRepository.findAll();
//    }
//
//    public void write(String title, String body, String studyName){
//        Posting post = new Posting();
//        post.setTitle(title);
//        post.setBody(body);
//        post.setStudy(studyRepository.findByName(studyName));
//    }

}
