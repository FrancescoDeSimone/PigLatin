# PigLatin
From [wikipedia](https://en.wikipedia.org/wiki/Pig_Latin):
> Pig Latin is a language game or argot in which words in English are altered, usually by adding a fabricated suffix or by moving the onset or initial consonant or consonant cluster of a word to the end of the word and adding a vocalic syllable to create such a suffix

I wrote my version for univeristy course Software Dependability. The assignment is focussed on software testing using TDD metodology. I have followed the TDD methodology and I wrote tests cases to correctly test the different functional requirements of the assignment

## Functional requirements

My Pig Latin version follow this rules:
* A phrase is a string made up by several words split by a single space
* if a word start with a vowel, or it start with xr, the algorithm just append "ay" at the end of the word
* if the word begins with a consonant or a cluster of consonant the algorithm just swap all the first consonant at the end of the word and add "ay"
* the algorithm allow all caps word (e.g. "APPLE"), all lower case word (e.g. "apple") and title case word (e.g. "Apple"), otherwise the word is rejected (e.g. "AppLe");
* Title case input are kept intact, the first transform letter remain in uppercase ("Bird" -> "Irdbay")
