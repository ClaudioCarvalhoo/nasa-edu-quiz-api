package server.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "challenges", name = "QUESTION")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_generator")
    @SequenceGenerator(
            schema = "challenges",
            name = "question_generator",
            sequenceName = "question_seq",
            allocationSize = 1)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    Long id;

    @Column(name = "text")
    String text;

    @Column(name = "image_url")
    String imageUrl;

    @Column(name = "help_text")
    String helpText;

    @Column(name = "help_image_url")
    String helpImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_type_name")
    ChallengeType challengeType;
}
