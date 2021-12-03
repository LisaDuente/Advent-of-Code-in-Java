public class Main {
    public static void main(String[] args) {
        DecemberOfCode december2021 = new DecemberOfCode();

        int resultDay1 = december2021.DecemberFirst();
        System.out.println("Day 1: " + resultDay1);

        int resultDay1P2 = december2021.DecemberFirstPart2();
        System.out.println("Day 1: " + resultDay1P2);

        DecemberSecond day2 = new DecemberSecond();

        int resultDay2P1 = day2.DecemberSecondPart1();
        System.out.println("Day 2: "+resultDay2P1);

        day2 = new DecemberSecond();
        int resultDay2P2 = day2.DecemberSecondPart2();
        System.out.println("Day 2: "+resultDay2P2);
    }
}
