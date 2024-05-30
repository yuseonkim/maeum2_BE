package org.example.maeum2_be.entity.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @OneToMany(mappedBy = "chatRoom")
    private List<Chat> chats;

    public ChatRoom(Member member){
        this.member = member;
    }

    @CreatedDate
    private LocalDateTime timestamp;


    public ChatRoom(Member member, LocalDateTime now) {
        this.member = member;
        this.timestamp = now;
    }
}
