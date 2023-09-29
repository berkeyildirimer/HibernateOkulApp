//package com.berke.controller;
//
//import com.berke.enums.EBrans;
//import com.berke.repository.entity.Ogretmen;
//import com.berke.utility.HibernateUtility;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import javax.lang.model.element.Name;
//import java.time.LocalDate;
//
//public class OgretmenController {
//    public static void main(String[] args) {
//        Session session;
//        Transaction transaction;
//
//        Ogretmen ogretmen = Ogretmen.builder()
//                .ad("Berke")
//                .soyad("Yildirimer")
//                .tcKimlik("12345678986")
//                .eBrans(EBrans.FIZIK)
//                .date(LocalDate.now())
//                .build();
//
//        session= HibernateUtility.getSessionFactory().openSession();
//        transaction= session.beginTransaction();
//        session.save(ogretmen);
//        transaction.commit();
//        session.close();
//    }
//}
