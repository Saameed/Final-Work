package az.edu.asoiu.repository;

import az.edu.asoiu.entity.Indicator;
import az.edu.asoiu.entity.RelDiseaseIndicator;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Hp on 27.04.2017.
 */
@Repository
@Transactional
public class BaseRepositoryImpl implements BaseRepository {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List getDiseaseParamsWithLimit(Integer limit, String sort) throws Exception {

        String hql = "select d.id as id,d.name as name,d.description as diseaseDescription,d.icon as icon from Disease d ";
        if (sort.equals("asc")) {
            hql += " order by d.dateCreated asc";
        }
        if (sort.equals("desc")) {
            hql += " order by d.dateCreated desc";
        }
        Query query = sessionFactory.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setMaxResults(limit);
        List<Map> result = query.list();
        return result;
    }

    @Override
    public List findAll(String key) throws Exception {
        System.out.println("--------------0000000000000000000000000");
        List<Map> resultList = new ArrayList<Map>();
        String key1 = "";
        String key2 = "";
        String key3 = "";
        String searchParam = key.trim();
        String[] searchArray = null;
        searchArray = searchParam.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(searchArray));
        list.removeAll(Arrays.asList(" ", ""));
        System.out.println(list);

        Session session = sessionFactory.openSession();
        String hql = "from Indicator i where 1=1 ";
        if (key != null) {
            if (list.size() == 1) {
                key1 = list.get(0);
                System.out.println("key1: " + key1);
                hql += " and (i.diseaseId.name like :key1 or i.name like :key1)";
                hql += " order by r.dateCreated desc";
                Query query = sessionFactory.getCurrentSession().createQuery(hql);
                if (key != null) {
                    query.setParameter("key1", "%" + key1 + "%");
                }
                resultList = query.list();
            }
            else if (list.size() == 2) {
                key1 = list.get(0);
                key2 = list.get(1);
                hql += " and (i.diseaseId.name like :key1 or i.diseaseId.name like :key2 or i.name like :key1 or i.name like :key2)";
                hql += " order by r.dateCreated desc";
                Query query = sessionFactory.getCurrentSession().createQuery(hql);
                query.setParameter("key1", "%" + key1 + "%");
                query.setParameter("key2", "%" + key2 + "%");
                resultList = query.list();
            } else if (list.size() == 3) {
                key1 = list.get(0);
                key2 = list.get(1);
                key3 = list.get(2);
                hql += " and (i.diseaseId.name like :key1 or i.diseaseId.name like :key2 or i.diseaseId.name like :key3 " +
                        " or i.name like :key1 or i.name like :key2 or i.name like :key3)";
                hql += " order by r.dateCreated desc";
                Query query = sessionFactory.getCurrentSession().createQuery(hql);
                query.setParameter("key1", "%" + key1 + "%");
                query.setParameter("key2", "%" + key2 + "%");
                query.setParameter("key3", "%" + key3 + "%");
                resultList = query.list();
            }
        }
        System.out.println("test result: " + resultList);
        return resultList;
    }
}
