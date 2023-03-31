package whatever.hand_cricket;

import java.util.*;
public class we_see
{
    public static void main(String[] args){
        battle battle_obj= new battle();
        battle_obj.playtime();
    }
}

class players
{
    String player1, player2="Computer";
    Scanner sc = new Scanner(System.in);
    Random rn= new Random();
    protected int p1_num,p2_num,ch_1,ch_2;

    public void odd_eve(){
        System.out.println("1.Odd or 2.Even?");
        ch_1=sc.nextInt();

        System.out.println("Your number:");
        ch_2=sc.nextInt();
    }
    public void play(){
        System.out.println("Number:");
        p1_num=sc.nextInt();
        if(p1_num<=10 && p1_num>0) {
            System.out.println(player1+" played : " + p1_num);
            p2_num = rn.nextInt(1, 11);
            System.out.println(player2+" played: " + p2_num);
            System.out.println("------------------");
        }

        else{
            System.out.println("Fraudlent play found!");
        }
    }
}

class battle extends players {
    protected int choice,toss,p1_tot, p2_tot,init;

    public void mech_bat(){
        System.out.println(player1 + "'s turn to bat:");
        do {
            play();
            if (p1_num == p2_num) {
                System.out.println("You are out!");
            }
            else {
                p1_tot = p1_tot + p1_num;
            }
        } while (p1_num != p2_num);

        System.out.println(player1 + "'s final score: " + p1_tot);

        System.out.println(player2 + "'s turn:");
        do {
            play();
            if (p1_num == p2_num) {
                System.out.println("Computer is out!");
            }
            else {
                p2_tot = p2_tot + p2_num;
                if (p2_tot > p1_tot) {
                    break;
                }
            }
        } while (p1_num != p2_num);

        System.out.println(player2 + "'s final score: " + p2_tot);
    }

    public void mech_ball(){
        System.out.println(player2 + "'s turn to bat:");
        do {
            play();
            if (p2_num == p1_num) {
                System.out.println("Computer is out!");
            }
            else {
                p2_tot = p2_tot + p2_num;
            }
        } while (p2_num != p1_num);

        System.out.println(player2 + "'s final score: " + p2_tot);

        System.out.println(player1 + "'s turn:");
        do {
            play();
            if (p2_num == p1_num) {
                System.out.println("You are out!");
            }
            else {
                p1_tot = p1_tot + p1_num;
                if (p1_tot > p2_tot) {
                    break;
                }
            }
        } while (p2_num != p1_num);

        System.out.println(player1 + "'s final score: " + p1_tot);
    }
    public void playtime() {
        System.out.println("Enter name of player 1:");
        player1 = sc.next();

        odd_eve();
        if(ch_1==1){
            if(ch_2<=10 && ch_2>0) {
                init = rn.nextInt(1, 11);
                toss = ch_2 + init;
                System.out.println(player2 + " : " + init);
                if (toss % 2 != 0) {
                    System.out.println("Toss = " + toss + ",you win");
                    System.out.println("What would you like to choose?\n1.Bat\n2.Ball");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> mech_bat();
                        case 2 -> mech_ball();
                        default -> System.out.println("Wrong choice, how can somebody be so dumb?");
                    }
                } else {
                    System.out.println("Toss = " + toss + ",you lose");
                    choice = rn.nextInt(1, 3);
                    System.out.println(player2 + " chooses \n1.Bat\n2.Ball\n" + choice);

                    switch (choice) {
                        case 1 -> mech_ball();
                        case 2 -> mech_bat();
                        default -> System.out.println("Wrong choice, how can somebody be so dumb?");
                    }
                }
            }
            else{
                System.out.println("Fradulent play detected!");
            }
        }
        else if(ch_1==2){
            if(ch_2<=10 && ch_2>0) {
                init = rn.nextInt(1, 11);
                toss = ch_2 + init;
                System.out.println(player2 + " : " + init);
                if (toss % 2 == 0) {
                    System.out.println("Toss = " + toss + ",you win");
                    System.out.println("What would you like to choose?\n1.Bat\n2.Ball");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> mech_bat();
                        case 2 -> mech_ball();
                        default -> System.out.println("Wrong choice, how can somebody be so dumb?");
                    }
                } else {
                    System.out.println("Toss = " + toss + ",you lose");
                    choice = rn.nextInt(1, 3);
                    System.out.println(player2 + " chooses \n1.Bat\n2.Ball\n" + choice);

                    switch (choice) {
                        case 1 -> mech_ball();
                        case 2 -> mech_bat();
                        default -> System.out.println("Wrong choice, how can somebody be so dumb?");
                    }
                }
            }
            else{
                System.out.println("Fradulent play detected!");  //Implements check
            }
        }
        else{
            System.out.println("Learn to read before playing with me smartass"); // Can't leave else part as legal condition
        }

        if (p1_tot > p2_tot) {
            System.out.println(player1 + " has won the game!! You got me this time!!");
            System.out.println(player1 + "'s score: " + p1_tot + "\t||\t" + player2 + "'s score: " + p2_tot);
        }
        else if (p2_tot > p1_tot) {
            System.out.println("Computer has won the game!! Hahaha, I got you!!");
            System.out.println(player2 + "'s score: " + p2_tot + "\t||\t" + player1 + "'s score: " + p1_tot);
        }
        else {
            System.out.println("Tie game! We should have a rematch!");
            System.out.println(player1 + "'s score: " + p1_tot + "\t||\t" + player2 + "'s score: " + p2_tot);
            //Any kind of misplay results in tie, might need changes later
        }
    }
}
