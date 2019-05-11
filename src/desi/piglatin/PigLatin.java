package desi.piglatin;

public class PigLatin {
    private String phrase;
    PigLatin(String phrase) throws InvalidPhraseException {
        if(phrase.matches("^\\s+.*$|^.*\\s+$|.*\\s{2}.*"))
            throw new InvalidPhraseException();
        for(String word:phrase.split(" "))
            if(!word.matches("(^[a-zA-Z^\\s+]{1}([a-z^\\s+]*|[A-Z^\\s+]*)$)?"))
                throw new InvalidPhraseException();
        this.phrase=phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public String translate() {
        String toTranslate = "";
        for(String s:phrase.split((" "))){
            if(s.matches("^[aeiou].*$|^xr.*$"))
                toTranslate += s + "ay";
            else if(s.matches("^[AEIOU].*$|^XR.*$"))
                toTranslate += s + "AY";
            else if(s.matches("^[^aeiouAEIOU]+.*$")){
                    boolean upperFirst = false;
                    String word = "";
                    if(s.matches("^[A-Z]{1}[a-z]+$")) {
                        s = s.toLowerCase();
                        upperFirst = true;
                    }
                    word += s.replaceAll("^([^aeiouAEIOU]+)(.*)$","$2$1");
                    word += s.matches("[A-Z]+")?"AY":"ay";
                    toTranslate += upperFirst?word.substring(0, 1).toUpperCase() + word.substring(1):word;
            }
            toTranslate += " ";
        }
        return toTranslate.substring(0,toTranslate.length()-1);
    }
}