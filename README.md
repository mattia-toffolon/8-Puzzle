# 8-Puzzle
This program written in Java solves the 8-puzzle problem (and its natural generalizations) using the A* search algorithm.

#### The Problem: 
The 8-puzzle is a sliding puzzle that is played on a 3-by-3 grid with 8 square tiles labeled 1 through 8, plus a blank square. The goal is to rearrange the tiles so that they are sorted by label in row-major order, using as few moves as possible. You are permitted to slide tiles either horizontally or vertically into the blank square. 

#### My Solution: 
Trought the use of the A* search algorithm applied to problem by introducing the Manhattan Distance of each tile of the puzzle i managed to find a solution. The program has also been optimized by avoiding to calculate unnecessary paths and thanks to some minor adjustments. 

#### How to use it: 
After you compiled the *Solver.java* file you will just have to run it specifying whitch puzzle (in the .txt format) has to be solved.\
*Example:* `java Solver puzzle.txt `

For more information check the assigment description ([Progetto DA1 2122.pdf](https://github.com/mattia-toffolon/8-Puzzle/files/8422013/Progetto.DA1.2122.pdf) -*italian*-) or the original source that inspired this project  (https://coursera.cs.princeton.edu/algs4/assignments/8puzzle/specification.php).

(Curricular project for "Dati e Algoritmi 1" course at University of Padova, 2021/2022)
