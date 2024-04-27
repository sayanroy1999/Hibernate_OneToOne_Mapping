package com.example.demo18;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo18Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo18Application.class, args);

		System.out.println("Project started");

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();

		//Setting 1st question and answer
		Question question1=new Question();
		question1.setQuestionId(101);
		question1.setQuestion("What is Java");

		Answer answer1=new Answer();
		answer1.setAnswerId(1001);
		answer1.setAnswer("Java is a programming language");

		answer1.setQuestion(question1);
		question1.setAnswer(answer1);

		//Setting 2nd question and answer
		Question question2=new Question();
		question2.setQuestionId(201);
		question2.setQuestion("What is Hibernate");

		Answer answer2=new Answer();
		answer2.setAnswerId(2001);
		answer2.setAnswer("Hibernate is a ORM framework");

		answer2.setQuestion(question2);
		question2.setAnswer(answer2);

		Session session=factory.openSession();

		Transaction tx=session.beginTransaction();
		session.save(question1);
		session.save(answer1);
		session.save(question2);
		session.save(answer2);
		tx.commit(); //To commit the changes in our DB

		//Fetching
		Question q1=(Question) session.get(Question.class,101);
		System.out.println(q1.getQuestion());
		System.out.println(q1.getAnswer().getAnswer());

		System.out.println("Done");

		//System.out.println(sessionFactory);
		//System.out.println(sessionFactory.isClosed());

		session.close();
		factory.close();

	}

}
