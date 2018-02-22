package com.android.rexben.language;

/**
 * Created by Rexben on 2/15/2018.
 */

public class ReportCard {

    private int scoreEnglish = 70;
    private int scoreFrench = 81;
    private int scoreGerman = 89;
    private int scoreChinese = 91;

    public ReportCard (int gradeE, int gradeF, int gradeG, int gradeC){
        scoreEnglish = gradeE;
        scoreGerman =gradeG;
        scoreChinese = gradeC;
        scoreFrench = gradeF;

    }

    public int getScoreChinese() {
        return scoreChinese;
    }

    public int getScoreEnglish() {
        return scoreEnglish;
    }

    public int getScoreFrench() {
        return scoreFrench;
    }

    public int getScoreGerman() {
        return scoreGerman;
    }

    @Override
    public String toString() {
        return "John Ben; English 80, Maths 77, History, 77";
    }
}
