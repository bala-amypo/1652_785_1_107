package com.example.demo.entity;





import java.time.LocalDateTime;
import jakarta.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evidence {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "claim_id")
    private DamageClaim claim;

    private String evidenceType; // IMAGE | DOCUMENT | TEXT

    private String fileUrl;

    private LocalDateTime uploadedAt;

}