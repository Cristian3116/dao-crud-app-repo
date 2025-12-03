package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

@SpringBootApplication
public class CrudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudAppApplication.class, args);
    }


    @Bean
     public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
           // createStudent(studentDAO);
            createMultileStudents(studentDAO);
        };
     }

     private void createStudent(StudentDAO studentDAO) {
        //create a Student's oject
         System.out.println("Creating new Student object....");
         Student newStudent = new Student("John","Doe","john@pixelacademy.md" );

         // save object Student in database using DAO
         System.out.println("Saving the student....");
         studentDAO.save(newStudent);


         //DISPLAY saved student's id
         System.out.println("Saved student. Generated id: " + newStudent.getId());
     }

    private void createMultileStudents(StudentDAO studentDAO) {
        //create more students
        System.out.println("Creating 3 student objects ...");
        Student newStudent1 = new Student("Andrei", "Munteanu", "munteanu@pixelacedemy.md");
        Student newStudent2 = new Student("Iulian","Vataman", "iulic@pixelacedemy.md");
        Student newStudent3 = new Student("Maria", "Mirabela","mira@pixelacademy.md");

        //save student objects in data baze
        System.out.println("Saving the students ...");
        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);
        studentDAO.save(newStudent3);
    }

}