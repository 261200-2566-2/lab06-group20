public class Sword implements Equipable{
    private String name;
    private int durability;
    private int maxdurability;
    private String damageType;
    private int damageRange;
    private int maxdamageRange;
    private int level;

    /**
     * effect: assign the character's wand which is the level,name,durability,damage type,damage range,max durability and max damage range.
     * @param name String (name of sword.)
     * @param character Character (the character that equip that sword.)
     */
    public Sword(String name,Character character) {
        this.level = character.getLevel();
        this.name = "Sword of Wisdom";
        this.durability = 80;
        this.damageType = "Slash";
        this.damageRange = 15;
        this.maxdurability = 80 + level;
        this.maxdamageRange =20+ level;
    }

    /**
     * effect: "Sword equipped" if the sword is equipped.
     */
    @Override
    public void equip() {
        // Implement Sword-specific equip logic
        System.out.println("Sword equipped.");
    }

    /**
     * effect: ("Repairing " + name) and durability is increased if the sword is repair.
     */
    @Override
    public void repair() {
        System.out.println("Repairing " + name);
        durability = maxdurability; // Restoring durability to 100%
    }

    /**
     * effect: ("Upgrading " + name), maxdurability is increased and maxdamageRange is increased.
     */
    @Override
    public void upgrade() {
        System.out.println("Upgrading " + name);
        maxdurability = 90 + level;
        maxdamageRange = 20 + level;
        // Implementation for upgrade action
    }

    /**
     * effect: ("Comparing " + name + " with " + other.getClass().getSimpleName()),("Durability of " + name + " is " + durability ),("Damage type of " + name + " is " + damageType ),System.out.println("Damage range of " + name + " is " + damageRange ) and ("level " + level) if sword is compare.
     * @param other from Interface Equipable which is other equipment that this sword want to compare with.
     */
    @Override
    public void compare(Equipable other) {
        System.out.println("Comparing " + name + " with " + other.getClass().getSimpleName());
        System.out.println("Durability of " + name + " is " + maxdurability );
        System.out.println("Damage type of " + name + " is " + damageType );
        System.out.println("Damage range of " + name + " is " + maxdamageRange );


        // Implementation for compare action
    }

    /**
     * effect: ("Slashing attack on " + target.getJob() + ".") when character that equipped wand useSkill to other character.
     * @param target from Class Character which is other character that this character useSkill with.
     */
    @Override
    public void useSkill(Character target) {
        // Implement Sword-specific skill logic
        System.out.println("Slashing attack on " + target.getJob() + ".");
    }

    /**
     * effect: when the wand get special move. It will return "Powerful Slash"
     * @return "Powerful Slash" if wand is got special move.
     */
    @Override
    public String getSpecialMove() {
        return "Powerful Slash";
    }


}
