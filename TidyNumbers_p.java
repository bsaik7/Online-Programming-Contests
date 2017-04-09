import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TidyNumbers_p {

		public static void main(String[] args) throws InterruptedException {
			
			int T = readTestCases();
			solve(T);

		}
		
		private static int readTestCases() {
			int testCases = StdIn.readInt();
			return testCases;
		}


		private static void solve(int T) throws InterruptedException {
			for(int t = 1 ; t <= T ; t++){
				long N = StdIn.readLong();
				long l = N;
				String s = Long.toString(N);
				int len = s.length();
				while(true){
					if(isTidy(l)){
						StdOut.println("Case #" + t + ": " + l);
						break;
					}else{
						//StdOut.print(" l = " + l);
						int pos = tidyPos(l);
						//StdOut.print(" pos = " + pos);
						String s1 = Long.toString(l);
						StringBuilder suffix = new StringBuilder();
						for(int su = 1 ; su <= len - (pos + 1) ; su++)
							suffix.append('0');
						//StdOut.print(" suffix = " + suffix.toString());
						StringBuilder final_l = new StringBuilder();
						if(pos == 0){
							final_l.append(s1.charAt(0));
							final_l.append(suffix.toString());
							l = Long.parseLong(final_l.toString()) - 1;
						}else{
							final_l.append(s1.substring(0, pos));
							final_l.append(s1.charAt(pos));
							final_l.append(suffix.toString());
							l = Long.parseLong(final_l.toString()) - 1;
						}
						//StdOut.println(" final_l = " + final_l.toString());
					}
				}
			}
		}
		
		private static int tidyPos(long n){
			String s = Long.toString(n);
			int i = 1;
			while(i < s.length()){
				if(s.charAt(i-1) > s.charAt(i))
					return i-1;
				else
					i++;
			}
			return i;
		}
		
		private static boolean isTidy(long n) throws InterruptedException{
			String s = Long.toString(n);

			for(int i = 0 ; i < s.length() - 1 ; i++)
				if(s.charAt(i) > s.charAt(i+1))
					return false;
			return true;
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

