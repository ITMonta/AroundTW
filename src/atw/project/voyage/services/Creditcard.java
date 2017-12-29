/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atw.project.voyage.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Monta
 */
 

public class Creditcard {
  private long CardNumb;
    private int CVV;
    private Date expirationDate;

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public Creditcard(long CardNumb, int CVV, Date expirationDate) {
        this.CardNumb = CardNumb;
        this.CVV = CVV;
        this.expirationDate = expirationDate;
    }

    public Creditcard() {
    }

    public long getCardNumb() {
        return CardNumb;
    }

    public void setCardNumb(long CardNumb) {
        this.CardNumb = CardNumb;
    }

  
   


    public boolean isValid(Creditcard Card) {
DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();
System.out.println(dateFormat.format(date));

        int total;
        int sum1;
        int sum2;
        sum1 = sumOfOddPlaces(Card.getCardNumb());
        sum2 = sumOfOddPlaces((Card.getCardNumb() / 10));
        total = sum1 + sum2;
        if ((total % 10 == 0)/*&& (getSize(Card.CardNumb)==16)/*&&(date.before(Card.getExpirationDate()))&&&&(getSize(Card.CVV)==3)*/)
        {    return true; }
        else return false;
        
    }

    public  int getDigit(int number) {

        if (number <= 9) {

            return number;

        } else if (number > 9) {
            return (number % 10 + number / 10);
        }

        return number;

    }

    public int sumOfOddPlaces(long number) {

        int sum = 0;

        while (number != 0) {

            sum += getDigit((int) (2 * (number % 10)));

            number = number / 100;

        }

        System.out.println(sum);

        return sum;

    }

    public int getSize(long number) {

        int len = 1;

        while (number >= 10) {

            number /= 10;

            len++;

        }

        return len;

    }

}
