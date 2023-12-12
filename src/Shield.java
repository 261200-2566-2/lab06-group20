public class Shield implements Equipable{
    private String name;
    private int durability;
    private String damageType;
    private int damageRange;
    private int maxdamageRange;
    private int maxdurability;
    private int level;

    /**
     * effect: assign the character's shield which is the level,name,durability,damage type,damage range,max durability and max damage range.
     * @param name String (name of shield.)
     * @param character Character (the character that equip that wand.)
     */
    public Shield(String name, Character character) {
        this.name = name;
        this.durability = 70;
        this.damageType = "Block";
        this.damageRange = 5;
        this.maxdurability = 80 + level;
        this.maxdamageRange =20+ level;
    }

    /**
     * effect: ("Equipping " + name) if the shield is equipped.
     */
    @Override
    public void equip() {
        System.out.println("Equipping " + name);
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
     * effect: ("Upgrading " + name), maxdurability is increased and maxdamageRange is increased if the sword is upgraded.
     */
    @Override
    public void upgrade() {
        System.out.println("Upgrading " + name);
        maxdurability = 90 + level;
        maxdamageRange = 20 + level;
        // Implementation for upgrade action
    }

    /**
     * effect: ("Comparing " + name + " with " + other.getClass().getSimpleName()),("Durability of " + name + " is " + durability ),("Damage type of " + name + " is " + damageType ),System.out.println("Damage range of " + name + " is " + damageRange ) and ("level " + level) if shield is compare.
     * @param other from Interface Equipable which is other equipment that this shield want to compare with.
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
     * effect: ("Spell on " + target.getJob() + ".") when character that equipped shield useSkill to other character.
     * @param target from Class Character which is other character that this character useSkill with.
     */
    @Override
    public void useSkill(Character target) {
        System.out.println("Blockkkk"+ target.getJob() + ".");
        // No special skill for shields
    }

    /**
     * effect: when the wand get special move. It will return "block"
     * @return "block" if wand is got special move.
     */
    @Override
    public String getSpecialMove() {
        return "block";
    }
}
