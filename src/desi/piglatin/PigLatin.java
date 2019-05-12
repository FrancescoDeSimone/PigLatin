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
        String translate = "";
        for(String word:phrase.split((" "))){
            if(word.matches("^[aeiou]{1}[a-z]*$|^xr[a-z]*$|^Xr[a-z]*$|^[AEIOU]{1}[a-z]+$"))
                translate += word + "ay";
            else if(word.matches("^[AEIOU]{1}[A-Z]*$|^XR[A-Z]*$"))
                translate += word + "AY";
            else if(word.matches("^[^aeiouAEIOU]+.*$")){
                    boolean titleCase = word.matches("^[A-Z]{1}[a-z]+$");
                    String newWord = ((titleCase) ?
                        word.toLowerCase().replaceAll("^([^aeiou]+)(.*)$","$2$1ay"):
                        word.replaceAll("^([^aeiouAEIOU]+)(.*)$","$2$1") + (word.matches("[A-Z]+")?"AY":"ay"));
                translate += titleCase?newWord.substring(0, 1).toUpperCase() + newWord.substring(1):newWord;
            }
            translate += " ";
        }
        return translate.substring(0,translate.length()-1);
    }
}