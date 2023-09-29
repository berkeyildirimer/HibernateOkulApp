package com.berke;

import com.berke.enums.EBrans;
import com.berke.repository.entity.KisiselBilgiler;
import com.berke.repository.entity.Ogrenci;
import com.berke.repository.entity.Ogretmen;
import com.berke.repository.entity.Sinif;
import com.berke.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session;
        Transaction transaction;

        Ogretmen ogretmen = Ogretmen.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Berke")
                        .soyad("Yildirimer")
                        .tcKimlik("33333333333").build())
                .eBrans(EBrans.FIZIK)
                .date(LocalDate.now())
                .build();

        Ogrenci ogrenci1 = Ogrenci.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Berke")
                        .soyad("Yildirimer")
                        .tcKimlik("22222222222").build())
                .dogumTarihi(LocalDate.of(1997,6,26))
                .build();

        Ogrenci ogrenci2 = Ogrenci.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Ayse")
                        .soyad("Ozturk")
                        .tcKimlik("11111111111").build())
                .dogumTarihi(LocalDate.now())
                .build();
        Sinif sinif= Sinif.builder()
                .sinifAdi("Yokediciler Sinifi")
                .ogretmenId(ogretmen.getId())
                .ogrenciler(List.of(
                        ogrenci1.getKisiselBilgiler().getAd(),
                        ogrenci2.getKisiselBilgiler().getAd()))
                .build();


        session= HibernateUtility.getSessionFactory().openSession();
        transaction= session.beginTransaction();
        session.save(ogrenci1);
        session.save(ogrenci2);
        session.save(ogretmen);
        session.save(sinif);
        transaction.commit();
        session.close();
    }
}