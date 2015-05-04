# Baseball-Reporter
[![Build Status](https://travis-ci.org/zcs-cs/Baseball-Reporter.svg)](https://travis-ci.org/zcs-cs/Baseball-Reporter)
 <- Click here to see the latest compilation and output results.

The 2014-2015 AP Computer Science A class's final project that analyzes baseball statistics and compiles an automated news report.

##1. Cloning the Baseball-Reporter Repository
To clone this repository, navigate to a directory by using `cd` and use the `git clone` command to clone this repository on to your computer.
```
$ cd C:\Users\My-Username\My-Path

$ git clone https://github.com/zcs-cs/Baseball-Reporter.git
```

##2. Opening in BlueJ
The repository already contains the necessary files to open in BlueJ, and you can open it like you would any other BlueJ project.

##3. Making Changes
You can make changes like you would any other project and Git will keep track of what you have changed. When you wish to push changes to GitHub so others can view, you will need to use `git add`, `git commit`, and `git push`. You will need to have navigated into the `*\Baseball-Reporter` directory by using `cd`
```
$ git add . 

$ git commit -m "Updated CSVConverter to read values as key,value,player,team"

$ git push
```
Note that when pushing, Git will hide your password and will not display how many characters you've entered in your password.

##4. Pulling changes from GitHub
You may wish to pull changes that other developers have pushed to repository. To do this, you will need to use the `git pull` command.
```
$ git pull
```

##Git Quick Reference
###Command reference
| Command | Description |
|:-------:|:-----------:|
|`cd <directory>` | Changes working location to specified directory. May be a subdirectory or an absolute path |
|`git clone <url>` | Clones a git repository at the specified URL |
|`git pull origin master` | Pulls the latest commits from the master branch |
|`git add .`| Stages all changed files |
|`git commit -m "<message>"` | Creates a new commit with message |
|`git push`| Pushes all new local commits to the repository |
