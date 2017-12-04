public class Fraction {
    //FIELDS
    private int numerator;
    private int denominator;

    //CONSTRUCTORS
    public Fraction(int num, int den){
        if (den == 0) {
            throw new IllegalArgumentException("Denominator can't be zero.");
        } else if (den < 0) {
            den *=-1;
            num *=-1;
        }
        this.numerator = num;
        this.denominator = den;
    }

    public Fraction (int num){
        this(num,1);
    }

    public Fraction(){
        this(0,1);
    }

    //METHODS
    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public String toString(){
        if ((this.numerator == 0) || (this.denominator == 1)) {
            return String.valueOf(this.numerator);
        } else {
            return String.valueOf(this.numerator)+"/"+String.valueOf(this.denominator);
        }
    }

    public double toDouble(){
        return numerator/denominator;
    }

    public Fraction add(Fraction other){
        int resultNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int resultDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(resultNumerator, resultDenominator);
        result.toLowestTerms();
        return result;
    }

    public Fraction subtract(Fraction other){
        int resultNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int resultDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(resultNumerator, resultDenominator);
        result.toLowestTerms();
        return result;
    }

    public Fraction multiply(Fraction other){
        int resultNumerator = this.numerator * other.numerator;
        int resultDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(resultNumerator, resultDenominator);
        result.toLowestTerms();
        return result;
    }

    public Fraction divide(Fraction other){
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Can't divide by zero.");
        } else {
            int resultNumerator = this.numerator * other.denominator;
            int resultDenominator = this.denominator * other.numerator;
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            result.toLowestTerms();
            return result;
        }
    }

    public boolean equals(Object obj){
        if (obj instanceof Fraction) {
            this.toLowestTerms();
            ((Fraction) obj).toLowestTerms();
            return (this.numerator == ((Fraction) obj).numerator) && (this.denominator == ((Fraction) obj).denominator);
        } else {
            return false;
        }
    }

    private void toLowestTerms() {
        int numerator = this.numerator;
        int denominator = this.denominator;
        this.numerator /= gcd(numerator,denominator);
        this.denominator /= gcd(numerator,denominator);
        if (this.denominator < 0) {
            this.denominator *=-1;
            this.numerator *=-1;
        }
    }

    public static int gcd(int a, int b){
        int reminder;
        if (a == 0) return 1;
        while ((a != 0) && (b != 0)) {
            reminder = a % b;
            a = b;
            b = reminder;
        }
        return a;
    }

}
