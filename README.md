# Baseball-Reporter
[![Build Status](https://travis-ci.org/zcs-cs/Baseball-Reporter.svg)](https://travis-ci.org/zcs-cs/Baseball-Reporter)
 <- Click here to see the latest compilation and output results.

The 2014-2015 AP Computer Science A class's final project that analyzes baseball statistics and compiles an automated news report.

##Compilation instructions
This project contains BlueJ project files and can be compiled from within BlueJ.

To do so from command line, run the following commands from the root directory of this repository:
```
javac Program.java
java Program
```

Program can take 1 argument that is a path to a .csv file to pull the data from: `java Program data/baseball.csv`

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

###To clone this repository
Navigate to a directory using `cd` and execute `git clone https://github.com/zcs-cs/Baseball-Reporter.git`

```
$ cd C:/Users/Elliot/Development

$ git clone https://github.com/zcs-cs/Baseball-Reporter.git

$ cd Baseball-Reporter
```

###To update the repository from GitHub
You will need to execute from the Baseball-Reporter directory (`.../Baseball-Reporter`):

```
$ git pull
```

###To save and push changes to your module
You will need to execute from the Baseball-Reporter directory (`.../Baseball-Reporter`):

```
$ git commit -m "Updated CSV deserialiation to work with team,player,key,value format"

$ git push
```

Note: Your user password is not displayed when typing it in.