package com.berke.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siniftbl")
public class Sinif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String sinifAdi;
    Long ogretmenId;

    @ElementCollection
    List<String>ogrenciler;
}
