void print_int(int);
void print_bool(bool);
void print_char(char);


class B {
public:     // es reicht, wenn alles public ist (hier nur, damit das Beispiel mit g++ kompiliert)
    B() { value = 0; }
    B(int x) { value = x; }
    B(B& rhs) { value = rhs.value; }
    B& operator=(B& rhs) {  // Zuweisung ist der einzige notwendige Operator
        value = rhs.value;
        return *this;       // "this" und "*this" sollen im Klassenkontext erkannt werden
    }

    int value;
};


int main() {
    // Klasse mit selbst implementierten C'toren und Zuweisung
    print_char('B');        // 'B'

    B x;
    x.value = 9;
    print_int(x.value);     // 9

    B y(x);
    print_int(x.value);     // 9
    print_int(y.value);     // 9

    y.value = 7;
    print_int(x.value);     // 9
    print_int(y.value);     // 7

    B z = y;
    print_int(x.value);     // 9
    print_int(y.value);     // 7
    print_int(z.value);     // 7

    B foo;
    foo = z;
    z.value = 99;
    print_int(foo.value);   // 7
    print_int(z.value);     // 99

    return 0;
}
/* EXPECT:
B
9
9
9
9
7
9
7
7
7
99
*/
