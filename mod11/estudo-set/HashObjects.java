import java.util.Set;
import java.util.HashSet;

public class HashObjects {

    static Set<HashStudyClass> bands = new HashSet<HashStudyClass>();



    public static void main(String[] args) {
        HashStudyClass band1 = new HashStudyClass("Skid Row", "Rock", 15);
        HashStudyClass band2 = new HashStudyClass("Elvis", "Rock", 14);
        HashStudyClass band3 = new HashStudyClass("Panic!", "Pop", 15);
        HashStudyClass band4 = new HashStudyClass("Taylor", "Pop", 40);
        HashStudyClass band5 = new HashStudyClass("Jackson", "Country", 25);
        bands.add(band1);
        bands.add(band2);
        bands.add(band3);
        bands.add(band4);
        bands.add(band5);

        System.out.println(bands);

    }

}
