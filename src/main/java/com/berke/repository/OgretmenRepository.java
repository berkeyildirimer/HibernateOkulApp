package com.berke.repository;

import com.berke.repository.entity.Ogretmen;
import com.berke.utility.HibernateUtility;
import com.berke.utility.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class OgretmenRepository extends MyFactoryRepository<Ogretmen, Long> {

    public OgretmenRepository() {
        super(new Ogretmen());
    }

    EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    @Override
    public List<Ogretmen> findAll() {
        CriteriaQuery<Ogretmen> criteria = criteriaBuilder.createQuery(Ogretmen.class);
        Root<Ogretmen> root = criteria.from(Ogretmen.class);
        criteria.select(root);
        List<Ogretmen> ogretmenList = entityManager.createQuery(criteria).getResultList();
        return ogretmenList;
    }

    @Override
    public Optional<Ogretmen> findById(Long id) {
        CriteriaQuery<Ogretmen> criteria = criteriaBuilder.createQuery(Ogretmen.class);
        Root<Ogretmen> root = criteria.from(Ogretmen.class);
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"), id));
        Ogretmen ogretmen = entityManager.createQuery(criteria).getSingleResult();
        return Optional.ofNullable(ogretmen);
    }


}
