package dev.intranet.exampleapp.application.infrastructure.persistence.daos;

import dev.intranet.exampleapp.application.domain.Phone;
import dev.intranet.exampleapp.application.domain.repositories.PhoneRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class PhoneDAO implements PhoneRepository {

    @PersistenceContext
    private EntityManager em;

    private Session getSession(){
        return (Session) em.getDelegate();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Phone> byNumbers(Set<String> numbers) {

        Criteria criteria = getSession().createCriteria(Phone.class);

        List<Criterion> criterionsPhoneNumbers = new ArrayList<>();

        for (String number : numbers) {
            criterionsPhoneNumbers.add( Restrictions.like("number", number, MatchMode.ANYWHERE)  ) ;
        }

        criteria.add(Restrictions.or( criterionsPhoneNumbers.toArray(new Criterion[criterionsPhoneNumbers.size()]) ));
        return criteria.list();
    }

    @Transactional(readOnly = true)
    @Override
    public long countPhones() {
        Criteria criteria = getSession().createCriteria(Phone.class);
        criteria.setProjection(Projections.countDistinct("id"));
        return (long) criteria.uniqueResult();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Phone save(Phone phone) {
        getSession().save(phone);
        return phone;
    }
}
