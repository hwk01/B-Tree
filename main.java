//Hannah Kline
//COS 226
//This is the main file for a B tree

import java.util.Scanner;


class main{


//needs Node.java Bucket.java and BTree.java to run
public static void main(String[]args){
  //max degree is set by user input (defaut = 5)
  System.out.println("enter max degree");
  Scanner scan = new Scanner(System.in);
  int max = scan.nextInt();
  BTree x = new BTree(max);

  System.out.println("Max degree is " + max);
  System.out.println("\n");

// adding numbers to b tree (x)
  x.add(12);
  x.add(22);
  x.add(14);
  x.add(2);
  x.add(32);
  x.add(90);
  x.add(100);
  x.add(99);
  x.add(10);


  x.printTree();








}



}
