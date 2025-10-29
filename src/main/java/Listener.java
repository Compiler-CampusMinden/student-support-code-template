import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Listener {
  static void main(String... args) {
    // result99 = acc_2*ACC_2 + spillover7 + bonus_1*3 + inc_0;
    // calc_42 = __9 * zZ_1 + 5 + FooBar_42 * bar_7 + q0;
    // _ExprLine + A_1 * bB_2 + cc3 * 7 +      11;
    // 2+3*4;

    IO.println("Hello World!");
    String input = IO.readln("expr?> ");

    MyLangLexer lexer = new MyLangLexer(CharStreams.fromString(input));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MyLangParser parser = new MyLangParser(tokens);
    ParseTree tree = parser.start();

    ParseTreeWalker walker = new ParseTreeWalker();
    MyListener eval = new MyListener();
    walker.walk(eval, tree);
  }

  static class MyListener extends MyLangBaseListener {
    public void exitMul(MyLangParser.MulContext ctx) {
      IO.println("exitMul: lhs=" + ctx.lhs.getText() + ", rhs=" + ctx.rhs.getText());
    }

    public void exitAdd(MyLangParser.AddContext ctx) {
      IO.println("exitAdd:  lhs=" + ctx.lhs.getText() + ", rhs=" + ctx.rhs.getText());
    }

    public void exitNumber(MyLangParser.NumberContext ctx) {
      IO.println("exitNumber: NUM=" + ctx.NUM().getText());
    }
  }
}
