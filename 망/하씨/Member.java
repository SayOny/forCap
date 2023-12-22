package capstone.design.posturecorrectionstudy.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
public class Member extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;

//    @Column(length = 100)
//    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

//    private Long age;
//    private Long sex; //남자는 0,여자는 1
//    private LocalDate birth;
//    private List<category> interest;
//    private Image profile // 프로필 사진

    @OneToMany(fetch = FetchType.LAZY)
    private List<Study> studyList=new ArrayList<Study>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Study> myStudyList= new ArrayList<Study>();

    public Member updateModifiedDate(){
        this.onPreUpdate();
        return this;
    }

    public String getRoleValue() {
        return this.role.getValue();
}

    public boolean dropout(Study sd){
        if (this.studyList.contains(sd) == true) {
            this.studyList.remove(sd);
            return true;
        }else return false;
    }

    public boolean participate(Study sd){
        if(this.studyList.contains(sd) == false){
            this.studyList.add(sd);
            return true;
        }else return false;
    }

}

