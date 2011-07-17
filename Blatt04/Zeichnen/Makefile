TARGET = Zeichnen.jar

SRC = $(wildcard *.java)
MAINSRC = Zeichnen.java

$(TARGET): $(SRC)
	@javac $(MAINSRC)
	@echo "Main-Class: Zeichnen" > manifest
	@echo >> manifest
	@jar cfm $(TARGET) manifest *.class
	@rm manifest
	
.PHONY: run
run: $(TARGET)
	@java -jar $(TARGET)
	