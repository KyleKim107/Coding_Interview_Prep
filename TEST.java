import java.util.*;
import java.io.*;
public class TEST {
    public static void main(String[] args) {
        int currX = 150,  currY = 100;
        int oppX = 0,  oppY = 127;
        double angle = Math.atan2( oppY - currY,  oppX - currX);
        System.out.println(Math.PI);
        System.out.println(Math.toDegrees(angle));
    }
    
}
