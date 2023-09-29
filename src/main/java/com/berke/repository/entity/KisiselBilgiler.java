package com.berke.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class KisiselBilgiler {
    @Column(nullable = false, length = 30)
    String ad;

    @Column(nullable = false,length = 30)
    String soyad;

    @Column(unique = true,nullable = false,length = 11)
    String tcKimlik;
}
