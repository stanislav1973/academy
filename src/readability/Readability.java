package readability;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Readability {
     static StringBuilder stringBuilder = new StringBuilder();
     static int words;
     static int sentences;
     static int characters;
     static int syllables;
     static int polysyllables;
    
    public int getPolysyllabicWords(String text, String regex, boolean b) {
        int numberPolysyllabic = 0;
        String[] items = text.split("\\s");
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        for (String item : items) {
            int count = 0;
            Matcher matcher = p.matcher(item);
            while (matcher.find()) {
                count++;
                if(b) {
                    if (count > 2) {
                        numberPolysyllabic++;
                        break;
                    }
                }
                else {
                    if(count > 3) {
                        numberPolysyllabic++;
                        break;
                    }
                }
            }
        }
        return numberPolysyllabic;
    }
    public int findVowels(String regex, StringBuilder string) {
        int count = 0;
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(string);
            while (m.find()) {
                count++;
            }
        return count;
    }
    public String splitText(String text, String regex, boolean b) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            if(m.group().matches("[Ss]he")) {
                continue;
            }
            if(b) {
                stringBuilder.append(m.group()).append(" ");
            }
            text = text.replaceAll("\\b" + m.group() + "\\b", "");
        }
        return text;
    }
    public void getOptions(String option) {
        double scoreARI = (4.71 * characters) / words + (0.5 * words) / sentences  - 21.43;
        double scoreFK = (0.39 * words) / sentences + (11.8 * (syllables - 1)) / words - 15.59;
        double scoreSMOG = 1.043 * Math.sqrt(polysyllables * 30.0 / sentences) + 3.1291;
        double L = characters / (double)words * 100;
        double S = sentences / (double)words * 100;
        double scoreCL = (0.0588 * L) - (0.296 * S) - 15.8;
        switch (option) {
            case "ARI":
                System.out.printf("Automated Readability Index: %.2f (about %.0f-year-olds).",scoreARI, Math.floor(scoreARI) < 13 ? Math.floor(scoreARI) + 6 : 24 );
                break;
            case "FK":
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %.0f-year-olds).",scoreFK, Math.floor(scoreFK) < 13 ? Math.floor(scoreFK) + 6 : 24 );
                break;
            case "SMOG":
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %.0f-year-olds).",scoreSMOG, Math.floor(scoreSMOG) < 13 ? Math.floor(scoreSMOG) + 6 : 24 );
                break;
            case "CL":
                System.out.printf("Coleman–Liau index: %.2f (about %.0f-year-olds).",scoreCL, Math.floor(scoreCL) < 13 ? Math.floor(scoreCL) + 6 : 24 );
                break;
            case "all":
                System.out.printf("Automated Readability Index: %.2f (about %.0f-year-olds).\n",scoreARI, Math.floor(scoreARI) < 13 ? Math.floor(scoreARI) + 6 : 24 );
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %.0f-year-olds).\n",scoreFK, Math.floor(scoreFK) < 13 ? Math.floor(scoreFK) + 6 : 24 );
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %.0f-year-olds).\n",scoreSMOG, Math.floor(scoreSMOG) < 13 ? Math.floor(scoreSMOG) + 6 : 24 );
                System.out.printf("Coleman–Liau index: %.2f (about %.0f-year-olds).\n",scoreCL, Math.floor(scoreCL) < 13 ? Math.floor(scoreCL) + 6 : 24 );
                break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Readability readability = new Readability();
        String regexSplitText = "(\\w+[^le]e\\b)|(\\w+es\\b)|(\\b[^WwMmHh]e\\b)";
        String regexVowel = "([e][yueai])|([a][yiuo])|([o][oauiy])|(le\\b)|(ld\\b)|(nd\\b)|(\\b[UAIEO])|([aueio])|(\\By)";
        String text = "";
        try {
        text = new Scanner(new File(args[0])).nextLine();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        words = text.split("\\s").length;
        sentences = text.split("[.?!:;]").length;
        characters = text.replaceAll("\\s","").length();
        text = readability.splitText(text, regexSplitText, true);
        text = readability.splitText(text,"(of)|(at)|([Aa])", false);
        int numberWordOpenE = stringBuilder.toString().split("\\s").length;
        syllables = readability.findVowels(regexVowel, new StringBuilder(text + " " + stringBuilder)) - numberWordOpenE;
        int openE = readability.getPolysyllabicWords(stringBuilder.toString(), regexVowel, false);
        int openAndClose =  readability.getPolysyllabicWords(text, regexVowel, true);
        polysyllables = openAndClose + openE;
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.printf("Syllables: %d\n", syllables - 1);
        System.out.printf("Polysyllables: %d\n", polysyllables);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String option = scanner.next();
        System.out.println();
        readability.getOptions(option);

    }
}
