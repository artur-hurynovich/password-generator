package passwordGenerator;
import java.util.Random;
public class Generator {
    private StringBuilder passwordBuilder;
    private Complexity complexity;
    private int count;
    private Random random;
    public Generator(Complexity complexity, int count){
        this.passwordBuilder = new StringBuilder();
        this.complexity = complexity;
        this.count = count;
        this.random = new Random();
    }
    public String generate(){
        String password;
        passwordBuilder.delete(0, passwordBuilder.length());
        switch (complexity){
            case MIN: password = generateMin(); break;
            case MID: password = generateMid(); break;
            case MAX: password = generateMax(); break;
            default: password = "";
        }
        return password;
    }
    private String generateMin(){
        for (int i = 0; i < count; i++){
            passwordBuilder.append((char)(random.nextInt(26) + 97));
        }
        return new String(passwordBuilder);
    }
    private String generateMid(){
        Random secondaryRandom = new Random();
        int value;
        for (int i = 0; i < count; i ++){
            value = secondaryRandom.nextInt(2);
            if (value == 0) passwordBuilder.append((char)(random.nextInt(26) + 97));
            if (value == 1) passwordBuilder.append(random.nextInt(9) + 1);
        }
        return new String(passwordBuilder);
    }
    private String generateMax(){
        Random secondaryRandom = new Random();
        int value;
        for (int i = 0; i < count; i ++){
            value = secondaryRandom.nextInt(3);
            if (value == 0) passwordBuilder.append((char)(random.nextInt(26) + 97));
            if (value == 1) passwordBuilder.append(random.nextInt(9) + 1);
            if (value == 2) passwordBuilder.append((char)(random.nextInt(26) + 65));
        }
        return new String(passwordBuilder);
    }
}