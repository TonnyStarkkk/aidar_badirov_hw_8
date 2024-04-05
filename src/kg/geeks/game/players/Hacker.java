package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Hacker extends Hero{
    public Hacker(int health, int damage, String name){
        super(health, damage, SuperAbility.HACKER, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int hacker = RPG_Game.random.nextInt(200);
        int num = RPG_Game.random.nextInt(heroes.length);
        boss.setHealth(boss.getHealth()-hacker);
        heroes[num].setHealth(heroes[num].getHealth()+hacker);
        System.out.println(this.getName() + " stealed" + hacker + " health points from boss and gave it to " +
                heroes[num].getName());
    }
}
