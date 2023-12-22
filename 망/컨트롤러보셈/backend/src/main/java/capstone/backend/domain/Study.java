package capstone.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "study")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long id;

    @Column(name = "study_name")
    private String studyName;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    private Member leader;

    @OneToMany(fetch = FetchType.LAZY)
    private List<MemberStudy> members = new ArrayList<>();


}
