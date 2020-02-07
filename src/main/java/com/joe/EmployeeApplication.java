package com.joe;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.id.uuid.StandardRandomStrategy;
import org.hibernate.query.Query;


import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class EmployeeApplication {

    private SessionFactory sessionFactory = DBUtil.getSessionFactory();

    public Employee find(long id){
        Employee employee = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s where id = :id");
            query.setParameter("id", id);
            employee = (Employee) query.uniqueResult();
            transaction.commit();
        } catch (HibernateError e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (transaction != null) {
                session.close();
            }
        }
        return employee;
    }

    public void getById(long id) {
        Employee employee = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s where id = :id");
            query.setParameter("id", id);
            employee = (Employee) query.uniqueResult();
            System.out.println("Id: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getEmployName());
            System.out.println("Salary: " + employee.getEmploySalary());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public boolean delete(Employee employee) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(employee);
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

    public boolean create(Employee employee) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(employee);
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

    public boolean update(Employee employee) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(employee);
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

    public void showAllEmployees(){
        List<Employee> employees;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select e from Employee e", Employee.class);
            employees = (List) query.getResultList();
            for (Iterator<Employee> iter = employees.iterator(); iter.hasNext();) {
                Employee employee = iter.next();
                System.out.println("Id: " + employee.getEmployeeId());
                System.out.println("Name: " + employee.getEmployName());
                System.out.println("Salary: " + employee.getEmploySalary());
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void between(BigDecimal min, BigDecimal max){
        List<Employee> employees = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            StoredProcedureQuery storedProcedureQuery = session.createStoredProcedureQuery("sp_findBetween", Employee.class);
            storedProcedureQuery.registerStoredProcedureParameter("min", BigDecimal.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter("max", BigDecimal.class, ParameterMode.IN);
            storedProcedureQuery.setParameter("min", min);
            storedProcedureQuery.setParameter("max", max);
            employees = storedProcedureQuery.getResultList();
            for (Iterator iter = employees.iterator(); iter.hasNext();){
                Employee employee = (Employee) iter.next();
                System.out.println("Id: " + employee.getEmployeeId());
                System.out.println("Name: " + employee.getEmployName());
                System.out.println("Salary: " + employee.getEmploySalary());
            }
            transaction.commit();
        } catch (Exception e) {
            employees = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void findEmployeeById(int id) {
        Employee employee = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            StoredProcedureQuery storedProcedureQuery = session.createStoredProcedureQuery("sp_findEmployById", Employee.class);
            storedProcedureQuery.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            storedProcedureQuery.setParameter("id", id);
            employee = (Employee) storedProcedureQuery.getSingleResult();
            System.out.println("Id: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getEmployeeId());
            System.out.println("Salary: " + employee.getEmploySalary());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void exit(){
        sessionFactory.close();
    }

}
