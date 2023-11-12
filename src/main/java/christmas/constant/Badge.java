package christmas.constant;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);


    private final String badgeName;
    private final long prize;

    Badge(String badgeName, long prize){
        this.badgeName = badgeName;
        this.prize = prize;
    }

    public String getBadgeName(){
        return badgeName;
    }

    public long getPrize(){
        return prize;
    }
}
