package pack2;

import pack1.classA;
public class classB extends classA{
 public void accessClassA() {
 classA a = new classA();
 System.out.println(a.publicVar); // Accessible
 // System.out.println(a.privateVar); // Not accessible
 System.out.println(a.protectedVar); // Accessible through inheritance
 System.out.println(a.defaultVar); // Accessible in the same package
 a.publicMethod(); // Accessible
 // a.privateMethod(); // Not accessible
 a.protectedMethod(); // Accessible through inheritance
 a.defaultMethod(); // Accessible in the same package
 }
}