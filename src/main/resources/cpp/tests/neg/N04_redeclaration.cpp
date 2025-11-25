int main() {
    char c = 'c';
    char &cc = c;

    // Re-Definition darf nicht akzeptiert werden
    char &c = cc;

    return 0;
}
