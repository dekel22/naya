package test1;

import java.io.Serializable;

public enum QuoteType {
    SHORT(10), MEDIUM(20), LONG(30);
    int length;
    QuoteType(int i) {length=i;};
    public static QuoteType GetQuoteType(int length){
        if (length< SHORT.length) return SHORT;
        if (length< MEDIUM.length) return MEDIUM;
        return LONG;
    }

    public static void main(String[] args) {
        QuoteType a=GetQuoteType(10);
         a=GetQuoteType(20);

    }
}
