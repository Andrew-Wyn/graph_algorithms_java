all: compile run clean

compile:
	@echo "######## COMPILING ..."
	javac -d class com/dfs/*.java
	@echo "######## DONE! \n"

run:
	@echo "######## RUNNING ..."
	java -cp class/ com.dfs.Dfs
	@echo "######## DONE! \n"

clean:
	@echo "######## CLEANING ..."
	rm -r class/com/dfs/*
	rmdir --ignore-fail-on-non-empty class/com/dfs/ class/com/
	@echo "######## DONE! \n"
	
