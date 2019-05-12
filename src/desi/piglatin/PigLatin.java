package desi.piglatin;

public class PigLatin {
    private String phrase;
    PigLatin(String phrase) throws InvalidPhraseException {
        if(phrase.matches("^\\s+.*$|^.*\\s+$|.*\\s{2}.*"))
            throw new InvalidPhraseException("No space allow");

        for(String word:phrase.split(" "))
            if(!word.matches("((^([a-z]*)$)|(^([A-Z]{1}([a-z]*)|([A-Z]*))$))?"))
                throw new InvalidPhraseException("Word "+word+" is invalid");

        this.phrase=phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public String translate() {
        String toTranslate = "";
        for(String word:phrase.split((" "))){
            if(word.matches("^[aeiou]{1}[a-z]*$|^xr[a-z]*$|^Xr[a-z]*$|^[AEIOU]{1}[a-z]+$"))
                toTranslate += word + "ay";
            else if(word.matches("^[AEIOU]{1}[A-Z]*$|^XR[A-Z]*$"))
                toTranslate += word + "AY";
            else if(word.matches("^[^aeiouAEIOU]+.*$")){
                    boolean upperFirst = word.matches("^[A-Z]{1}[a-z]+$");
                    String newWord = "";
                    if(upperFirst) word = word.toLowerCase();
                    newWord += word.replaceAll("^([^aeiouAEIOU]+)(.*)$","$2$1");
                    newWord += word.matches("[A-Z]+")?"AY":"ay";
                    toTranslate += upperFirst?newWord.substring(0, 1).toUpperCase() + newWord.substring(1):newWord;
            }
            toTranslate += " ";
        }
        return toTranslate.substring(0,toTranslate.length()-1);
    }
}