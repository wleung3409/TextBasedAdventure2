package Game;

import People.Person;
import Rooms.Room;
import Rooms.Diamonds;
import Rooms.Gold;

import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        Room[][] building = new Room[3][8];

        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

        String[][] secondfloor = new String[3][8];
        Board board = new Board(secondfloor);
        board.fill("[ ]");
        board.edit("[X]", 0,0);

        System.out.println("You were going through your routine on mining and suddenly a boulder chases you!");
        System.out.println("You were forced to jump in a hole and barely escape, however you can hear the boulder slowly coming in");
        System.out.println("Luckily, at the end of the tunnel, you see light, better yet however, you see gold and diamond shining all around you");
        System.out.println("You can't see anything and must escape while grabbing as much fortunate as you can!");
        System.out.println("Run to the right while grabbing as much diamond and gold as you can. You have 7 turns to live");

        System.out.println(board);

        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new Gold(x, y);
        int z = (int)(Math.random()*building.length);
        int i = (int)(Math.random()*building.length);
        building[z][i] = new Diamonds(z,i);

        Person player1 = new Person("FirstName", "FamilyName", 0,0,0);
        building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(validMove(move, player1, building))
            {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                board.edit("{X}",player1.getxLoc(),player1.getyLoc());
                System.out.println(board);
            }
            else {
                System.out.println("Please choose a valid move.");
            }


        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}