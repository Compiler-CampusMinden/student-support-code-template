import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class PatternMatching {
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
    MyLangParser.StartContext tree = parser.start();

    exec(tree);
  }

  static void exec(MyLangParser.StartContext start) {
    for (var s : start.stmt()) {
      switch (s) {
        case MyLangParser.AssignContext a ->
            IO.println("Stmt.Assign: id=" + a.id.getText() + ", value=" + a.value.getText());
        case MyLangParser.ExprStmtContext e -> {
          IO.println("Stmt.ExprStmt: expr=" + e.expr().getText());
          eval(e.expr());
        }
        default ->
            throw new IllegalStateException("Unhandled stmt: " + s.getClass().getSimpleName());
      }
    }
  }

  static void eval(MyLangParser.ExprContext e) {
    switch (e) {
      case MyLangParser.MulContext m -> {
        IO.println("Expr.Mul: lhs=" + m.lhs.getText() + ", rhs=" + m.rhs.getText());
        eval(m.lhs);
        eval(m.rhs);
      }
      case MyLangParser.AddContext a -> {
        IO.println("Expr.Add: lhs=" + a.lhs.getText() + ", rhs=" + a.rhs.getText());
        eval(a.lhs);
        eval(a.rhs);
      }
      case MyLangParser.NameContext n -> IO.println("Expr.Name: ID=" + n.ID().getText());
      case MyLangParser.NumberContext n -> IO.println("Expr.Number: NUM=" + n.NUM().getText());
      default -> throw new IllegalStateException("Unhandled expr: " + e.getClass().getSimpleName());
    }
  }
}
