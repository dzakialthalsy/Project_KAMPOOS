public class S {
    private S() {}
    public static void clear() {  
      System.out.print("\033[H\033[2J");  
      System.out.flush();  
    }
    public static void move(int x, int y) {
      System.out.print(String.format("%c[%d;%df",0x1B,y,x));
    }
    public static void print(String s, int x, int y) {
      S.move(x, y);
      System.out.print(s);
    }
    public static void delay(int ms) {
      try { Thread.sleep(ms); }
      catch(Exception e) {}
    }
}