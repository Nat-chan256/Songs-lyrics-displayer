package ru.tuturu.songsdisplayer.util;

public class StringUtil {

    public static String extractFirstLines(int linesNumber, String text){
        String[] lines = text.split("\n");
        String result = "";
        for (int i = 0 ; i < lines.length && i < linesNumber; ++i)
            result += lines[i] + "\n";
        return result;
    }
}
