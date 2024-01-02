package me.packwatch.quarryskills.utils;

import java.util.HashMap;
public class SkillXpConverter {
    /*
      Method takes an integer value of skill experience
      from database and converts it to a skill level
      based on an array of corresponding skill xp requirements.
      the value returned is (level, overflow/progress to next)
     */
    public static double[] skillXpToLvlAndOverflow(double xp, int[] xp_requirements){
        double skillLvl = 0;
        double[] results = new double[3];
        for (int i = 0; i < xp_requirements.length; i++) {
            if (xp >= xp_requirements[i]){
                xp -= xp_requirements[i];
                skillLvl++;
                if (skillLvl== xp_requirements.length){
                    results[0] = skillLvl;
                    results[1] = xp;
                    results[2] = -1;
                    return results;
                }

            } else {
                results[0] = skillLvl;
                results[1] = xp;
                results[2] =  (double) Math.round(((float) xp / xp_requirements[i + 1]) * 100) /100;
                return results;
            }

        }
        return results;
    }
}
