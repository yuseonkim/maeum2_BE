package org.example.maeum2_be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberDTO {
    @JsonProperty("member_id")
    String memberId;

    @JsonProperty("child_first_name")
    String childFirstName;

    @JsonProperty("child_last_name")
    String childLastName;

    @JsonProperty("child_gender")
    String childGender;

    @JsonProperty("child_birth")
    LocalDate childBirth;

    @JsonProperty("email")
    String email;

    @JsonProperty("ai_name")
    String aiName;

    @JsonProperty("phone_number")
    String phoneNumber;
}
