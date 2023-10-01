package com.berke.criteria;

import com.berke.repository.entity.Ogretmen;
import com.berke.utility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OgretmenCriteria {
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    public OgretmenCriteria(){
        entityManager= HibernateUtility.getSessionFactory().createEntityManager();
        criteriaBuilder=entityManager.getCriteriaBuilder();
    }
    public List<Ogretmen> findAll() {
        CriteriaQuery<Ogretmen> criteria=criteriaBuilder.createQuery(Ogretmen.class);
        Root<Ogretmen> root=criteria.from(Ogretmen.class);
        criteria.select(root);
        List<Ogretmen> ogretmenList=entityManager.createQuery(criteria).getResultList();
        ogretmenList.forEach(System.out::println);
        return ogretmenList;
    }
    public Ogretmen findById(Long id){
        CriteriaQuery<Ogretmen> criteria=criteriaBuilder.createQuery(Ogretmen.class);
        Root<Ogretmen> root=criteria.from(Ogretmen.class);
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        Ogretmen result=entityManager.createQuery(criteria).getSingleResult();
        System.out.println(result);
        return result;
    }
}
