package desi.piglatin;

import org.junit.Test;

import static org.junit.Assert.*;

public class PigLatinTest {

    @Test
    public void testPhrase() throws InvalidPhraseException {
        PigLatin pigLatin = new PigLatin("a yellow bird");
        String phrase = pigLatin.getPhrase();
        assertEquals("a yellow bird",phrase);
    }

    @Test(expected = InvalidPhraseException.class)
    public void testPhraseInvalidDoubleSpace() throws InvalidPhraseException {
        new PigLatin("a  yellow bird");
    }

    @Test(expected = InvalidPhraseException.class)
    public void testPhraseInvalidSpaceAtBegin() throws InvalidPhraseException {
        new PigLatin(" a yellow bird");
    }

    @Test(expected = InvalidPhraseException.class)
    public void testPhraseInvalidSpaceAtEnd() throws InvalidPhraseException {
        new PigLatin("a yellow bird ");
    }

    @Test(expected = InvalidPhraseException.class)
    public void testInvalidComma() throws InvalidPhraseException {
        new PigLatin("a, yellow bird");
    }

    @Test
    public void testTranslateStartWithA() throws InvalidPhraseException {
        PigLatin p = new PigLatin("apple");
        assertEquals("appleay",p.translate());
    }
    @Test
    public void testTranslateStartWithE() throws InvalidPhraseException {
        PigLatin p = new PigLatin("entity");
        assertEquals("entityay",p.translate());
    }
    @Test
    public void testTranslateStartWithI() throws InvalidPhraseException {
        PigLatin p = new PigLatin("ionic");
        assertEquals("ionicay",p.translate());
    }
    @Test
    public void testTranslateStartWithO() throws InvalidPhraseException {
        PigLatin p = new PigLatin("orange");
        assertEquals("orangeay",p.translate());
    }

    @Test
    public void testTranslateStartWithU() throws  InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("umbrella");
        assertEquals("umbrellaay", pigLatin.translate());
    }

    @Test
    public void testTranslateStartWithB() throws InvalidPhraseException {
        PigLatin p = new PigLatin("banana");
        assertEquals("ananabay",p.translate());
    }
    @Test
    public void testTranslateStartWithG() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("game");
        assertEquals("amegay", pigLatin.translate());
    }
    @Test
    public void testTranslateStartWithY() throws InvalidPhraseException {
        PigLatin p = new PigLatin("yellow");
        assertEquals("ellowyay",p.translate());
    }

    @Test
    public void testTranslateStartWithZ() throws InvalidPhraseException {
        PigLatin p = new PigLatin("zebra");
        assertEquals("ebrazay",p.translate());
    }

    @Test
    public void testTranslatePhrase() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("a yellow bird");
        assertEquals("aay ellowyay irdbay", pigLatin.translate());
    }

    @Test
    public void testTranslateStartWithCh() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("chair");
        assertEquals("airchay",pigLatin.translate());
    }

    @Test
    public void testTranslateStartWithTh() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("the");
        assertEquals("ethay",pigLatin.translate());

    }

    @Test
    public void testTranslateStartWithThr() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("thread");
        assertEquals("eadthray",pigLatin.translate());

    }

    @Test
    public void testTranslateStartWithSch() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("schrodinger");
        assertEquals("odingerschray",pigLatin.translate());
    }

    @Test
    public void testTranslateStartWithXr() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("xray");
        assertEquals("xrayay",pigLatin.translate());
    }

    @Test
    public void testTranslateStartWithCapitalXr() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("XRAY");
        assertEquals("XRAYAY",pigLatin.translate());
    }


    @Test
    public void testTranslateKeepFirstCharUpperCase() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("Bird");
        assertEquals("Irdbay",pigLatin.translate());
    }

    @Test
    public void testTranslateEmptyString() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("");
        assertEquals("",pigLatin.translate());
    }

    @Test
    public void testTranslateUpperCaseVolwes() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("APPLE");
        assertEquals("APPLEAY",pigLatin.translate());
    }

    @Test
    public void testTranslateSingleUpplerLetter() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("D");
        assertEquals("DAY",pigLatin.translate());
    }

    @Test
    public void testTranslateUpperCaseNoVolwes() throws InvalidPhraseException{
        PigLatin pigLatin = new PigLatin("BANANA");
        assertEquals("ANANABAY",pigLatin.translate());
    }

    @Test(expected = InvalidPhraseException.class)
    public void testPhraseInvalidStartWithNumber() throws InvalidPhraseException{
        new PigLatin("1 yellow bird");
    }

    @Test(expected = InvalidPhraseException.class)
    public void testPhraseInvalidContainANumber() throws InvalidPhraseException{
        new PigLatin("b1rd");
    }

    @Test(expected = InvalidPhraseException.class)
    public void testPhraseInvalidUpperCase() throws InvalidPhraseException{
        new PigLatin("biRd");
    }

    @Test(expected = InvalidPhraseException.class)
    public void testPhraseInvalidUpperCase2() throws InvalidPhraseException{
        new PigLatin("a yelloW bird");
    }

    @Test(expected = InvalidPhraseException.class)
    public void testPhraseInvalidUpperCase3() throws InvalidPhraseException{
        new PigLatin("BiRd");
    }

    @Test(expected=InvalidPhraseException.class)
    public void testPhraseInvalidJustASpace() throws Exception{
        new PigLatin(" ");
    }

}