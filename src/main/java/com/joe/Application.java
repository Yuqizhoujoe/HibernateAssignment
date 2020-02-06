package com.joe;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Application {

    private SessionFactory sessionFactory = DBUtil.getSessionFactory();

    public Student find(long id){
        Student student = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s where id = :id");
            query.setParameter("id", id);
            student = (Student) query.uniqueResult();
            transaction.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                session.close();
            }
        }
        return student;
    }

    public void get(long id) {
        List<Student> students = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s");
            students = query.getResultList();
            for (Iterator iter = students.iterator(); iter.hasNext();) {
                Student student = (Student) iter.next();
                if (student.getId() == id) {
                    System.out.println("Id: " + student.getId());
                    System.out.println("Name: " + student.getName());
                    System.out.println("Major: " + student.getMajor());
                    System.out.println("School: " + student.getSchool());
                }
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public boolean update(Student student) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (HibernateError e) {
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    public boolean delete(Student student) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(student);
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

    public void insertStudent(String name, String major, String school) {
        Session session = null;
        Student student = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            student = new Student(name, major, school);
            session.save(student);
            transaction.commit();
        } catch (HibernateError e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void getAllStudents(){
        List<Student> students = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s", Student.class);
            students = query.getResultList();
            for (Iterator iter = students.iterator(); iter.hasNext();) {
                Student student = (Student) iter.next();
                System.out.println("Id: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Major: " + student.getMajor());
                System.out.println("School: " + student.getSchool());
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }


}
