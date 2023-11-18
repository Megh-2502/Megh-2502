package pack1;

public class classA {
 public int publicVar = 1;
 private int privateVar = 2;
 protected int protectedVar = 3;
 int defaultVar = 4;
 public void publicMethod() {
 System.out.println("ClassA: public method");
 }
 private void privateMethod() {
 System.out.println("ClassA: private method");
 }
 protected void protectedMethod() {
 System.out.println("ClassA: protected method");
 }
 void defaultMethod() {
 System.out.println("ClassA: default method");
 }
}