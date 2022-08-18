package springdemo;

public class BaseballCoach implements Coach{

    //define a private field
    private FortuneService fortuneService;

    //Contructor
    public BaseballCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "Run 5K";

    }

    @Override
    public String getDailyFortune() {
        // user my fortuneService to get a fortune
        return fortuneService.getFortune();
    }
}
