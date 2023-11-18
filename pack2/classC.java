package pack2;
import pack1.classA;
public class classC extends classA {
 public void accessClassA() {
 System.out.println(publicVar); // Accessible
 // System.out.println(privateVar); // Not accessible
 System.out.println(protectedVar); // Accessible through inheritance
 System.out.println(defaultVar); // Not accessible in a different package
 publicMethod(); // Accessible
 // privateMethod(); // Not accessible
 protectedMethod(); // Accessible through inheritance
 defaultMethod(); // Not accessible in a different package
 }
}
