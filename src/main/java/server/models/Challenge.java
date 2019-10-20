package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "challenges", name = "CHALLENGE")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Challenge {
    @Id
    @Column(name = "code")
    String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_login")
    String teacherLogin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_type_name")
    String challengeTypeName;
}
