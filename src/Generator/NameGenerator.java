package Generator;

import java.util.Random;

public class NameGenerator {
    private static final Random rand = new Random();
    private static final String[] peoples = {"Bob","Jill","Tom","Brandon","Alice","David","Emma","Liam","Olivia","Noah",
            "Sophia","James","Isabella","Benjamin","Mia","Lucas","Charlotte","Henry","Amelia","Alexander",
            "Evelyn","Michael","Abigail","Daniel","Harper","Matthew","Ella","Joseph","Avery","Samuel",
            "Scarlett","Sebastian","Grace","Jack","Chloe","Owen","Victoria","Theodore","Riley","Aiden",
            "Aria","Logan","Lily","Nathan","Aurora","Ryan","Zoey","Caleb","Hannah","Isaac"
    };
    private static final String[] armies = {
            "Iron Legion",
            "Crimson Battalion",
            "Shadow Brigade",
            "Storm Division",
            "Thunder Regiment",
            "Golden Phalanx",
            "Steel Vanguard",
            "Black Sentinel",
            "Wolf Company",
            "Dragon Guard"
    };


    public static String getName() {
        int index = rand.nextInt(peoples.length);
        return peoples[index];
    }

    public static String getArmies() {
        int index = rand.nextInt(armies.length);
        return armies[index];
    }
}
