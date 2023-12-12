public abstract class Character implements CharacterActions {
    protected String name;
    private String job;
    private int level;
    protected int maxHp;
    protected int maxMana;
    protected int Strength;
    protected String Agility;
    protected int Endurance;
    protected int Damage;
    public int baseRunSpeed;
    public int maxRunSpeed;
    private Equipable equipment;
    private boolean isMagicianTransparent;

    public int getLevel() {
        return level;
    }
    public String getJob() {
        return job;
    }

//    public int getMaxHp() {
//        return maxHp;
//    }

    /**
     * effect : assign the in game character which is the name , agility , job , level , hp , mana , damage ,  strength , character special skill(endurance) and run speed.
     * @param name String (name of character)
     * @param job String (types of job)
     * @param level int (in game character level)
     * @param Hp int (in game character hp)
     * @param Runspeed int (in game character run speed)
     * @param Mana int (in game character mana)
     * @param Strength int (in game character strength)
     * @param Agility int (in game character agility)
     * @param Endurance int (in game character special skill)
     * @param Damage int (in game character damage)
     */
    public Character(String name , String job , int level , int Hp , int Runspeed , int Mana , int Strength , String Agility , int Endurance , int Damage) {
        this.name = name;
        this.Agility = Agility;
        this.job = job;
        this.level = level;
        this.maxHp = Hp;
        this.maxMana = Mana;
        this.Damage = Damage;
        this.Endurance = Endurance;
        this.Strength = Strength;
        this.maxRunSpeed = Runspeed;
        calculateAttributes();
    }

    protected abstract int calculateBaseDamage();

    protected abstract int calculateBaseDefense();

    protected abstract int calculateSwordDamage();

    protected abstract int calculateShieldDefense();

    protected abstract void calculateAttributes();

    /**
     *effect : calculate the character max run speed.
     */
    protected int calculateMaxRunSpeed() {
        return (int) (baseRunSpeed * (0.1 + 0.03 * level));
    }


    /**
     * effect : if character hold the equipment , character will have increase the run speed.
     * @param equipment use from equipment class to see what equipment is character holding.
     */
    public void setEquipment(Equipable equipment) {
        this.equipment = equipment;
        equipment.equip();
        // Slow down character's runspeed if holding equipment
        if (equipment != null) {
            System.out.println(name + " : Equipment equipped. Slowing down runspeed.");
            System.out.println("Runspeed decreased to  " + (maxRunSpeed-5*level));
        }
    }

    /**
     * effect : apply damage to the target character.
     * @param target to see what is character target.
     */
    @Override
    public void attack(Character target) {
        int actualDamage = calculateActualDamage(target);
        // Apply damage to the target character
        target.receiveDamage(actualDamage , target);
    }

    /**
     * effect : calculate all damage to hit the target.
     * @param target to see what is character target.
     * @return all damage calculated has been completed.
     */
    private int calculateActualDamage(Character target) {
        int Damage = 10;

        if (isMagicianTransparent) {
            // Reduce damage by 10% if magician is transparent
            Damage = (int) (Damage - (0.1 * Damage));
        }
        return Damage;
    }

    /**
     * effect : the target takes damage from the attack.
     * @param amount assign = netDamage.
     * @param someoneelse = selected target to attack.
     */
    private void receiveDamage(int amount , Character someoneelse) {
        // Apply damage to character's HP
        int netDamage = amount;
        if (netDamage > 0) {
            someoneelse.maxHp -= netDamage;
            System.out.println(name + " : Received " + netDamage + " damage.");
            System.out.println("Now " + name + " have " + someoneelse.maxHp + " maxHp");
        } else {
            System.out.println(name + " : No damage received.");
        }
    }

    /**
     * effect : each character can use their special skills.
     * @param target to see what is character target.
     */
    public void useSkill(Character target) {
        if ("Magician".equals(job)) {
            System.out.println("Magician using special skill: " + equipment.getSpecialMove());
            equipment.useSkill(target);
        } else if ("Warrior".equals(job)) {
            System.out.println("Warrior using special skill: " + equipment.getSpecialMove());
            equipment.useSkill(target);
        }
    }


    // Getters and setters for other attributes
}
