package capstone.backend.service;

import capstone.backend.domain.Category;
import capstone.backend.domain.Study;
import capstone.backend.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
public class StudyService {
    private final StudyRepository studyRepository;

    public List<Study> findAll() {
        return studyRepository.findAll();
    }

    public List<Study> findByCategory(Category category){
        return studyRepository.findByCategory(category);
    }

    public Study findById(Long id){
        return studyRepository.findById(id).orElseThrow(NullPointerException::new);
    }


}
