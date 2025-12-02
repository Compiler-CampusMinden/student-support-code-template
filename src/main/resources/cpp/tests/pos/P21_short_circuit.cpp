void print_int(int);
void print_bool(bool);
void print_char(char);

int ping() { print_char('x'); return 1; }

int main() {
    if (false && (ping() == 1)) { print_char('!'); } //

    if (true || (ping() == 1)) { print_char('+'); } // '+'

    return 0;
}
/* EXPECT (Zeile für Zeile):
+
*/
