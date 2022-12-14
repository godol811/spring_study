package springdemo.beanDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        boolean result = (theCoach == alphaCoach);

        boolean result2 = (theCoach.equals(alphaCoach));


        System.out.println("\nPointing to the same object  " +  result + "  equals  " + result2);
        System.out.println(theCoach);
        System.out.println(alphaCoach);

        //close context

        context.close();
    }

}
