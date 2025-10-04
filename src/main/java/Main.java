import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import my.pkg.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String... args) throws IOException, URISyntaxException {
    System.out.println(new Main().getGreeting());

    String input = "2 + 8 * 2;";

    HelloLexer lexer = new HelloLexer(CharStreams.fromString(input));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    HelloParser parser = new HelloParser(tokens);

    ParseTree tree = parser.start(); // Start-Regel
    System.out.println(tree.toStringTree(parser));

    String input2 = "42 * 8 + 2;";

    HelloPackageLexer lexer2 = new HelloPackageLexer(CharStreams.fromString(input2));
    CommonTokenStream tokens2 = new CommonTokenStream(lexer2);
    HelloPackageParser parser2 = new HelloPackageParser(tokens2);

    ParseTree tree2 = parser2.start(); // Start-Regel
    System.out.println(tree2.toStringTree(parser2));

    // Einlesen über den Classpath
    try (InputStream in = Main.class.getResourceAsStream("/cpp/vars.cpp")) {
      String text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
      System.out.println("\n\n/cpp/vars.cpp");
      System.out.println(text);
    }

    // Einlesen über Dateisystem
    URL url = Main.class.getResource("/cpp/expr.cpp");
    String txt = Files.readString(Path.of(url.toURI()), StandardCharsets.UTF_8);
    System.out.println("\n\n/cpp/expr.cpp");
    System.out.println(txt);
  }
}
