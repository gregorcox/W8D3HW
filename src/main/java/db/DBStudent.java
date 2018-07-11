package db;

import models.Course;
import models.Instructor;
import models.Lesson;
import models.Student;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudent {

    private static Session session;
    private static Transaction transaction;

    public static List<Lesson> getLessonsForStudent(Student student){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> results = null;
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("course", student.getCourse()));
            results = cr.list();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        finally {
           session.close();
        }
        return results;

    }
}
