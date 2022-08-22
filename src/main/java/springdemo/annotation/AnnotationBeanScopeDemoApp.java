package springdemo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach",Coach.class);

        //Check if they are same

        boolean result = (theCoach == alphaCoach);

        // print out the results
        //Singleton 이기 떄문에 값이나 ID 값들이 같은 방향을 향하고 있다.
        //prototype 이면 ID 값들이나 모든 인스턴스가 매번 새로 생성된다.
        System.out.println("\npointing to the same object " + result);

        System.out.println("\nMemory location for theCoach " + theCoach);
        System.out.println("\nMemory location for alphaCoach " + alphaCoach + "\n");

        // close context
        context.close();
    }
}
