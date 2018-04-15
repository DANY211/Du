package Du;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Du {
    privat final boolean sumSize;
    privat final boolean format;
    privat final boolean unit;


    public Du(boolean sunSize, boolean format, boolean unit) {
        this.sumSize = sunSize;
        this.format = format;
        this.unit = unit;
    }

    privat

    long fileSize(File file) {
        if (!file.isDirectory()) return file.length();
        else {
            File[] list = file.listFiles();
            long a = 0;
            for (int i = 0; i <= list.length - 1; i++) {
                if (list[i].isDirectory()) a += fileSize(list[i]);
                else a += list[i].length();
            }
            return a;
        }
    }
    public list answer(String[] fileN){
        String[] list = {"B","KB","MB","GB"};
        List ansList = new ArrayList();
        long a = 0;
        long size;

    }
}
