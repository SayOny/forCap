package capstone.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "stream")
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stream_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Study study;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Member> member = new ArrayList<>();
    
    private LocalDate date;

    private LocalDateTime start;
    private LocalDateTime end;

    private Long postureWarn;
    private Long sleepingWarn;
}
