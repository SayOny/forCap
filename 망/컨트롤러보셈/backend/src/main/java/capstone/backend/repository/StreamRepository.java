package capstone.backend.repository;

import capstone.backend.domain.Member;
import capstone.backend.domain.MemberStudy;
import capstone.backend.domain.Stream;
import capstone.backend.domain.Study;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class StreamRepository{

//    @Transactional
//    @Query("select p from Stream p inner join p.study pt where pt.id = :studyId")
//    List<Stream> findByStudyId(Long studyId);
//
//    @Transactional
//    @Query("select p from Stream p inner join p.study pt where pt.id = :studyId")
//    List<Stream> findByStudy(Long studyId);

//    @PersistenceContext
//    private EntityManager em;
//
//    public List<Stream> findByMemberStudy(MemberStudy memberStudy){
//        return em.createQuery("select p from Stream p inner join p.study pt where pt.id = :studyId", Stream.class)
//                .setParameter("studyId",memberStudy.getStudy().getId())
//                .getResultList();
//    }
//
//    public List<Stream> findByStudy(Study study){
//        return em.createQuery("select p from Stream p inner join p.study pt where pt.id = :studyId", Stream.class)
//                .setParameter("studyId", study.getId())
//                .getResultList();
//    }
}
