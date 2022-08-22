package springdemo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 컴포넌트를 명시하지 않으면 클래스 이름을 lowerCamel 로 불러오면 불러와진다. (Default Bean)
@Component
//모든 인스턴스를 매번 불러온다 - Singleton과 배치됨
//@Scope("prototype")
public class TennisCoach implements Coach{

    /**
    생성자 주입 1. 더 좋은 디자인 패턴을 위해 가장 추천
     세터 주입 2. 변할 수 있는 부분이 많기 떄문에 비추
     필드 주입 3. 필드는 읽기 쉽고 사용하기 쉽지만 코드 변하는 것에 따라 다양한 문제를 야기함

     */


    // 변수도 Autowired 하면 주입된 변수가 움직인다. 비추
    // @Autowired
    private FortuneService fortuneService;

    public TennisCoach(){
        System.out.println(" >> TennisCoach: inside default constructor");
    }

    // define my init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
    }
    // define my destroy method
    // PreDestroy는 @Scope가 Prototype은 먹히지 않는다.
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
    }


    //위의 객체인 fortuneService 를 Autowired 하면 객체가 주입이 되어 init 안해도 된다.
    //Spring 4.3 에서부터는 @Autowired를 안써도 자동으로 연결이 되어진다.
    //@Qualifier 에서는 같은 interface 를 implement 한 클래스들이 다수라면 그 중 가장 우선순위를 두어야하는 클래스 이름을
    //qualifier 한다. 역시 같은 이유로 lower camel case를 사용한다.
    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
