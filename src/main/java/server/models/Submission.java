package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "challenges", name = "SUBMISSION")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "submission_generator")
    @SequenceGenerator(
            schema = "challenges",
            name = "submission_generator",
            sequenceName = "submission_seq",
            allocationSize = 1)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    Long id;

    @Column(name = "student_name")
    String studentName;

    @Column(name = "score")
    Long score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_code")
    String challengeCode;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            schema = "challenges",
            name = "submission_choice",
            joinColumns = @JoinColumn(name = "submission_id"),
            inverseJoinColumns = @JoinColumn(name = "choice_id"))
    Set<Choice> choices = new HashSet<>();
}
