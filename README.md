# Game-Of-Life
This is a simulation of the Game of Life created by John H. Conway. This is a simulation of the Game of Life created by John H. Conway he simulation runs on a two-dimensional array. Each cell in the array is in one of two states: occupied by a creature or empty.  In this assignment we will populate the initial grid by reading data from a text file.  Once the initial grid has been created, the program loops. Each iteration of the loop represents a tick or time step (in other words, a new generation) in the environment.  Cells interact with their (usually) eight neighbors. Neighbors are the cells that are horizontally, vertically, or diagonally adjacent.  Creatures are created and die based on the following rules:  
1. Any living creature (occupied cell) with fewer than two live neighbors dies of loneliness. 
2. Any living creature with two or three live neighbors lives on to the next generation. 
3. Any living creature with more than three live neighbors dies of overcrowding. 
4. Any empty cell with exactly three live neighbors becomes an occupied cell. This represents a birth.
PS: All births and deaths in each tick occur simultaneously
