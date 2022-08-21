package springdemo.annotation;

import org.springframework.stereotype.Component;

// 컴포넌트를 명시하지 않으면 클래스 이름을 lowerCamel 로 불러오면 불러와진다. (Default Bean)
@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

}
