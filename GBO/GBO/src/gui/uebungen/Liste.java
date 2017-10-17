package gui.uebungen;

import java.util.ArrayList;

interface L
{
    void forEach(L l);
}

public class Liste implements L
{
    private L l2;

    // private static Liste list = new Liste();

    private static ArrayList<L> list2 = new ArrayList<L>();

    public Liste(L l2)
    {
        this.l2 = l2;
    }

    public void add(L addList)
    {
        list2.add(addList);
    }

    @Override
    public void forEach(L l)
    {
        list2.forEach(e -> System.out.println(e));
        // System.out.println("test");
    }

    public static void main(String[] args)
    {
        // list2.forEach(e -> System.out.println(e));
    }

}