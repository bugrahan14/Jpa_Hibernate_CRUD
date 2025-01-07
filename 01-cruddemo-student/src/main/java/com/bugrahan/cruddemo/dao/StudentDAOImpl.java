package com.bugrahan.cruddemo.dao;

import com.bugrahan.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // DEFİNE FİELD FOR ENTİTY MANAGER
    private EntityManager entityManager;

    // CONSTRUCTOR İNJECTİON
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        // CREATE QUERY
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);

        //RETURN QUERY RRESULTS
        return theQuery.getResultList() ;

    }

    @Override
    public List<Student> findByLastName(String thelastName) {
        //CREATE QUERY
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM STUDENT WHERE lastName=:theData",Student.class);

        //SET QUERY PARAMETERS
        theQuery.setParameter("theData",thelastName);

        //RETURN QUERY RESULTS
        return theQuery.getResultList() ;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(int id) {

        // RETRİEVE THE STUDENT
        Student theStudent = entityManager.find(Student.class,id);

        // DELETE THE STUDENT
        entityManager.remove(theStudent);



    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowDeleted;
    }


}
