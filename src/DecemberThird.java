import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DecemberThird {

    private long gamma;
    private long epsilon;
    private int faultCounter;
    private int lineLength;
    private File inputs;
    private Scanner fileReader;
    private ArrayList<Integer> countAll1;
    private ArrayList<Integer> countAll0;
    private String gammaRate;
    private String epsilonRate;

    public DecemberThird(){
        gamma = 0;
        epsilon = 0;
        countAll1 = new ArrayList<>();
        countAll0 = new ArrayList<>();
        gammaRate = "";
        epsilonRate = "";
    }

    public void setLineLenght(){
        String line = fileReader.nextLine();;
        this.lineLength = line.length();
    }

    public void resetCounters(){
        faultCounter = 0;
    }

    public void setFile(String path){
        inputs = new File(path);
    }

    public void setScanner(File file){
        try {
            fileReader = new Scanner(file);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void compareCountSetGammaEpsilon(){
        for(int i = 0; i<countAll1.size();i++){
            if(countAll1.get(i)>countAll0.get(i)){
                gammaRate = gammaRate.concat("1");
                epsilonRate = epsilonRate.concat("0");
            } else if(countAll1.get(i)<countAll0.get(i)){
                gammaRate = gammaRate.concat("0");
                epsilonRate = epsilonRate.concat("1");
            }else{
                faultCounter++;
            }
        }
    }

    public void countForEachIndexInLine(int index){
        int counter1 = 0;
        int counter0 = 0;

        while(fileReader.hasNextLine()){
            String line = fileReader.nextLine();
            char number = line.charAt(index);
            if(number == '0'){
                counter0++;
            }else if(number == '1'){
                counter1++;
            }else{
                faultCounter++;
            }
        }
        countAll1.add(counter1);
        countAll0.add(counter0);
    }

    public void fillCountArrays(){
        setScanner(inputs);

        for(int i = 0; i<this.lineLength; i++){
            countForEachIndexInLine(i);
            setScanner(inputs);
        }
    }

    public void binaryCodeToNumber(){
        gamma = Integer.parseInt(gammaRate,2);
        epsilon = Integer.parseInt(epsilonRate,2);
    }



    public long getGamma() {
        return gamma;
    }

    public void setGamma(int gamma) {
        this.gamma = gamma;
    }

    public int getFaultCounter() {
        return faultCounter;
    }

    public void setFaultCounter(int faultCounter) {
        this.faultCounter = faultCounter;
    }

    public File getInputs() {
        return inputs;
    }

    public Scanner getFileReader() {
        return fileReader;
    }

    public void setCountAll0(ArrayList<Integer> countAll0) {
        this.countAll0 = countAll0;
    }

    public int getIndexCountAll0(int index) {
        return countAll0.get(index);
    }

    public void setCountAll1(ArrayList<Integer> countAll1) {
        this.countAll1 = countAll1;
    }

    public ArrayList<Integer> getCountAll1() {
        return countAll1;
    }

    public long getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(int epsilon) {
        this.epsilon = epsilon;
    }

    public String getGammaRate() {
        return gammaRate;
    }

    public String getEpsilonRate() {
        return epsilonRate;
    }

    public static void main(String[] args) {

        DecemberThird testThird = new DecemberThird();

        testThird.setFile("src/DecemberThird.txt");
        testThird.setScanner(testThird.inputs);
        testThird.setLineLenght();

        testThird.fillCountArrays();
        testThird.compareCountSetGammaEpsilon();
        testThird.binaryCodeToNumber();


        long result = testThird.gamma*testThird.epsilon;

        System.out.println("Result part 1: " + (result));


    }

}
