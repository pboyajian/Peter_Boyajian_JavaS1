package com.trilogyed.U1M4SummativeBoyajianPeter.controller;

import com.trilogyed.U1M4SummativeBoyajianPeter.models.Answer;
import com.trilogyed.U1M4SummativeBoyajianPeter.models.Definition;
import com.trilogyed.U1M4SummativeBoyajianPeter.models.Question;
import com.trilogyed.U1M4SummativeBoyajianPeter.models.Quote;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class U1M4SummativeBoyajianPeterController {
    private List<Quote> quotes;
    private List<Definition> definitions;
    private Random random;
    private List<String> responses;
    public U1M4SummativeBoyajianPeterController() {
        random=new Random();
        quotes=new ArrayList<>();
        definitions=new ArrayList<>();
        responses=new ArrayList<>();

        quotes.add(new Quote("author0","quote0"));
        quotes.add(new Quote("author1","quote1"));
        quotes.add(new Quote("author2","quote2"));
        quotes.add(new Quote("author3","quote3"));
        quotes.add(new Quote("author4","quote4"));
        quotes.add(new Quote("author5","quote5"));
        quotes.add(new Quote("author6","quote6"));
        quotes.add(new Quote("author7","quote7"));
        quotes.add(new Quote("author8","quote8"));
        quotes.add(new Quote("author9","quote9"));
        quotes.add(new Quote("author10","quote10"));

        definitions.add(new Definition("word0","definition0"));
        definitions.add(new Definition("word1","definition1"));
        definitions.add(new Definition("word2","definition2"));
        definitions.add(new Definition("word3","definition3"));
        definitions.add(new Definition("word4","definition4"));
        definitions.add(new Definition("word5","definition5"));
        definitions.add(new Definition("word6","definition6"));
        definitions.add(new Definition("word7","definition7"));
        definitions.add(new Definition("word8","definition8"));
        definitions.add(new Definition("word9","definition9"));
        definitions.add(new Definition("word10","definition10"));

        responses.add("response0");
        responses.add("response1");
        responses.add("response2");
        responses.add("response3");
        responses.add("response4");
        responses.add("response5");
        responses.add("response6");
        responses.add("response7");
        responses.add("response8");
        responses.add("response9");
        responses.add("response10");
    }

    @GetMapping(value = "/quote")
    public Quote getRandomQuote(){
        int rand=random.nextInt(quotes.size());
        return quotes.get(rand);
    }

    @GetMapping(value = "/word")
    public Definition getRandomWord(){
        int rand=random.nextInt(definitions.size());
        return definitions.get(rand);
    }

    @PostMapping(value = "/magic")
    public Answer getRandomResponse(@RequestBody @Valid Question question){
        int rand=random.nextInt(responses.size());
        return new Answer(question, responses.get(rand));
    }
}
