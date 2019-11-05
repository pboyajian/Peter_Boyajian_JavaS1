package controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class PeterBoyajianMagicEightBallController {
private List<String> responses=new ArrayList<>();
private Random random;
@GetMapping(value = "/eightballanswer")
    public String getEightBallAnswer(){
    random=new Random();
    responses.addAll(Arrays.asList(
            "No",
            "Yes",
            "Looking cloudy",
            "Not sure",
            "Absolutely!",
            "Ask again",
            "Ummm",
            "Not a chance"
    ));
    int rand=random.nextInt(responses.size());
    return responses.get(rand);
}
@RequestMapping(value = "/nottest",method = RequestMethod.GET)
    public String retStr(){
    return "retStr";
}
}
