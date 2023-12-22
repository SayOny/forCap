package capstone.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberStudy {
    @Id
    @Column(name = "member_study_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Member> memberList = new ArrayList<Member>();

    @OneToOne(fetch = FetchType.LAZY)
    private Study study;


}
