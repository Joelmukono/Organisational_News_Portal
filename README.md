# Organisational_News_Portal

### Description
A restfull api application that allows a user to store and retrieve information from and api about users news and departments related
to users
|Installation|description|
|----------|------------|
|psql < create.sql| create the database|

# Query Api

|Method    |URL    |
|------------|------------------
|GET  all departments  | http://0.0.0.0:4567/departments/all/|
|GET all users|http://0.0.0.0:4567/users/|
|GET all users by id|http://0.0.0.0:4567/user/1/|
|POST new department|http://0.0.0.0:4567/departments/new/ add properties|
|POST new users in department|http://0.0.0.0:4567/department/3/user/new/ add properties|
|GET add departments by id|http://0.0.0.0:4567/department/1/|
|GET all news|http://0.0.0.0:4567/news/all/|
|POST new news|http://0.0.0.0:4567/news/new/ add properties|
|GET news by id|http://0.0.0.0:4567/news/2/|
### AUTHOR
* Joel Mukono

### Technologies used 
* Java (Spark)
* Git for version control
* Postgresql Database


Set Up
## fork repo
- Fork repository
- Create new branch
- Make the proposal
- commit the changes with appropriate message on changes and push
- Create a pull request
## License
MIT License
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
