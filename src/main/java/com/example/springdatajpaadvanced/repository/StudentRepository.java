package com.example.springdatajpaadvanced.repository;

import com.example.springdatajpaadvanced.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    // JPQL is based on classes, not on tables from database
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // Native Query
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    // Named Parameter Values
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Query(value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2", nativeQuery = true)
    @Modifying
    void updateStudentNameByEmail(String firstName, String emailId);

}
