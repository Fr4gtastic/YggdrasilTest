public class Box {

    private int reward;
    private Bonus bonus;

    public Box(int reward) {
        this.reward = reward;
    }

    public Box(Bonus bonus) {
        this.bonus = bonus;
    }

    public int getReward() {
        return reward;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
