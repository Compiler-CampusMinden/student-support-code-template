void print_int(int);
void print_bool(bool);
void print_char(char);

class Base {
public:
  virtual int f() { return 1; }
};

class Der : public Base {
public:
  int f() { return 2; }
};

int main() {
  Der d;
  Base& r = d;
  print_int(r.f());  // 2

  return 0;
}
/* EXPECT (Zeile für Zeile):
2
*/
