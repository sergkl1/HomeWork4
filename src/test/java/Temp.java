import java.util.Random;

/**
 * Created by sergey.kliepikov on 11/23/18.
 */
public class Temp {
    private static final String CHARACTERS_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String randomCharacters(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*CHARACTERS_STRING.length());
            builder.append(CHARACTERS_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Temp.randomCharacters(5);

        System.out.println(Math.random());
        Random rnd = new Random();
        Double price = 0.1 + (100 - 0.1) * rnd.nextDouble();
        System.out.println(price);
        System.out.println(price.toString());
    }
}
