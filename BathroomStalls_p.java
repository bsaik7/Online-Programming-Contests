import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BathroomStalls_p {

	public static void main(String[] args) {

		int T = readTestCases();
		solve(T);

	}
	
	private static int readTestCases() {
		int testCases = StdIn.readInt();
		return testCases;
	}
	
	private static void solve(int T){
		for(int t = 1 ; t <= T ; t++){
			long N = StdIn.readLong();
			long K = StdIn.readLong();
			TreeMap<Long, String> tmap = new TreeMap<Long, String>();
			tmap.put((long) 1, "");
			tmap.put(N + 2, "");
			long l = tmap.firstKey();
			long r = tmap.lastKey();
			long Ls = Long.MIN_VALUE;
			long Rs = Long.MIN_VALUE;
			for(int i = 1 ; i <= K ; i++){
				long diff = Long.MIN_VALUE;
				Set set = tmap.entrySet();
				Iterator iterator = set.iterator();
				long firstKey = tmap.firstKey();
				long lastKey = tmap.lastKey();
				long n = firstKey;
				while(iterator.hasNext()){
					Map.Entry mentry = (Map.Entry)iterator.next();
					long m = (long) mentry.getKey();
					//StdOut.println("m or key = " + m + " n = " + n);
					if(m == firstKey || m == lastKey)
						continue;
					if((m - n > diff)){
						diff = m - n;
						//StdOut.println("m = " + m + " n = " + n + " diff = " + diff);
						l = tmap.lowerKey(m);
						r = m;
					}
					n = m;
				}
				if((lastKey - n) > diff){
					l = n;
					r = lastKey;
				}
				long mid = l + ( r - l ) / 2;
				//StdOut.println("l = " + l + " r = " + r + " mid = " + mid);
				tmap.put(mid, "");
				Ls = mid - l - 1;
				Rs = r - mid - 1;
				//StdOut.println("Ls = " + Ls + " Rs = " + Rs);
			}
			StdOut.println("Case #" + t + ": " + Math.max(Ls, Rs) + " " + Math.min(Ls, Rs));
		}
	}

}


final class StdIn {
 
    private StdIn() { }
 
    private static Scanner scanner;
    
    private static final String CHARSET_NAME = "UTF-8";
 
    private static final Locale LOCALE = Locale.US;
 
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
 
    private static final Pattern EMPTY_PATTERN = Pattern.compile("");
 
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
 
    public static boolean isEmpty() {
        return !scanner.hasNext();
    }
 
    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }
 
    public static boolean hasNextChar() {
        scanner.useDelimiter(EMPTY_PATTERN);
        boolean result = scanner.hasNext();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }
 
    public static String readLine() {
        String line;
        try                 { line = scanner.nextLine(); }
        catch (Exception e) { line = null;               }
        return line;
    }
 
    public static char readChar() {
        scanner.useDelimiter(EMPTY_PATTERN);
        String ch = scanner.next();
        assert (ch.length() == 1) : "Internal (Std)In.readChar() error!"
            + " Please contact the authors.";
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return ch.charAt(0);
    }  
 
 
    public static String readAll() {
        if (!scanner.hasNextLine())
            return "";
 
        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        // not that important to reset delimeter, since now scanner is empty
        scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
        return result;
    }
 
    public static String readString() {
        return scanner.next();
    }
 
    public static int readInt() {
        return scanner.nextInt();
    }
 
    public static double readDouble() {
        return scanner.nextDouble();
    }
 
    public static float readFloat() {
        return scanner.nextFloat();
    }
 
    public static long readLong() {
        return scanner.nextLong();
    }
    
    public static short readShort() {
        return scanner.nextShort();
    }
 
    public static byte readByte() {
        return scanner.nextByte();
    }
 
    public static boolean readBoolean() {
        String s = readString();
        if (s.equalsIgnoreCase("true"))  return true;
        if (s.equalsIgnoreCase("false")) return false;
        if (s.equals("1"))               return true;
        if (s.equals("0"))               return false;
        throw new InputMismatchException();
    }
 
    public static String[] readAllStrings() {
        // we could use readAll.trim().split(), but that's not consistent
        // because trim() uses characters 0x00..0x20 as whitespace
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0)
            return tokens;
 
        // don't include first token if it is leading whitespace
        String[] decapitokens = new String[tokens.length-1];
        for (int i = 0; i < tokens.length - 1; i++)
            decapitokens[i] = tokens[i+1];
        return decapitokens;
    }
 
    public static String[] readAllLines() {
        ArrayList<String> lines = new ArrayList<String>();
        while (hasNextLine()) {
            lines.add(readLine());
        }
        return lines.toArray(new String[0]);
    }
 
    public static int[] readAllInts() {
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Integer.parseInt(fields[i]);
        return vals;
    }
 
    public static double[] readAllDoubles() {
        String[] fields = readAllStrings();
        double[] vals = new double[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Double.parseDouble(fields[i]);
        return vals;
    }
    
    static {
        resync();
    }
 
    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
    }
    
    private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
        StdIn.scanner.useLocale(LOCALE);
    }
 
    public static int[] readInts() {
        return readAllInts();
    }
 
    public static double[] readDoubles() {
        return readAllDoubles();
    }
 
    public static String[] readStrings() {
        return readAllStrings();
    }
 
}

final class StdOut {
 
    private static final String CHARSET_NAME = "UTF-8";
 
    private static final Locale LOCALE = Locale.US;
 
    private static PrintWriter out;
 
    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
        }
        catch (UnsupportedEncodingException e) { System.out.println(e); }
    }
 
    private StdOut() { }
 
    public static void close() {
        out.close();
    }
 
    public static void println() {
        out.println();
    }
 
    public static void println(Object x) {
        out.println(x);
    }
 
    public static void println(boolean x) {
        out.println(x);
    }
 
    public static void println(char x) {
        out.println(x);
    }
 
    public static void println(double x) {
        out.println(x);
    }
 
    public static void println(float x) {
        out.println(x);
    }
 
    public static void println(int x) {
        out.println(x);
    }
 
    public static void println(long x) {
        out.println(x);
    }
 
    public static void println(short x) {
        out.println(x);
    }
 
    public static void println(byte x) {
        out.println(x);
    }
 
    public static void print() {
        out.flush();
    }
 
    public static void print(Object x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(boolean x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(char x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(double x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(float x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(int x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(long x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(short x) {
        out.print(x);
        out.flush();
    }
 
    public static void print(byte x) {
        out.print(x);
        out.flush();
    }
 
    public static void printf(String format, Object... args) {
        out.printf(LOCALE, format, args);
        out.flush();
    }
 
    public static void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }
 
}

