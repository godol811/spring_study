package springdemo.beanDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanDI.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        //let's call our new method for fortunes
        System.out.println(theCoach.getDailyFortune());

        context.close();
    }
}
