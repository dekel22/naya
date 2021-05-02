package test1;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class QuoteInfo implements java.io.Serializable{
    private String text;
    private int id;
    private QuoteType quoteType;
    QuoteInfo(String text, int id){
        this.text=text;
        this.id=id;
        int wordsCount =text.split(" ").length;
        this.quoteType=QuoteType.GetQuoteType(wordsCount);

    }

}
