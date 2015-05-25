if [ $(uname -o) = "Msys" ]; then
	javac -cp ".;+libs/json.jar" BaseballReporter.java
	java -cp ".;+libs/json.jar" BaseballReporter
elif [ $(uname -o) = "GNU/Linux" ]; then
	echo Linux
fi;
