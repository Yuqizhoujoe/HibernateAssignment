package com.joe;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;

public class InstructorApplication {

    SessionFactory sessionFactory = DBUtil.getSessionFactory();

    public void createInstructor(String firstName, String lastName, String email, String youtubeChannel, String hobby){
        Instructor instructor = null;
        InstructorDetails instructorDetails = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            instructor = new Instructor(firstName, lastName, email);
            instructorDetails = new InstructorDetails(youtubeChannel, hobby);
            instructor.setInstructorDetail(instructorDetails);
            session.save(instructor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void getInstructorDetails(int id) {
        InstructorDetails instructorDetails = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            instructorDetails =session.get(InstructorDetails.class, id);
            System.out.println("Instructor Deatils: " + instructorDetails);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public Instructor findInstructor(int id) {
        Instructor instructor = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select i from Instructor i where id = :id");
            query.setParameter("id", id);
            instructor = (Instructor) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return instructor;
    }

    public InstructorDetails findInstructorDetails(int id) {
        InstructorDetails instructorDetails = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select i from InstructorDetails i where id = :id");
            query.setParameter("id", id);
            instructorDetails = (InstructorDetails) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return instructorDetails;
    }

    public boolean update(Instructor instructor) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(instructor);
            transaction.commit();
        } catch (Exception e) {
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

}
