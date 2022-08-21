package springdemo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 컴포넌트를 명시하지 않으면 클래스 이름을 lowerCamel 로 불러오면 불러와진다. (Default Bean)
@Component
public class TennisCoach implements Coach{

    private FortuneService fortuneService;



    //위의 객체인 fortuneService 를 Autowired 하면 객체가 주입이 되어 init 안해도 된다.
    //Spring 4.3 에서부터는 @Autowired를 안써도 자동으로 연결이 되어진다.
    @Autowired
    public TennisCoach(FortuneService fortuneService){
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
