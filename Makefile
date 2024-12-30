
all: compile

compile:
	javac -d build src/*.java

run: compile
	java -cp build Main

clean:
	rm -rf build/*
