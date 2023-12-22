package capstone.backend.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String memberId;
    private String password;

    private String name;
    private Long age;
    private Long sex; //남자는 0,여자는 1

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    private List<Category> interest;
    private String email;

    @OneToMany
    private List<MemberStudy> studyList = new ArrayList<>();

//    public void modify(String nickname)






}
