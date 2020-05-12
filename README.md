# Web-App-CSE248
Web App Project for CSE248 @ Suffolk County Community College<br>
By Brandon Dabrowski<br>
Presentation of project: https://youtu.be/bPtBRBIZg48 <br>

TECH USED
__________
H2 Database <br>
HTML<br>
CSS<br>
Javascript (kinda)<br>
Java<br>
<br><br>
FUNCTIONALITY
____________
All accounts can change their personaly information, password information, etc.<br><br>

Accounts of three different types can be made: User, Store Owner, and Admin.<br>

USER: <br>
can purchase items from stores, cancel purchases, add/remove/alter payment information. 
They can also view past purchases they have made as well. They also have access to a search bar to find a particular store they may want to buy from.

STOREOWNER: <br>
can create a store, change the stores Name and Tag (descriptor to help the search bar find the store). 
Manage the store by adding/removing items for sale, cancel unwanted user purchases. Can open/close the store to users.

ADMIN:<br>
can view all purchases made across the entire website and cancel them. Can view all store's and their sale history. Can view all users and their information, along with purchase history. Can forcibly close stores.

<br>

IMPROVEMENTS TO BE MADE
_______________________
-Better overall user interface<br>
---in particular, having the menus have more structure. Currently buttons and tables can be inconssistant wether they're aligned with the center of the screen or the left side of the screen. <br>
---Working buttons as opposed to using javascript forms to call java methods to handle all logic (with close/open store buttons being the excpetions)<br>
---Finding a way to reduce the amount of screens between various functions would also help make the website a more tight-knit experience. <br>
<br>
-A search functionailty with room for error. More specifically, one that can parse segments of strings from entries in the database so you don't need to know exact names of stores. <br>
-Images for menu items<br>
-Simplification of the class structure<br>
<br><br>
THE REST
__________
Had a lot of difficulty with this project. Was confusing trying to work between multiple file types and keep everything consistant. Discovering HttpServletRequest and HttpSession saved the entire project. <br><br>
With HttpSession I was able to save temporary objects to the browser session (which to my knowledge couldn't be tampered with) which made distributing data to use either in java methods or on the html pages much easier. 
Unfortunately, I was also under the impression that you could only save strings for a while, which made for lots of repetitive code.
In fact, the entire project could use some cleaning up in that regard, maybe with some static methods to detect proper logins.<br>
<br>
Theres also another issue with how the website currently functions using forms, that all the information you enter can be seen in the url. 
I've read that "tokens" can be used to help with secruity issues, but I was running short on time and had to use what I could to make the project work. 
Theres also no form of encryption at all, not even a basic char++ for each letter in usernames/password, which is pretty bad. <br>
<br>
Theres also a thing where pages are inconssistant with how they handle incorrect form inputs, sometimes loading a new page with red text saying theres an error.
Other times it doesn't have any reaction. <br>
<br>
One major problem occured that resulted in completely redesigning the project.<br>
Not being able to properly take advantage of sub/super classes, for whatever reason (I haven't figured it out yet) had me add a bunch of parameters to the basic Account class and resulted in major restructures.
For example, Account was to be an abstract class with User/StoreOwner/Admin being subclasses of it.
There was also a weird hang up with the Order class, now renamed to Purchase. Order was apparently a reserved word and I didn't know that, so it messed with a lot of stuff.
There was also an issue with CreditCard being the name of a class as well, and thus it had to be changed to PaymentInfo. Never figured out that one, either. <br>

Don't get me started on some of the commit issues I had...! <br>

<br>
Project was fairly consistantly worked on for the past two months, although approx a month was pretty much dedicated to multiple projects for trying to learn what I was doing. 
Many tutorials spun me in circles with things that wouldn't work well with each other, so sifting through those and finding a way to make this work took a while as well. 
This is evident by the commit history, with four folders being dedicated to tutorials (they were removed from the final commit in this repository).
The folder the project was finished in was also a tutorial folder previously, hence the weird name it has. Tried changing it but nothing seemed to work for whatever reason. <br>



