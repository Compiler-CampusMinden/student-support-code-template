void print_int(int);
void print_bool(bool);
void print_char(char);

class Counter {
public:
    Counter(int start) { n = start; }
    Counter add(int &delta) {
        n = n + delta;
        delta = n;
        return *this;
    }
    void print() { print_int(n); }
    int n;
};

int main() {
    Counter c(1);
    int step = 2;
    Counter c2 = c.add(step).add(step); // n: 1->3->6, step: 2->3->6
    c.print();       // 3
    c2.print();      // 6
    print_int(step); // 6

    return 0;
}
/* EXPECT:
3
6
6
*/
