public class Magician extends Character{
    /**
     * effect : create the character name is "Neuah" , job is "magician" and assign character attributes.
     * @param level int (in game character level)
     * @param Hp int (in game character hp)
     * @param Runspeed int (in game character run speed)
     * @param Mana int (in game character mana)
     * @param Strength int (in game character strength)
     * @param Endurance int (in game character special skill)
     * @param Damage int (in game character damage)
     */
    public Magician(int level , int Hp , int Runspeed , int Mana , int Strength , int Endurance , int Damage) {
        super("Neuah" , "Magician", level , Hp , Runspeed , Mana , Strength , "Fast" , Endurance , Damage);
    }

    /**
     * effect : calculate character damage.
     * @return character damage.
     */
    @Override
    protected int calculateBaseDamage() {
        return 10 + getLevel() * 2;
    }

    /**
     * effect : calculate character defense.
     * @return character defense.
     */
    @Override
    protected int calculateBaseDefense() {
        return 5 + getLevel();
    }

    /**
     * effect : calculate sword damage.
     * @return sword damage.
     */
    @Override
    protected int calculateSwordDamage() {
        return (int) (calculateBaseDamage() * (1 + 0.1 * getLevel()));
    }

    /**
     * effect : calculate shield defense.
     * @return shield defense.
     */
    @Override
    protected int calculateShieldDefense() {
        return (int) (calculateBaseDefense() * (1 + 0.05 * getLevel()));
    }

    /**
     * effect : calculate all character attributes.
     */
    @Override
    public void calculateAttributes() {
        int strength = 20 + 2 * getLevel();
        int agility = 15 + getLevel();
        int endurance = 25 + 3 * getLevel();
        int baseRunSpeed = 5 + getLevel();
        double maxRunSpeed = calculateMaxRunSpeed();
    }

    /**
     * effect : calculate character max hp from the level.
     * @return character max hp.
     */
    private int callculateMaxHp(){
        return 100+5*getLevel();
    }

    /**
     * @return maxhp from calculateMaxHp function.
     */
    public  int getMaxHp(){
        return callculateMaxHp();
    }
}
