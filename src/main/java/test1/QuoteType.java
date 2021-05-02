package test1;

import java.io.Serializable;

public enum QuoteType {
    SHORT(10), MEDIUM(20), LONG(30);
    int length;
    QuoteType(int i) {length=i;};
    public static QuoteType GetQuoteType(int length){
        //יתר קריא בעיניי
        if (length<10) return SHORT;
        if (length<20) return MEDIUM;
        return LONG;
    }
}
