package Day231013;

public class Box {
    public static void main(String[] args) {
        System.out.println(categorizeBox(3000,3000,4000,727));
    }
    public static String categorizeBox(int length, int width, int height, int mass) {
        long v = length*width*height;
        boolean isBulky = false;
        if(length>=10000||width>=10000||height >=10000|| v>= 1000000000L) isBulky = true;
        if(mass>=100) return isBulky?"Both":"Heavy";
        return isBulky?"Bulky":"Neither";
}
