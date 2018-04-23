package Du;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Du {
    private final boolean sumSize;
    private final boolean format;
    private final boolean unit;


    public Du(boolean sunSize, boolean format, boolean unit) {
        this.sumSize = sunSize;
        this.format = format;
        this.unit = unit;
    }

    private

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
    public List answer(String[] fileN) {
        String[] list = {"B", "KB", "MB", "GB"};
        List answerList = new ArrayList();
        long s = 0;
        long size;
        int n = 1024;
        int form;
        if (unit) n = 1000;
        for (int i = 0; i < fileN.length; i++) {
            File file = new File(fileN[i]);
            if (!file.exists()) {
                answerList.clear();
                answerList.add("1 - ошибка");
                return answerList;
            }
            if (sumSize) s += fileSize(file);
            else {
                size = fileSize(file);
                if (format) {
                    form = 0;
                    while (size / n > 0) {
                        size /= n;
                        form++;
                    }
                    answerList.add("Размер " + fileN[i] + " равен " + size + " " + list[form]);
                } else {
                    size /= n;
                    answerList.add("Размер " + fileN[i] + " равен " + size);
                }
            }
        }
        if (sumSize) {
            if (format) {
                form = 0;
                while (s / n > 0) {
                    s /= n;
                    form++;
                }
                answerList.add("Суммарный размер равен " + s + " " + list[form]);
            } else {
                s /= n;
                answerList.add("Суммарный размер равен " + s);
            }
        }
        return answerList;
    }

    public void outWriter(List ansList) {
        for (int i = 0; i < ansList.size(); i++) System.out.println(ansList.get(i));
    }
}
