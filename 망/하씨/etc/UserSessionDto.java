package capstone.design.posturecorrectionstudy.etc;

import capstone.design.posturecorrectionstudy.domain.Member;

import java.io.Serializable;

public class UserSessionDto implements Serializable {
    private String name;
    private String email;
    private String nickname;
    private String role;
    private String modifiedDate;

    public UserSessionDto(Member member){
        this.name = member.getName();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
        this.role = member.getRoleValue();
        this.modifiedDate = member.getModifiedDate();
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return name;
    }
    public String getNickname(){
        return name;
    }
    public String getRole(){
        return name;
    }
}
