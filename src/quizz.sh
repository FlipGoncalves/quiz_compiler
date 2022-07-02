RED="\033[0;31m"
GREEN="\033[0;32m"
NC="\033[0m"

fin=$1;

if ! [[ -r $1 ]]; then
    >&2 echo -e "${RED}Error: input file not found or is not readable.${NC}";
    exit 1;
fi
    
if [[ -z $2 ]]; then
    fout="Output";
else
    fout=$2;
fi

if [[ -r "${fout}.java" ]]; then
    echo -n "File ${fout}.java already exists. Removing... "
    rm "${fout}.java"
    echo -e "${GREEN}DONE${NC}"
fi

antlr4-clean;

echo -n "Building secondary language... "
antlr4 -visitor Secondary.g4;
echo -e "${GREEN}DONE${NC}"

echo -n "Building main language... "
antlr4 -visitor Quizz.g4;
echo -e "${GREEN}DONE${NC}"

echo -n "Compiling the language's java files... "
javac classes/*.java
javac *.java;
echo -e "${GREEN}DONE${NC}"

echo "Compiling the program ${fin} to ${fout}.java"
cat ${fin} | antlr4-java QuizzMain ${fout};

# Compilation error
if [[ $? -ne 0 ]]; then
    echo -e "${RED}Compilation error, aborting compilation of the final program java file.${NC}"
else
    echo -n "Compiling the final program java file... "
    javac ${fout}.java;
    echo -e "${GREEN}DONE${NC}"
fi

