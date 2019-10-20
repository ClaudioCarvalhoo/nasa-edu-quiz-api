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
@Table(schema = "challenges", name = "CHOICE")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "choice_generator")
    @SequenceGenerator(
            schema = "challenges",
            name = "choice_generator",
            sequenceName = "choice_seq",
            allocationSize = 1)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    Long id;

    @Column(name = "text")
    String text;

    @Column(name = "score")
    Long score;

    @Column(name = "image_url")
    String imageUrl;

    @Column(name = "knowledge_text")
    String knowledgeText;

    @Column(name = "knowledge_image_url")
    String knowledgeImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    Question question;
}
