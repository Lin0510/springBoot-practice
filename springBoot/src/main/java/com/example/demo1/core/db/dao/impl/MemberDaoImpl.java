package com.example.demo1.core.db.dao.impl;

import com.example.demo1.core.db.dao.IMemberDao;
import com.example.demo1.core.db.model.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class MemberDaoImpl implements IMemberDao {

    // 管理entity生命週期及對持久層進行CRUD操作。
    @PersistenceContext
    private EntityManager entityManager;

    // 取得所有成員資料(教師、學生)
    public List<Member> getAllMember() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Member.class);
        Root<Member> root = cq.from(Member.class);
        cq.select(root);

        TypedQuery<Member> typedQuery = entityManager.createQuery(cq);
        List<Member> dataList = typedQuery.getResultList();

        return dataList;
    }

    // 取得所有學生資料
    public List<Member> getAllTeacher() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Member.class);
        Root<Member> root = cq.from(Member.class);

        cq.select(root).where((root.get("role")).in("teacher"));

        TypedQuery<Member> typedQuery = entityManager.createQuery(cq);
        List<Member> dataList = typedQuery.getResultList();

        return dataList;
    }

    // 取得所有教師資料
    public List<Member> getAllStudent() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Member.class);
        Root<Member> root = cq.from(Member.class);

        cq.select(root).where(cb.like(root.get("role"), "student"));

        TypedQuery<Member> typedQuery = entityManager.createQuery(cq);
        List<Member> dataList = typedQuery.getResultList();

        return dataList;
    }

    // 根據輸入的name取得成員資料
    public List<Member> findByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> root = cq.from(Member.class);

        cq.select(root).where(cb.like(root.get("name"), name));

        TypedQuery<Member> typedQuery = entityManager.createQuery(cq);
        List<Member> dataList = typedQuery.getResultList();

        return dataList;
    }

    // 查詢name含有輸入字串的所有成員
    public List<Member> findByNameContainsStr(String str) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Member.class);
        Root<Member> root = cq.from(Member.class);

        cq.select(root).where(cb.like(root.get("name"), "%"+str+"%"));

        TypedQuery<Member> typedQuery = entityManager.createQuery(cq);
        List<Member> dataList = typedQuery.getResultList();

        return dataList;
    }

//    public void example() {
//        // CriteriaBuilder:建構各種查詢條件如:大於、小於、等於、不等於、like、運算邏輯and、or、排序asc、desc等
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//
//        // CriteriaQuery:組成頂層的查詢語句如select、from、where、order by、group by、having、distinct
//        // select member
//        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
//
//        // Root:獲取entity的條件欄位
//        // from member
//        Root<Member> root = cq.from(Member.class);
//        // 1.get items having a price of more than 1000:
//        // cr.select(root).where(cb.gt(root.get("itemPrice"), 1000));
//
//        // 2. getting items having itemPrice less than 1000:
//        // cr.select(root).where(cb.lt(root.get("itemPrice"), 1000));
//
//        // 3.Items having name contain a:
//        cq.select(root).where(cb.like(root.get("name"), "%%"));
//        // 4.Records having itemPrice between 100 and 200:
//        // cr.select(root).where(cb.between(root.get("itemPrice"), 100, 200));
//
//        // 5.Items having itemName in Skate Board, Paint and Glue:
//        // cr.select(root).where(root.get("itemName").in("Skate Board", "Paint", "Glue"));
//
//        // 6.To check if the given property is null:
//        // cr.select(root).where(cb.isNull(root.get("property")));
//        // cr.select(root).where(cb.isEmpty(root.get("property")));
//
//        // 7.To check if the given property is not null:
//        // cr.select(root).where(cb.isNotNull(root.get("property")));
//        // cr.select(root).where(cb.isNotEmpty(root.get("property")));
//
//        TypedQuery<Member> typedQuery = entityManager.createQuery(cq);
//        List<Member> dataList = typedQuery.getResultList();
//
//        // Predicate: where條件，由CriteriaBuilder產生
//        // where name = ?name
//        Predicate predName = cb.equal(root.get("name"), name);
//        cr.where(predName);
//
//        // 可查詢複合條件
//        Predicate[] predicates = new Predicate[2];
//        predicates[0] = cb.isNull(root.get("classes"));
//        predicates[1]  =cb.like(root.get("name"), "%a%");
//        cq.select(root).where(predicates);
//        // Order: 排序條件，由CriteriaBuilder產生
//        // order by id desc
////        Order orderByIdDesc = cb.desc(root.get("id"));
////        cr.orderBy(orderByIdDesc);
////
////        TypedQuery<Member> typedQuery = entityManager.createQuery(criteriaQuery);
////        return typedQuery.getResultList();
//    }

}
