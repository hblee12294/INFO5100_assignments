

Design a Hangman Game that is played by a user.

When the user plays Hangman, the computer first select a secret word at random from a list built into
the program. The program then prints out a row of dashes - one for each letter in the secret word - and asks
the user to guess a letter. If the user guesses a letter that is int the word, the word is redisplayed with all
instances of that letter shown in the correct positions, along with any letters correctly guesses on precious
turns. If the letter does not appear in the word, the user is charged with an incorrect guess. The user keeps
guessing letters until either
(1) the user has correctly gussed all the letters in the word or 
(2) the user has made eight incorrect guesses.

Hangman comes from the fact that incorrect guesses are recorded by drawing an envolving picure of the 
user being hanged at a scaffold. For each incorrect guess, a new part of a stick-figure body - first the head,
then the body, then each arm, each leg, and finally each foot - is added to the scaffold until the hanging is complete. The hanging should follow this sequence: head, body, left arm, right arm, left leg, right leg, right leg, left foot, right foot.
