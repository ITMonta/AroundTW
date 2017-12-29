/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.services;

/**
 *
 * @author Monta
 */
public class ControlSaisie {
    public boolean isAlpha(String name) {
    char[] chars = name.toCharArray();

    for (char c : chars) {
        if(!Character.isLetter(c)) {
            return false;
        }
    }

    return true;
}
    public boolean isfloat(String f){
        try{
            float a=Float.parseFloat(f);
            return true;
        }catch(NumberFormatException e){
        return false;}
        
    }
    public boolean isint(String f){
        try{
           int  a=Integer.parseInt(f);
            return true;
        }catch(NumberFormatException e){
        return false;}
        
    }
}
