package capstone.backend.repository;

import capstone.backend.domain.Category;
import capstone.backend.domain.Member;
import capstone.backend.domain.Study;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {
    Page<Study> findByCategory(Category category, Pageable pageable);

    Page<Study> findByLeader(Member member, Pageable pageable);

}
