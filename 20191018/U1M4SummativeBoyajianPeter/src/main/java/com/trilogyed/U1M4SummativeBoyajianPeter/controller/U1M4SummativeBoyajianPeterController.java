package com.trilogyed.U1M4SummativeBoyajianPeter.controller;

import com.trilogyed.U1M4SummativeBoyajianPeter.models.Answer;
import com.trilogyed.U1M4SummativeBoyajianPeter.models.Definition;
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

        quotes.add(new Quote("David Bohm","A great many people think they are thinking when they are merely rearranging their prejudices."));
        quotes.add(new Quote("David Bohm","Perhaps there is more sense in our nonsense and more nonsense in our 'sense' than we would care to believe."));
        quotes.add(new Quote("David Bohm","Ultimately, all moments are really one, therefore now is an eternity."));
        quotes.add(new Quote("Sean Carroll","Each day, the moon’s gravitational field tugs at the earth as it rotates underneath. At CERN, this tiny stress caused the total length of the LEP tunnel to stretch and contract by about a millimeter (one-twenty-fifth of an inch) every day. Not such a big deal in a seventeen-mile-long beam pipe, but enough to cause a tiny fluctuation in the energy of the electrons and positrons—one that was easily detectable by the high-precision instruments. After some initial puzzlement at the daily energy variations, the CERN physicists quickly figured out what was going on."));
        quotes.add(new Quote("Kurt Gödel","The more I think about language, the more it amazes me that people ever understand each other at all."));
        quotes.add(new Quote("Kurt Gödel","Either mathematics is too big for the human mind or the human mind is more than a machine."));
        quotes.add(new Quote("Sooren","Hello, Chess Lovers, Sooren here and in this video we are going to see another Evan's gambit."));
        quotes.add(new Quote("Erwin Schrödinger","If a man never contradicts himself, the reason must be that he virtually never says anything at all."));
        quotes.add(new Quote("Mitch Hedberg","My fake plants died because I did not pretend to water them."));
        quotes.add(new Quote("Jemain","I'm not cryin'. It's just been raining... on my face."));
        quotes.add(new Quote("Bob Wald","Where is my potato?"));
        quotes.add(new Quote("Walt Whitman", "Do I contradict myself? Very well, then I contradict myself, I am large, I contain multitudes."));

        definitions.add(new Definition("Banal","predictable; clichéd; boring"));
        definitions.add(new Definition("Belfry","a bell tower; the room in which a bell is hung"));
        definitions.add(new Definition("Bevy","a group"));
        definitions.add(new Definition("Bilk","to cheat; to defraud"));
        definitions.add(new Definition("Abberant","deviating from the norm"));
        definitions.add(new Definition("Alacrity","eager and enthusiastic willingness"));
        definitions.add(new Definition("Approbation","a expression of approval or praise"));
        definitions.add(new Definition("Capricious","inclined to change one's mind impulsively; erratic, unpredictable"));
        definitions.add(new Definition("Chicanery","trickery or subterfuge"));
        definitions.add(new Definition("Enervate","to weaken; to reduce in vitality"));
        definitions.add(new Definition("Inured","accustomed to accepting something undesirable"));

        responses.add("Yes.");
        responses.add("No.");
        responses.add("Possibly.");
        responses.add("Probably not.");
        responses.add("Probably.");
        responses.add("Try asking again.");
        responses.add("Yes, but only on Tuesdays.");
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
    public Answer getRandomResponse(@RequestBody @Valid Answer question){
        int rand=random.nextInt(responses.size());
        question.setAnswer(responses.get(rand));
        return question;
    }
}
