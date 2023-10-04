package com.berke.repository.hql;

import com.berke.repository.entity.Ogrenci;
import com.berke.utility.HibernateUtility;
import com.berke.utility.ICrud;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/*
    findAll ve findById icin metotlar.
 */
public class OgrenciDao implements ICrud<Ogrenci,Long> {
    private final EntityManager entityManager;

    public OgrenciDao() {
        this.entityManager = HibernateUtility.getSessionFactory().createEntityManager();
    }

    @Override
    public Ogrenci save(Ogrenci entity) {
        return null;
    }

    @Override
    public Iterable<Ogrenci> saveAll(Iterable<Ogrenci> entities) {
        return null;
    }

    @Override
    public void delete(Ogrenci entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Ogrenci> findAll() {
        //"SELECT * FROM tbl_ogrenci"
        String hql = "SELECT o FROM Ogrenci as o";
        TypedQuery<Ogrenci> query = entityManager.createQuery(hql, Ogrenci.class);
        return query.getResultList();
    }

    @Override
    public List<Ogrenci> findByEntity(Ogrenci entity) {
        return null;
    }

    @Override
    public List<Ogrenci> findByColumnNameAndValue(String columnName, String value) {
        return null;
    }

    public List<Ogrenci> findAll2(){
        String hql = "SELECT o FROM Ogrenci as o";
        Session session = HibernateUtility.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Ogrenci> ogrenciList = query.getResultList();
        session.close();
        return ogrenciList;
    }

    @Override
    public Optional<Ogrenci> findById(Long id) {

        return Optional.ofNullable(entityManager.find(Ogrenci.class,id));
    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }


    public Ogrenci findById2(Long id){
        Session session = HibernateUtility.getSessionFactory().openSession();
//        String hql = "SELECT o FROM Ogrenci as o WHERE id =: deger ";
        String hql = "SELECT o FROM Ogrenci as o WHERE id ="+id;
        Query query = session.createQuery(hql);
        Ogrenci ogrenci = (Ogrenci) query.getSingleResult();
//        Ogrenci ogrenci = (Ogrenci) query.setParameter("deger",id).getSingleResult();
        session.close();
        return ogrenci;
    }

}
