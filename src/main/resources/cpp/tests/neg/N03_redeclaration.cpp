int main() {
    int b = 42;
    int &bb = b;

    // Re-Definition darf nicht akzeptiert werden
    int &b = bb;

    return 0;
}
