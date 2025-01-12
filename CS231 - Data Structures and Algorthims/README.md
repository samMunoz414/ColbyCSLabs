This README file is intented to outline what each project is about. The projects below are listed in chronological order these projects were completed.

---

**Project 1: Blackjack**  
This project is about developing a simple version of Blackjack. The purpose of this project is to help students become familiar with Java. For this implementation of Blackjack, objects are created for a card, a hand, and a single game of Blackjack. The main structure used to store data are ArrayLists. I constructed two versions of this game. The first, `Two-Player Game of Blackjack`, is a version of Blackjack with only two players. The second version, `Multiplayer Game of Blackjack`, is a version of Blackjack with one dealer and N number of other players such that N > 0.
[Project 1 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab01/assignment.php)  

**Project 2: Conway's Game of Life**  
This project is about implementing [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life). This is done creating a 2D array where each entry in this array represents an individual cell. The main data structure for this project is an array. By default, the behavior of each cell defined in rules of Conway's Game of Life, there are methods in my project that allow the user to modify these rules.  
[Project 2 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab02/assignment.php)  

**Project 3: Sudoku Solver**  
This project is about creating an algorithm that will solve Sudoku games using a depth-first search algorithm. The purpose of this project to use a stack to create this algorithm. The algorithm works by going through each empty entry in the initial state of Sudoku board and populate each entry with some number. If the number entered create a valid new game state, then the algorithm pushes that valid number into the stack and continues to the next entry. For my implementation, the algorithm moves from the bottom to the up, right to left. Otherwise, the algorithm will try a new number. If all number for a given entry do not work, the algorithm backtracks to the previous cell and tries new numbers. A game is unsolvable if the algorithm backtracks to the first empty entry and cannot find a valid value. Otherwise, all other games are solvable.  
[Project 3 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab03/assignment.php)  

**Project 4: Agent-Based Simulations**  
This project is about implementing an agent-based simulation inspired by *Growing Artifical Societies* by Epstein and Axtell. This simulation focuses on how different agents group together given a set of rules for a single type of agent. For example, for social agents, one agent may move randomly across the board if there are less than 3 other social agents near it. Otherwise, the agent does not move. I  For this project, a linked list was used as the main data structure to store the different agents.   
[Project 4 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab04/assignment.php)  

**Project 5: Customer Simulations**  
This project is about simulating checkout lines in a store. This simulation is inspired Mitzenmacher's *The Power of Two Choices in Randomized Load Balancing*. I am determine what is the best strategy to make all lines as quickly as possible. Queues are the main data structures for this project and they are used to emulate check out lines. Then, I measure the time it takes for all customers to get through the check out line. I tested three strategies. The first is when all customers enter the shortest line. The trade off for this strategy is that it takes a long time to determine the shortest checkout line. The second strategy is to select a random checkout line. It takes less time to determine a checkout line to enter, but customers may not choice the best line to enter. Lastly, the final strategy is to select two random lines and enter the shorter line. It takes more time to choice a line for this strategy compared to the preivous option, but does lead customer to choice more optimal lines. I determined that the last strategy is the best strategy to move all customers quickly through the checkout lines.  
[Project 5 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab05/assignment.php)  

**Project 6: Text File Analysis -- Binary Tree**  
This project is about using binary tree to determine the frequency of all words in a text file. The main data structure used in this project is a binary tree and I use this project to determine all word frequency for a given Reddit comments over many different years. At the end of the project, I anaylzed the results of my program.  
[Project 6 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab06/assignment.php)  

**Project 7: Text File Analysis -- Hash Map**  
This project expands on the previous project. In this project, I recreate the preivous project with the exception that I use a hash table to store data. For my implmentation of the project, I use an open addressing algorithm to handle collusions. Then, I compare the performance of this algorithm compared to the algorithm used in the preivous project.  
[Project 7 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab07/assignment.php)  

**Project 8: Find Word Trends -- Priority Queues and Heaps**  
This project is about determine the top most frequent words in a text file. The idea is to use the source code from one of the last two projects and feed its output into this project. Using a heap data structure, I sort out the N most frequent words.  
[Project 8 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab08/assignment.php)  

**Project 9: Hunt the Wumpus**  
This project is about developing a simple version of [Hunt the Wumpus](https://en.wikipedia.org/wiki/Hunt_the_Wumpus). I use graphs (the main data structure of this project) to construct the board which the player and the Wumpus travels on. In the game, the player would be able to smell the Wumpus if the player got close enough to the Wumpus. In game, these rooms that are close to the Wumpus are colored red. I use Dijkstra's algorithm to determine these rooms. The rest of game is implemented by using source code provided in class and using packages from the standard Java library. I also developed an algorithm that allows the program to generate random boards. It works by imagining an MxM board. The only points this board are pairs of integers. Then I randomly select some number of points on the board and place them into a list. Then, for all adject points in the list, I construct a path to those points such that this path does not contain any loops. I also find the path between the first and last point in the list. Those paths form the board for the game.  
[Project 9 Instructions](https://cs.colby.edu/courses/F19/cs231-labs/labs/lab09/assignment.php)  
