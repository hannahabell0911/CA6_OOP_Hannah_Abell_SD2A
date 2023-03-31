package com.dkit.oop.Comparator;
import com.dkit.oop.dto.Albums;
import java.util.Comparator;

public class AlbumPriceComparator implements Comparator<Albums> {

    @Override
    public int compare(Albums a1, Albums a2) {
        return Float.compare(a2.getPrice(), a1.getPrice());
    }
}
