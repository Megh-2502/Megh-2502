class Stack
{
    int top,n;
    int[] s;
    Stack(int size)
    {
        this.n=size;
        top=-1;
        s=new int[n];
    }
    void push(int data)
    {
        if(top>=n-1)
        {
            System.out.println("Overflow");
            return;
        }
        s[++top]=data;
        System.out.println("Inserted element is "+s[top]);
        System.out.println();
    }
    void pop()
    {
        if(top==-1)
        {
            System.out.println("Underflow");
            return;
        }
        System.out.println("Deleted element is "+s[top--]);
        System.out.println();
    }
    void peep(int i)
    {
        if(top-i+1<=-1)
        {
            System.out.println("Underflow");
            return;
        }
        System.out.println("element at "+i+"th position is "+s[top-i+1]);
        System.out.println();
    }
    void change(int data,int i)
    {
        if(top-i+1<=-1)
        {
            System.out.println("Underflow");
            return;
        }
        s[top-i+1]=data;
        System.out.println("element at "+i+"th position is "+s[top-i+1]);
        System.out.println();
    }
    void display()
    {
        if(top==-1)
        {
            System.out.println("Empty");
            return;
        }
        System.out.println("Stack:");
        for(int i=top;i>-1;i--)
        {
            System.out.println(s[i]);
        }
        System.out.println();
    }
}
class main{
    public static void main(String[] args) {
        Stack s=new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.display();
        s.pop();
        s.display();
        s.peep(2);
        s.change(50, 2);
        s.display();
    }
}