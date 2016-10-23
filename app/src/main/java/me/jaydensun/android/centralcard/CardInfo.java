package me.jaydensun.android.centralcard;

public class CardInfo {
    public String name, cardNumber, exp1, exp2, cvv;

    public CardInfo() {

    }

    public CardInfo(String a, String b, String c, String d, String e) {
        name = a;
        cardNumber = b;
        exp1 = c;
        exp2 = d;
        cvv = e;
    }
}
