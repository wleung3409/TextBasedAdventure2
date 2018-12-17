package Rooms;

import Game.Runner;
import People.Person;

public class UnluckyRoom extends Room
{
    public UnluckyRoom(int z, int i) {
        super(z, i);

    }

    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("Very unfortunate, you lose!.");
        Runner.gameOff();
    }


}