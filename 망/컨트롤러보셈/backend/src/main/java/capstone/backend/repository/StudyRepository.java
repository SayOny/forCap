package capstone.backend.repository;


import capstone.backend.domain.Category;
import capstone.backend.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {
    List<Study> findByCategory(Category category);
    Study findByName(String studyName);
}
