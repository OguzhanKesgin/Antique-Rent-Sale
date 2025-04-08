package project;
import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
    private Node Root = null;
    private ArrayList<String> Categories = null;

    Tree(String Name) {
        this.Root = new Node(Name);
        this.Categories = new ArrayList<String>();
    }

    public void AddCategory(String Name) {
        this.Root.AddChild(Name);
    }

    public void AddItem(String CategoryName, LinkedList ItemToAdd) {
        this.Root.FindCategory(CategoryName).AddChild(ItemToAdd);
    }

    public void ListTree() {
        //this.Root.PrintTree();
        this.Root.Traverse(this.Root);
    }

    public LinkedList FindItem(String Name) {
        return this.Root.FindItem(Name);
    }
}