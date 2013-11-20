//Justin Strauss
//HW28
//pd08
//2013-11-19

public class Rational implements Comparable{

    // Phase I

    private int p; // numerator
    private int q; // denominator

    public Rational() {
        p = 0;
        q = 1;
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
         System.out.println("This denominator is invalid.");
               p = 0;
         q = 1;
        }
        else {
         p = numerator;
         q = denominator;
        }
    }

    public int getP() { return p; }
    public int getQ() { return q; }
    // accessor methods

    public String toString() {
        return "" + p + "/" + q;
    }

    public double floatValue() {
        return (1.0*p)/q;
    }

    public void multiply(Rational object) {
        p *= object.getP();
        q *= object.getQ();
    }

    public void divide(Rational object) {
	if (object.getP() != 0) {
        p /= object.getP();
        q /= object.getQ();
	}
	else {
	    System.out.println("Error!");
	}
    }

    // Phase II

    public void add(Rational object) {
        p = (p*object.getQ()) + (q*object.getP());
        q *= object.getQ();
    }

    public void subtract(Rational object) {
        p = (p*object.getQ()) - (q*object.getP());
        q *= object.getQ();
    }

    public int gcd() {
        int maxnum = Math.max(p,q);
        int minnum = Math.min(p,q);
        while ((maxnum % minnum) != 0) {
         int oldminnum = minnum;
         minnum = (maxnum % minnum);
        }
        return minnum;
    }

    public void reduce() {
        int thegcd = gcd(p,q);
        p /= thegcd;
        q /= thegcd;
    }

    // Phase III

    public static int gcd(int p, int q) {
        int maxnum = Math.max(p,q);
        int minnum = Math.min(p,q);
        while ((maxnum % minnum) != 0) {
         int oldminnum = minnum;
         minnum = (maxnum % minnum);
        }
        return minnum;
    }

    public int compareTo(Object x) {
	if (x instanceof Rational) {
	    int thisNum = p*((Rational) x).getQ();
	    int thatNum = q*((Rational) x).getP();
	    return thatNum - thisNum;
	}
	else {
	    System.out.println("Error!");
	    return 0;
	}
    }

    public boolean equals(Rational object) {
	return (this.floatValue() == object.floatValue());
    }

    // Driver

    public static void main(String[] args) {

        Rational r = new Rational(2,3); //Stores the rational number 2/3
        Rational s = new Rational(1,2); //Stores the rational number 1/2
        System.out.println("\ninitial value of r: " + r);
        System.out.println("initial value of s: " + s);

        r.add(s); //Adds r to s, changes r to 7/6. s remains 1/2
        System.out.println("\nAfter adding s to r, r becomes: " + r);
        r.subtract(s);
        System.out.println("After subtracting s from r, r returns to: " + r);

        r.reduce();
        System.out.println("\nBut this can be reduced back to: " + r);
        System.out.println("This can also be represented as a floating point value: " + r.floatValue());

        r.multiply(s); //Multiplies r by s, changes r to 2/6. s remains ½
        System.out.println("\nAfter multiplying r by s, r becomes: " + r);
        r.divide(s);
        System.out.println("After dividing r by s, r returns to: " + r);

        System.out.println("\nr is greater than s, so a negative integer should be returned: " + r.compareTo(s) + "\n");
    }
}