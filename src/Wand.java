
public class Wand implements Equipable{

    private String name;
    private int durability;
    private String damageType;
    private int damageRange;
    private int maxdamageRange;
    private int maxdurability;
    private int level;


    /**
     * effect: assign the character's wand which is the level,name,durability,damage type,damage range,max durability and max damage range.
     * @param name String (name of wand.)
     * @param character Character (the character that equip that wand.)
     */
    public Wand(String name,Character character) {
        this.level = character.getLevel();
        this.name = "The Holy wand";
        this.durability = 90;
        this.damageType = "Magic";
        this.damageRange = 15;
        this.maxdurability = 80 + level;
        this.maxdamageRange =20+ level;
    }

    /**
     * effect: "Wand equipped" if the wand is equipped.
     */
    @Override
    public void equip() {
        // Implement Sword-specific equip logic
        System.out.println("Wand equipped.");
    }

    /**
     * effect: ("Repairing " + name) and durability is increased if the wand is repair.
     */
    @Override
    public void repair() {
        System.out.println("Repairing " + name);
        durability = maxdurability; // Restoring durability to 100%

    }

    /**
     * effect: ("Upgrading " + name), maxdurability is increased and maxdamageRange is increased if the wand is upgraded.
     */
    @Override
    public void upgrade() {
        System.out.println("Upgrading " + name);
        maxdurability = 90 + level;
        maxdamageRange = 20 + level;
    }

    /**
     * effect: ("Comparing " + name + " with " + other.getClass().getSimpleName()),("Durability of " + name + " is " + durability ),("Damage type of " + name + " is " + damageType ),System.out.println("Damage range of " + name + " is " + damageRange ) and ("level " + level) if wand is compare.
     * @param other from Interface Equipable which is other equipment that this wand want to compare with.
     */
    @Override
    public void compare(Equipable other) {
        System.out.println("Comparing " + name + " with " + other.getClass().getSimpleName());
        System.out.println("Durability of " + name + " is " + durability );
        System.out.println("Damage type of " + name + " is " + damageType );
        System.out.println("Damage range of " + name + " is " + damageRange );
        System.out.println("level " + level);
        // Implementation for compare action
    }

    /**
     * effect: ("Spell on " + target.getJob() + ".") when character that equipped wand useSkill to other character.
     * @param target from Class Character which is other character that this character useSkill with.
     */
    @Override
    public void useSkill(Character target) {
        // Implement Sword-specific skill logic
        System.out.println("Spell on " + target.getJob() + ".");
    }

    /**
     * effect: when the wand get special move. It will return "Magic Bolt"
     * @return "Magic Bolt" if wand is got special move.
     */
    @Override
    public String getSpecialMove() {
        return "Magic Bolt";
    }
}


