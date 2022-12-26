package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class PlaintextToHtmlConverter {
    String source;
    int i;
    List<String> result;
    List<String> convertedLine;
    String characterToConvert;

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get("sample.txt")));
    }

    private String basicHtmlEncode(String source) {
        this.source = source;
        i = 0;
        result = new ArrayList<>();
        convertedLine = new ArrayList<>();
        characterToConvert = GetIndexCharacterAndIncrementPointer();
        String[] symbols = new String[] { "<", ">", "&"};
        String[] htmlSymbols = new String[] { "&lt;", "&gt;", "&amp;"};

        while (i <= this.source.length()) {
            convertedLine.add(MatchCharacter(characterToConvert));
            if (i >= source.length()) break;

            characterToConvert = GetIndexCharacterAndIncrementPointer();
        }
        addANewLine();
        String finalResult = String.join("<br />", result);
        return finalResult;
    }

    private String MatchCharacter(String characterToConvert) {
        String[] symbols = new String[] { "<", ">", "&"};
        String[] htmlSymbols = new String[] { "&lt;", "&gt;", "&amp;"};

        for(int j = 0; j < symbols.length; j++) {
            if (characterToConvert.equals(symbols[j])) {
                return htmlSymbols[j];
            }
        }
        if (characterToConvert.equals("\n")){
            addANewLine();
        }
        else pushACharacterToTheOutput();

        return null;
    }
    private String GetIndexCharacterAndIncrementPointer() {
        char c = source.charAt(i);
        i += 1;
        return String.valueOf(c);
    }
    private void addANewLine() {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private void pushACharacterToTheOutput() {
        convertedLine.add(characterToConvert);
    }
}
