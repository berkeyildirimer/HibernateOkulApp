//package com.berke.controller;
//
//import com.berke.enums.EBrans;
//import com.berke.repository.entity.Ogrenci;
//import com.berke.repository.entity.Ogretmen;
//import com.berke.utility.HibernateUtility;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.time.LocalDate;
//
//public class OgrenciController {
//    public static void main(String[] args) {
//        Session session;
//        Transaction transaction;
//
//        Ogrenci ogrenci1 = Ogrenci.builder()
//                .ad("Berke")
//                .soyad("Yildirimer")
//                .tcKimlik("12345678986")
//                .dogumTarihi(LocalDate.of(1997,6,26))
//                .build();
//
//        Ogrenci ogrenci2 = Ogrenci.builder()
//                .ad("Ayse")
//                .soyad("Ozturk")
//                .tcKimlik("11134356789")
//                .dogumTarihi(LocalDate.now())
//                .build();
//
//        session= HibernateUtility.getSessionFactory().openSession();
//        transaction= session.beginTransaction();
//        session.save(ogrenci1);
//        session.save(ogrenci2);
//        transaction.commit();
//        session.close();
//    }
//}
