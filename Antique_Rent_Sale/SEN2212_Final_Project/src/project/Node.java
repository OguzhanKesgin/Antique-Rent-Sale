package project;
import java.util.LinkedList;

public class Node<Tree> {
    private Tree Value;
    private Node[] Children = new Node[100];
    private int ChildCount = 0;

    Node(Tree Value) {
        this.Value = Value;
    }

    public Node AddChild(Tree Value) {
        Node NewChild = new Node(Value);
        Children[ChildCount++] = NewChild;
        return NewChild;
    }

    static void Traverse(Node Object) {
        if (Object != null) {
            for (int Index = 0; Index < Object.ChildCount; Index++) {
                if (Object.Children[Index].Value instanceof LinkedList<?>) {
                    LinkedList<?> List = (LinkedList<?>) Object.Children[Index].Value;
                    System.out.println("[" + List.get(0) + ", " + List.get(1) + ", " + List.get(3) + "]");
                } else {
                    System.out.println(Object.Children[Index].Value);
                }
                Traverse(Object.Children[Index]);
            }
        }
        return;
    }

    public void PrintTree() {
        System.out.println(this.Value);
        this.Traverse(this);
    }

    public Node FindCategory(String Name) {
        for (int Index = 0; Index < this.ChildCount; Index++) {
            if (this.Children[Index].Value.equals(Name)) {
                return this.Children[Index];
            }
        }
        return null;
    }

    public LinkedList FindItem(String Name) {
        for (int Index = 0; Index < this.ChildCount; Index++) {
            if (this.Children[Index].Value instanceof LinkedList<?>) {
                if (((LinkedList<?>) this.Children[Index].Value).getFirst().equals(Name)) {
                    return (LinkedList) this.Children[Index].Value;
                }
            }else {
                for (int Index2 = 0; Index2 < this.Children[Index].ChildCount; Index2++) {
                    if (this.Children[Index].Children[Index2].Value instanceof LinkedList<?>) {
                        if (((LinkedList<?>) this.Children[Index].Children[Index2].Value).getFirst().equals(Name)) {
                            return (LinkedList) this.Children[Index].Children[Index2].Value;
                        }
                    }
                }
            }
        }
        return null;
    }
}