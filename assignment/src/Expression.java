class a{
    static class b{
        public static Object c;
    }
}

class c{
    static class b{
        public static Object a;
    }
}

public class Expression
{
    public static void main(String[] args)
    {
        a.b.c = c.b.a;
        System.out.println("Completed My task");
    }
}

