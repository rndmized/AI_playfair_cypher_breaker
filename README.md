# AI Playfair Cypher Breaker

Project for Artificial Intelligence Software Development Module (4th Year, Bsc (Hons) in Software Development)

## Project Overview and Requirements

The field of cryptanalysis is concerned with the study of ciphers, having as its objective the identification of weaknesses within a cryptographic system that may be exploited to convert encrypted data (cipher-text) into unencrypted data (plain-text). Whether using symmetric or asymmetric techniques, cryptanalysis assumes no knowledge of the correct cryptographic key or even the cryptographic algorithm being used.
Assuming that the cryptographic algorithm is known, a common approach for breaking a cipher is to generate a large number of keys, decrypt a cipher-text with each key and then examine the resultant plain-text. If the text looks similar to English, then the chances are that the key is a good one. The similarity of a given piece of text to English can be computed by breaking the text into fixed-length substrings, called n-grams, and then comparing each substring to an existing map of n-grams and their frequency. This process does not guarantee that the outputted answer will be the correct plain-text, but can give a good approximation that may well be the right answer.
You are required to use the simulated annealing algorithm to break a Playfair Cipher. 

Your application should have the following minimal set of features:

* A menu-driven command line UI that enables a cipher-text source to be specified (a file or URL) and an output destination file for decrypted plain-text.
* Decrypt cipher-text with a simulated annealing algorithm that uses a log-probability and n-gram statistics as a heuristic evaluation function.

<p align="right" bold>
<i>Source: Project Description</i>
</p>

## About PlayFair Cipher.

The Playfair cipher or Playfair square or Wheatstone-Playfair cipher is a manual symmetric encryption technique and was the first literal digram substitution cipher. The scheme was invented in 1854 by Charles Wheatstone, but bears the name of Lord Playfair for promoting its use.

The technique encrypts pairs of letters (bigrams or digrams), instead of single letters as in the simple substitution cipher and rather more complex Vigenère cipher systems then in use. The Playfair is thus significantly harder to break since the frequency analysis used for simple substitution ciphers does not work with it. The frequency analysis of bigrams is possible, but considerably more difficult. With 600 possible bigrams rather than the 26 possible monograms (single symbols, usually letters in this context), a considerably larger cipher text is required in order to be useful.

<p align="right" bold>
<i>Source: <a href="https://en.wikipedia.org/wiki/Playfair_cipher">Wikipedia</a></i>
</p>

The Playfair Cipher is a symmetric polygram substitution cipher invented by the Victorian scientist Sir Charles Wheatstone in 1854 (of Wheatstone Bridge fame). The cipher is named after his colleague Lord Playfair, who popularised and promoted the encryption system. Due to its simplicity, the Playfair Cipher was used at a tactical level by both the British and US forces during WWII and is also notable for its role in the rescue of the crew of PT-109 in the Pacific
in 1943.

Polygram substitution is a classical system of encryption in which a group of n plain-text letters is replaced as a unit by n cipher-text letters. In the simplest case, where n = 2, the system is called digraphic and each letter pair is replaced by a cipher digraph. The Playfair Cipher uses digraphs to encrypt and decrypt from a 5x5 matrix

<p align="right" bold>
<i>Source: Project Description</i>
</p>

## Simulated Annealing

Simulated annealing (SA) is a probabilistic technique for approximating the global optimum of a given function. Specifically, it is a metaheuristic to approximate global optimization in a large search space. It is often used when the search space is discrete (e.g., all tours that visit a given set of cities). For problems where finding an approximate global optimum is more important than finding a precise local optimum in a fixed amount of time, simulated annealing may be preferable to alternatives such as gradient descent.

<p align="right" bold>
<i>Source: <a href="https://en.wikipedia.org/wiki/Simulated_annealing">Wikipedia</a></i>
</p>

There are certain optimization problems that become unmanageable using combinatorial methods as the number of objects becomes large. A typical example is the traveling salesman problem, which belongs to the NP-complete class of problems. For these problems, there is a very effective practical algorithm called simulated annealing (thus named because it mimics the process undergone by misplaced atoms in a metal when its heated and then slowly cooled). While this technique is unlikely to find the optimum solution, it can often find a very good solution, even in the presence of noisy data. 

<p align="right" bold>
<i>Source: <a href="http://mathworld.wolfram.com/SimulatedAnnealing.html">Wolfram MathWorld</a></i>
</p>

## Using n-grams as Heuristic function

An n-gram (gram = word or letter) is a substring of a word(s) of length n and can be used to
measure how similar some decrypted text is to English. A fitness measure or heuristic score can be computed from the frequency of occurrence of a 4-gram, q, as follows: P(q) = count(q) / n, where n is the total number of 4-grams from a large sample source.

One side effect of multiplying probabilities with very small floating point values is that underflow can occur1 if the exponent becomes too low to be represented. For example, a Java float is a 32-bit IEEE 754 type with a 1-bit sign, an 8-bit exponent and a 23-bit mantissa. The 64-bit IEEE 754 double has a 1-bit sign, a 11-bit exponent and a 52-bit mantissa. A simple way of avoiding this is to get the log (usually base 10) of the probability and use the identity log(a × b) = log(a) + log(b).

<p align="right" bold>
<i>Source: Project Description</i>
</p>


## Installation & Running the code

The code can be run by compiling the code in the src folder into a jar file with  the following command in the console.

```
$: jar –cf playfair.jar ie/gmit/sw/ai/*.class
```

When the jar file is created, it can be run by using the following command:

```
$: java –cp ./playfair.jar ie.gmit.sw.ai.CipherBreaker
```

## Authors

* **Albert Rando** - *Coding* - [rndmized](https://github.com/rndmized)

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/rndmized/functional_programming/blob/master/LICENSE) file for details


## Acknowledgments and References

* References
    * https://github.com/mckennapsean/code-examples/blob/master/Java/Playfair.java
    * https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
    * https://www.mkyong.com/java/how-to-get-file-size-in-java/