package pixel.academy.crud_app.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pixel.academy.crud_app.entity.Student;

@Repository
public class StudentDaoImplementation implements StudentDAO{

    // Field for EntityManager (will be used for interaction with database)
   private EntityManager entityManager;
// EntityManager injection through constructor (recomended pratice for testability and modulariation)
   @Autowired
    public StudentDaoImplementation(EntityManager entityManager){
       this.entityManager = entityManager;
   }

   //Implimentation of save method to save an Student object in database
    @Override
    @Transactional
    public void save(Student theStudent){
       entityManager.persist(theStudent);
    }

}
