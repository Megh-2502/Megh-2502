import pack1.classA;
import pack2.classB;
import pack2.classC;
public class megh {
    public static void main(String[] args) {
        pack1.classA a = new pack1.classA();
        System.out.println(a.publicVar); // Accessible
        // System.out.println(a.privateVar); // Not accessible
        System.out.println(a.protectedVar); // Accessible in the same package
        System.out.println(a.defaultVar); // Accessible in the same package
        a.publicMethod(); // Accessible
        // a.privateMethod(); // Not accessible
        a.protectedMethod(); // Accessible in the same package
        a.defaultMethod(); // Accessible in the same package
        pack2.classB b = new pack2.classB();
        b.accessClassA(); // Accessing ClassA members from ClassB
        pack2.classC c = new pack2.classC();
        c.accessClassA(); // Accessing ClassA members from ClassC
        }
}
