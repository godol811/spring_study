package springdemo.annotation;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    // create an array of strings
    private String[] data ={
            "개조심",
            "사람조심",
            "고양이조심",
            "귀신조심"
    };

    // create a random number generator
    private Random myRandom = new Random();


    @Override
    public String getFortune() {
        // pick a random string from the array
        int index = myRandom.nextInt(data.length);

        String theFortune = data[index];
        return theFortune;
    }
}
