# PigLatin

⦁	A language game, such as Pig Latin, alters spoken words to make them incomprehensible to the untrained ear. Write a program to prompt the user for an English word and then translate the word into Pig Latin, as follows: the initial consonants are moved from the front of the word to the end and the letters “ay” are then added to the end. Thus “meal” becomes “eal-may”, “scram” becomes “am-scray”, and “java” becomes “ava-jay”. If a word begins with a vowel, them the Pig Latin is just the word followed by “ay”. Thus “am” becomes “am-ay”. Use the JOptionPane class for getting input from the user and displaying output to the user.
Then, revise this program to allow the user to enter a short sentence, and display the Pig Latin translation of the entire sentence. Hint: use the String method split (on the inputLine returned) which returns an array of strings: String [ ] words = inputLine.split(“\\s”); note: the regex \\s matches any whitespace character.
