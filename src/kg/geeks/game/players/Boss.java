package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk
                        && this.defence != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                    int coeff = RPG_Game.random.nextInt(2) + 1; // 1,2
                    ((Berserk) heroes[i]).setBlockedDamage(5 * coeff);
                    heroes[i].setHealth(heroes[i].getHealth() -
                            (this.getDamage() - ((Berserk) heroes[i]).getBlockedDamage()));
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }

    public void chooseDefence() {
        SuperAbility[] elements = SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(elements.length); // 0,1,2,3
        this.defence = elements[randomIndex];
    }

    public SuperAbility getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " + this.defence;
    }
}
