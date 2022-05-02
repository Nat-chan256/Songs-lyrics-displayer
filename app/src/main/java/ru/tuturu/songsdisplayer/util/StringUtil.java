package ru.tuturu.songsdisplayer.util;

public class StringUtil {

    public static String extractFirstLines(int linesNumber, String text){
        String[] lines = text.split("\n");
        String result = "";
        for (int i = 0 ; i < lines.length && i < linesNumber; ++i)
            result += lines[i] + "\n";
        return result;
    }

    // Removes label "***** This Lyrics is NOT for commercial use *******"
    public static String removeWarningLabel(String text){
        return text.substring(0, text.indexOf("*"));
    }
}
