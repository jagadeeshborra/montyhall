package com.game.montyhall.simulator.service;

import com.game.montyhall.simulator.model.Output;
import com.game.montyhall.simulator.util.MontyHallUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MontyHallService {

    public static final Random gen = new Random();

    @Value( "${simulation.size}" )
    private int simulationSize;

    public String play(int iterations, boolean switches)
    {
        int wins = 0;
        boolean win = false;
        List<Output> outputs = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            win = false;
            int prize = gen.nextInt(3);
            int userChoice1 = gen.nextInt(3);
            //host opens door other than user's choice without prize
            int hostChoice = chooseAnotherDoor(prize, userChoice1);
            // user always switches
            int userChoice2 = 0;
            if(switches)
            {
                userChoice2 = chooseAnotherDoor(userChoice1, hostChoice);
                if (userChoice2 == prize) {
                    wins++;
                    win = true;
                }
            }
            else {
                if (userChoice1 == prize) {
                    wins++;
                    win = true;
                }
            }
            if(iterations<=simulationSize) {
                int[] rooms = {0, 0, 0};
                rooms[prize] = 1;
                outputs.add(new Output(i+1, rooms, switches == false ? userChoice1 + 1 : userChoice2 + 1, switches, win));
            }
        }
        double winPercentage = (wins * 100)/iterations;
        return MontyHallUtil.covertToHTML(outputs, String.format("%.2f", winPercentage), simulationSize);

    }
    /** chooses a random door other than door1 or door2 */
    private int chooseAnotherDoor(int door1, int door2) {
        int result;
        do
            result = gen.nextInt(3);
        while (result == door1 || result == door2);
        return result;
    }
}
