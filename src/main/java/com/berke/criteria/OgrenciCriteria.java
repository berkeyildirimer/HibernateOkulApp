package com.berke.criteria;

import com.berke.repository.entity.Ogrenci;
import com.berke.utility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OgrenciCriteria {
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    public OgrenciCriteria(){
        entityManager= HibernateUtility.getSessionFactory().createEntityManager();
        criteriaBuilder=entityManager.getCriteriaBuilder();
    }
    public List<Ogrenci> findAll() {
        CriteriaQuery<Ogrenci> criteria=criteriaBuilder.createQuery(Ogrenci.class);
        Root<Ogrenci> root=criteria.from(Ogrenci.class);
        criteria.select(root);
        List<Ogrenci> ogrenciList=entityManager.createQuery(criteria).getResultList();
        ogrenciList.forEach(System.out::println);
        return ogrenciList;
    }
    public Ogrenci findById(Long id){
        CriteriaQuery<Ogrenci> criteria=criteriaBuilder.createQuery(Ogrenci.class);
        Root<Ogrenci> root=criteria.from(Ogrenci.class);
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        Ogrenci result=entityManager.createQuery(criteria).getSingleResult();
        System.out.println(result);
        return result;
    }
}
