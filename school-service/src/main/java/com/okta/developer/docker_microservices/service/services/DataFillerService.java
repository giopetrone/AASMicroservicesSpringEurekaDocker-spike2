package com.okta.developer.docker_microservices.service.services;

import com.okta.developer.docker_microservices.service.dao.CourseDao;
import com.okta.developer.docker_microservices.service.dao.StudentDao;
import com.okta.developer.docker_microservices.service.dao.TeacherDao;
import com.okta.developer.docker_microservices.service.dao.TeachingClassDao;
import com.okta.developer.docker_microservices.service.entities.Student;
import com.okta.developer.docker_microservices.service.entities.Course;
import com.okta.developer.docker_microservices.service.entities.Teacher;
import com.okta.developer.docker_microservices.service.entities.TeachingClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class DataFillerService {

    private final CourseDao courseDAO;
    private final TeacherDao teacherDAO;
    private final TeachingClassDao teachingClassDAO;
    private final StudentDao studentDAO;

    public DataFillerService(CourseDao courseDAO, TeacherDao teacherDAO, TeachingClassDao teachingClassDAO, StudentDao studentDAO) {
        this.courseDAO = courseDAO;
        this.teacherDAO = teacherDAO;
        this.teachingClassDAO = teachingClassDAO;
        this.studentDAO = studentDAO;
    }


    @PostConstruct
    @Transactional
    public void fillData(){


        Teacher pj = new Teacher();
               pj.setName("Professor Torasso");
               pj.setEmail("torasso@yahoo_.com");
               pj.setPictureURL("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg");

        Teacher px = new Teacher();
        px.setName("Professor Petrone");
        px.setEmail("petrone@xproject_.com");
        px.setPictureURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4");

        teacherDAO.save(pj);
        teacherDAO.save(px);

        // create courses
        Course mathematics = new Course();
        mathematics.setName("Mathematics");
        mathematics.setRate((short) 10);
        mathematics.setWorkload(10);
        Course spanish = new Course();
        spanish.setName("Spanish");
        spanish.setRate((short) 10);
        spanish.setWorkload(20);

        Course introductionToPsychology = new Course();
        introductionToPsychology.setName("introductionToPsychology");
        introductionToPsychology.setRate((short) 10);
        introductionToPsychology.setWorkload(90);

       // Course dealingWithUnknown = new Course("Dealing with unknown", 10, (short) 100);
      //  Course handlingYourMentalPower = new Course("Handling your mental power", 50, (short) 100);

        courseDAO.save(mathematics);
        courseDAO.save(spanish);
     //   courseDAO.save(dealingWithUnknown);
      //  courseDAO.save(handlingYourMentalPower);
        courseDAO.save(introductionToPsychology);

        // classes
        Student studendChaves = new Student();
        studendChaves.setName("Chaves");
        studendChaves.setAge((short) 34);
        studentDAO.save(studendChaves);

        Student studendQuico = new Student();
        studendQuico.setName("Quico");
        studendQuico.setAge((short) 34);
        studentDAO.save(studendQuico);

        Student studendCyclops = new Student();
        studendCyclops.setName("Cyclops");
        studendCyclops.setAge((short) 25);
        studentDAO.save(studendCyclops);


       // Student studentIceman = studentDAO.save(new Student("Iceman", (short) 30));
       // Student studendArchangel = studentDAO.save(new Student("Archangel", (short) 29));


        TeachingClass math = new TeachingClass();
        math.setCourse(mathematics);
        math.setYear(2020);
        math.setTeacher(pj);
        math.setStudents(Arrays.asList(studendQuico, studendCyclops));
        teachingClassDAO.save(math);

        TeachingClass spa = new TeachingClass();
        spa.setCourse(spanish);
        spa.setYear(2020);
        spa.setTeacher(px);
        spa.setStudents(Arrays.asList(studendQuico, studendCyclops));
        teachingClassDAO.save(spa);

        teachingClassDAO.save(spa);


    }
}
