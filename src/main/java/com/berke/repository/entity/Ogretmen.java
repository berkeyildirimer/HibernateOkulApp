package com.berke.repository.entity;

import com.berke.enums.EBrans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ogretmentbl")
public class Ogretmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    KisiselBilgiler kisiselBilgiler;

    @Enumerated(EnumType.STRING)
    EBrans eBrans;

    @Builder.Default
    @Column(nullable = false)
    LocalDate date=LocalDate.now();
}
