void print_int(int);
void print_bool(bool);
void print_char(char);

class Point {
public:
  int x;
  int y;

  // Default-Konstruktor: ohne Initialisierungsliste, Felder im Body setzen
  Point() { x = 0; y = 0; }

  // Parametrisierter Konstruktor
  Point(int a, int b) { x = a; y = b; }

  int sum() { return x + y; }
};

int main() {
  Point p;            // Default-Konstruktor
  print_int(p.sum()); // 0

  Point q = Point(3, 4); // Parametrisierter Konstruktor
  print_int(q.sum());    // 7

  // Konstruktions-Initialisierung bei lokaler Deklaration (zugelassen, da nicht-leere Arg-Liste)
  Point r = Point(10, -2);
  print_int(r.sum()); // 8

  return 0;
}
/* EXPECT (Zeile für Zeile):
0
7
8
*/
