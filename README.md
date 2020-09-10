# BarShelf
- Allows user to : 
  - have virtual barshelf 
  - Find cocktails 
- See detailed recipes
- Fully responsive for mobile, tablet and computer.
- Utilizes Spring Framework and Java backend 
- With a clean frontend 
- Full CRUD functionality

## User Stories
1.	As a	User	I want to	search for an ingredient	so that	I can find the cocktails I can make
2.	As a	User	I want to	be able to find non-alcoholic drinks	so that	I can find non-alcoholic recipes
3.	As a	User	I want to	be able to find alcoholic drinks	so that	I can find alcoholic recipes
4.	As a	User	I want to	see cocktails that can be made from an ingredient	so that	I can see which cocktails I can make
5.	As a	User	I want to	be able to open each cocktail 	so that	I can see more details about the cocktail
6.	As a	User	I want to	see a clean view of cocktails	so that	I can find which cocktail I want easily
7.	As a	User	I want to	be able to login	so that	I can see my barshelf
8.	As a	User	I want to	be able to enter my email	so that	I can see my barshelf
9.	As a	User	I want to	be able to enter my password	so that	I can see my barshelf
10.	As a	User	I want to	be able to create an account	so that	I can access pages only for registered users
11.	As a	User	I want to	be able to enter my email	so that	I can access pages only for registered users
12.	As a	User	I want to	be able to enter my password	so that	I can access pages only for registered users
13.	As a	User	I want to	be able to enter my name	so that	I can access pages only for registered users
14.	As a	User	I want to	be able to see if cocktail is alcoholic	so that	I know if it has alcohol in it
15.	As a	User	I want to	be able to see how to make it	so that	I know the directions to making the recipe
16.	As a	User	I want to	have a bigger image	so that	I know how it is supposed to look
17.	As a	User	I want to	see detailed ingredients with measures	so that	I know how much to put 
18.	As a	User	I want to	have a virtual barshelf	so that	so I can quickly see which ingredients I have/want
19.	As a	User	I want to	be able to quickly see what cocktail the ingredient makes	so that	so that I know what cocktails I can make with my virtual barshelf
20.	As a	User	I want to	delete a ingredient	so that	I can remove clutter from my barshelf


## Technical Challenges 

Problem |	Solution
--------|----------
How to get data	| Used api cocktaildb
Get cocktaildb into rdbms? |	Use json parser to upload the data
Flex box not centering items |	Refactored with cssgrid
How to use repositories |	Missing one class appcontext
How to use buttons to add items to a list |	Ised ajax to send a post request onclick()
How to send info with anchor tag |	Sent info along with the link 
Can't retrieve session attribute | from mav	Use modelmap instead of model and view

## Features 

### Landing Page

![alt text](https://i.imgur.com/2hIAa9M.png)
<br/>
- Landing page for barshelf
- Has search box
- Has non-alcoholic filter
- Initially finds cocktails for user


### Home Page
![alt text](https://i.imgur.com/EaGjl7q.png)
<br/>
- Display cocktails user can make
- Stores ingredient in session to revisit 
- Allows to open more detailed view of cocktail


### Cocktail Display Page
![alt text](https://i.imgur.com/257qELJ.png)
<br/>
- Display additional information like:
  - Alcoholic or not
  - Instructions on how to make
  - A bigger image to see cocktail more clearly
  - Ingredients with measures 
- Adds buttons to add ingredient to your barshelf

### My BarShelf
![alt text](https://i.imgur.com/kmp07X0.png)
<br/>
- Once logged in, the user can maintain their barshelf. 
- User has quick access to possible cocktails
- Can add or delete any ingredient
- Includes image of ingredient

### Responsive NavBar <br/>
![alt text](https://i.imgur.com/vWRMnmG.png)
<br/>
- Collapses into hamburger
- Expands on click 

