package db;

import models.Course;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCourse {

    private static Session session;
    private static Transaction transaction;

    public static List<Lesson> getLessonsForCourse(Course course){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> results = null;
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("course", course));
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
