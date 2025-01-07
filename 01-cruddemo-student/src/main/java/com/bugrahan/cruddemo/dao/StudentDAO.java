package com.bugrahan.cruddemo.dao;

import com.bugrahan.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {


   void save(Student student);

    Student findById(Integer id);

     List<Student> findAll();

     List<Student> findByLastName(String thelastName);

     void update(Student student);

     void delete(int id);

     int deleteAll();









    }


