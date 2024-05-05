package org.example.maeum2_be.entity.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Member {
    @Id
    private String memberId;

    @Column(nullable = true, length = 20)
    private String childFirstName;

    @Column(nullable = true, length = 20)
    private String childLastName;


    @Column(nullable = true)
    private String childGender;

    @Column(nullable = true)
    private LocalDate childBirth;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String aiName;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column
    private LocalDate updateAt;

    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;




    @Builder
    public Member(String memberId, String childFirstName, String childLastName, String childGender, LocalDate childBirth, String email, String phoneNumber, String aiName, Role role){
        this.memberId = memberId;
        this.childFirstName = childFirstName;
        this.childLastName = childLastName;
        this.childGender = childGender;
        this.childBirth = childBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.aiName = aiName;
        this.role = role;
    }


    public void changeUserRole(Role role){
        this.role = role;
    }

    public void changeAiName(String aiName) { this.aiName = aiName;}

    public void setUserInfo( String phoneNumber,
                             String email,
                             String childLastName,
                             String childFirstName,
                             LocalDate childBirth,
                             String gender){
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.childFirstName = childFirstName;
        this.childLastName = childLastName;
        this.childBirth = childBirth;
        this.childGender = gender;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", childFirstName='" + childFirstName + '\'' +
                ", childLastName='" + childLastName + '\'' +
                ", childGender='" + childGender + '\'' +
                ", birth=" + childBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", aiName='" + aiName + '\'' +
                ", role=" + role +
                '}';
    }
}
