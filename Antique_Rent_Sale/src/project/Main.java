package project;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    public static void PrintMenu(String[] Options){
        System.out.println("What would you liked to do?");
        System.out.println("OPTIONS:");
        for (String Option : Options){
            System.out.println(Option);
        }
        System.out.print("Your choice: ");
    }

    public static void main(String[] args) {

        // Construct Tree
        Tree AntiqueTree = new Tree("Antiques");

        // Default Items
        LinkedList<Object> Necklace = new LinkedList<Object>();
        Necklace.add("Necklace");
        Necklace.add(25);
        Necklace.add("History: Jewelry that wraps around the neck and shoulders like a collar; Crafted with red, yellow, blue and green glazed tiles. Top row of fruit, middle row of palm leaves and lower row of lotus flower petals. The jewelery with the connection ends in the form of a lotus flower and unearthed from a tomb in Amarna, dates back to BC. It is estimated to date back to 1380-1350 years.");
        Necklace.add("FOR SALE");
        LinkedList<Object> Bracelet = new LinkedList<Object>();
        Bracelet.add("Bracelet");
        Bracelet.add(15);
        Bracelet.add("History: Gold bracelet, seven centimeters high, decorated with a griffin, lion figures and floral motifs. In this bracelet, which has a characteristic Egyptian jewelery technique; ornamental stones cut to form figures are attached to the pattern slots.");
        Bracelet.add("FOR SALE");
        LinkedList<Object> Earring = new LinkedList<Object>();
        Earring.add("Earring");
        Earring.add(8);
        Earring.add("History: Spiral earring pendulums are of two types. In the examples called omega form; the upper loop is short and the lower ends turn upward after crossing. In the samples constituting the second type in spiral earring pendulums; The earring ring is long and the ends that turn upward after crossing at the bottom are short.");
        Earring.add("FOR SALE");
        LinkedList<Object> Watch = new LinkedList<Object>();
        Watch.add("Watch");
        Watch.add(216);
        Watch.add("History: Zenith watches, which have been part of numerous challenges throughout its 150-year history, started when Jacot, a 22-year-old young man, decided to establish his own watch factory in Le Locle, a small town near Neuchâtel in Switzerland. Incorporating skillful masters, Georges Favre-Jacot never compromises on the elements of courage, originality and pleasure, known as the core values of the brand.");
        Watch.add("FOR SALE");
        LinkedList<Object> Gramophone = new LinkedList<Object>();
        Gramophone.add("Gramophone");
        Gramophone.add(1266);
        Gramophone.add("History: Berliner worked with Elridge Johnson to develop the playback machine. Johnson patented a spring motor for the Berliner gramophone. The motor rotated the turntable at even speed, eliminating the need to manually crank the gramophone. The “Master's Voice” brand was transferred to Johnson by Emile Berliner. Johnson began pressing the Victor record catalogs, and later on the labels of the discs. Soon, \"His Master's Voice\" became one of the best-known brands in the world and is still used today.");
        Gramophone.add("FOR SALE");
        LinkedList<Object> Painting = new LinkedList<Object>();
        Painting.add("Painting");
        Painting.add(578);
        Painting.add("History: 'The Creation of Adam', one of the most important works of Michelangelo, who defines himself as a sculptor, is about the great separation in the creation myth and the story of God and Adam, who are only as close as fingertips, but so separated. In the scene where God breathes life into Adam in Christianity, the index fingers touching each other refer to the fact that God created Adam in his own image.");
        Painting.add("FOR SALE");

        // Populate Tree
        AntiqueTree.AddCategory("Jewelry");
        AntiqueTree.AddItem("Jewelry", Necklace);
        AntiqueTree.AddItem("Jewelry", Bracelet);
        AntiqueTree.AddItem("Jewelry", Earring);
        AntiqueTree.AddItem("Jewelry", Watch);

        AntiqueTree.AddCategory("Furniture");
        AntiqueTree.AddItem("Furniture", Gramophone);
        AntiqueTree.AddItem("Furniture", Painting);

        // Start User Input
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Antique items loaded!");

        // Current Options
        String[] Options = {
                "1 - List all available antiques",
                "2 - Add a new antique category",
                "3 - Add a new item to the category of your choice",
                "4 - Get information about an item",
                "5 - Buy an item",
                "6 - Rent an item",
                "7 - Exit",
        };

        // Console Menu Loop
        int Option = 1;
        while (Option != 4){
            PrintMenu(Options);
            try {
                Option = Scanner.nextInt();
                Scanner.nextLine();
                switch (Option){
                    case 1: {
                        AntiqueTree.ListTree();
                        break;
                    }
                    case 2: {
                        try {
                            System.out.print("Category name: ");
                            String CategoryName = Scanner.nextLine();
                            AntiqueTree.AddCategory(CategoryName);
                        } catch (Exception Exception){
                            System.out.println("Not a valid name, going back to menu.");
                        }
                        break;
                    }
                    case 3: {
                        try {
                            System.out.print("Item name: ");
                            String ItemName = Scanner.nextLine();
                            System.out.print("Item cost: ");
                            int ItemCost = Scanner.nextInt();
                            Scanner.nextLine();
                            System.out.print("Item history: ");
                            String ItemHistory = Scanner.nextLine();
                            System.out.print("Category name: ");
                            String CategoryName = Scanner.nextLine();
                            LinkedList<Object> Item = new LinkedList<Object>();
                            Item.add(ItemName);
                            Item.add(ItemCost);
                            Item.add(ItemHistory);
                            AntiqueTree.AddItem(CategoryName, Item);
                        } catch (Exception Exception){
                            System.out.println("ERROR");
                        }
                        break;
                    }
                    case 4: {
                        try {
                            System.out.print("Item name: ");
                            String ItemName = Scanner.nextLine();
                            LinkedList TargetItem = AntiqueTree.FindItem(ItemName);
                            System.out.println("Name: " + TargetItem.get(0));
                            System.out.println("Cost: " + TargetItem.get(1));
                            System.out.println("History: " + TargetItem.get(2));
                            System.out.println("Status: " + TargetItem.get(3));
                        } catch (Exception Exception){
                            System.out.println("ERROR");
                        }
                        break;
                    }
                    case 5: {
                        try {
                            System.out.print("Item name: ");
                            String ItemName = Scanner.nextLine();
                            LinkedList TargetItem = AntiqueTree.FindItem(ItemName);
                            if (TargetItem.getLast().equals("FOR SALE")) {
                                System.out.println(TargetItem.getFirst() + " bought!");
                                TargetItem.removeLast();
                                TargetItem.addLast("SOLD");
                            } else if (TargetItem.getLast().equals("SOLD")) {
                                System.out.println("Item already sold!");
                            } else {
                                System.out.println("Item already rented!");
                            }

                        } catch (Exception Exception){
                            System.out.println("ERROR");
                        }
                        break;
                    }
                    case 6: {
                        try {
                            System.out.print("Item name: ");
                            String ItemName = Scanner.nextLine();
                            System.out.print("Rental length: ");
                            int RentalLength = Scanner.nextInt();
                            Scanner.nextLine();
                            LinkedList TargetItem = AntiqueTree.FindItem(ItemName);
                            if (TargetItem.getLast().equals("FOR SALE")) {
                                System.out.println(TargetItem.getFirst() + " rented for " + RentalLength + " days!");
                                TargetItem.removeLast();
                                TargetItem.addLast("RENTED FOR " + RentalLength + " DAYS");
                            } else if (TargetItem.getLast().equals("SOLD")) {
                                System.out.println("Item already bought!");
                            } else {
                                System.out.println("Item already rented!");
                            }
                        } catch (Exception Exception){
                            System.out.println("ERROR");
                        }
                        break;
                    }
                    case 7: System.exit(0);
                }
            }
            catch (Exception Exception){
                System.out.println("Please enter an integer value between 1 and " + Options.length + ".");
                Scanner.next();
            }
        }
    }
}