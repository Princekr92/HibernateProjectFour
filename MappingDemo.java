package com.map1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	
	public static void main(String []args) {
		Configuration cfg=new Configuration();
		cfg.configure("com/tut/HibernateProjectOne/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		
		Emp e1=new Emp();
		int eid1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the Employee Id 1"));
		e1.setEid(eid1);
		String eName1 =JOptionPane.showInputDialog("Enter the Employee Name 1");
		e1.setEmployeName(eName1);
		
		Emp e2=new Emp();
		int eid2=Integer.parseInt(JOptionPane.showInputDialog("Enter the Employee Id 2"));
		e2.setEid(eid2);
		String eName2=JOptionPane.showInputDialog("Enter the Employee Name 2");
		e2.setEmployeName(eName2);
		
		
		Project p1=new Project();
		int pId1=Integer.parseInt(JOptionPane.showInputDialog("Enter the Project Id 1"));
		p1.setPid(pId1);
		String pName1=JOptionPane.showInputDialog("Enter the Project Name 1");
		p1.setProjectName(pName1);
		
		Project p2=new Project();
		int pId2=Integer.parseInt(JOptionPane.showInputDialog("Enter the Project Id 2"));
		p2.setPid(pId2);
		String pName2=JOptionPane.showInputDialog("Enter the Project Name 2");
		p2.setProjectName(pName2);
		
		
		List<Emp>list1=new ArrayList<Emp>();
		list1.add(e1);
		list1.add(e2);
		
		List<Project>list2=new ArrayList<Project>();
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p2.setEmps(list1);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		s.close();
		factory.close();
	}
}
