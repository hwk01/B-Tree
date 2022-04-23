//Hannah Kline
//COS 226
//April 22, 2022

class BTree{

  int max_degree = 5;
  Bucket root = null;


 public BTree(int max_degree){
    this.max_degree = max_degree;

 }

  public BTree(){

 }

//the insert function adds the actual node into its correct spot
 public boolean insert(Node n, Bucket b, Bucket s){
   int insert_index = 0;

    for(insert_index = 0; insert_index < max_degree; insert_index++){
      if(s.arrayOfNodes[insert_index] == null || s.arrayOfNodes[insert_index].getData() > n.getData())
      break;
    }
  //  System.out.println("about to insert at " + insert_index);

    if(s.arrayOfNodes[insert_index] != null){
     for(int j = max_degree - 2; j >= insert_index; j--){
      // System.out.println("MOVING " + j + " to " + (j+1));
       s.arrayOfNodes[j+1] = s.arrayOfNodes[j];
       s.arrayOfBuckets[j+2] = s.arrayOfBuckets[j+1];

     }
}
     s.arrayOfNodes[insert_index] = n;
     s.arrayOfBuckets[insert_index+1] = b;
     if(b !=null) b.parent = s;


   s.size = s.size + 1;
   if(s.size == s.maxsize) return true;
   return false;
}




//the add function sets up to call insert
  public void add(int data){
    Node n = new Node(data);
    if(root == null){
      root = new Bucket(max_degree);
      insert(n,null,root); //insert(root,n);
    //  System.out.println("Created new root");
      return;

    }

    Bucket where = search_for_bucket(root,data);

    boolean flag = insert(n,null,where);

    if(flag){
      split(where);
    }
      //    split(where);
      //    where = where.parent;


}




//search_for_bucket finds the correct place to insert
Bucket search_for_bucket(Bucket start,int value) {

  if (start.arrayOfBuckets[0] == null) return start;

  for(int i = 0; i < max_degree ; i++){
  //  System.out.println("printing");
    if(start.arrayOfNodes[i] == null) return search_for_bucket(start.arrayOfBuckets[i],value);

    if (value < start.arrayOfNodes[i].getData()) return search_for_bucket(start.arrayOfBuckets[i],value);

    if (start.arrayOfBuckets[i] != null) return search_for_bucket(start.arrayOfBuckets[i],value);

    else return start;
  }
  return search_for_bucket(start.arrayOfBuckets[max_degree],value);


}

//prints out tree
  public void print(Bucket p){
    if (p == null) return;

    System.out.println(p);

    for(int i = 0; i <= max_degree ; i++){
      print(p.arrayOfBuckets[i]);

    }

  }

//prints out tree
public void printTree(){
  print(root);
}



//split separates the buckets when needed(Full) and balances them by shuffling around
  void split(Bucket b){

      int mid = max_degree/2;
      Bucket other_b = new Bucket(max_degree);
      //copies to new bucket
      b.size = mid;
      other_b.size = (max_degree-mid-1);

      int i;
      for(i = 0; i < (max_degree - mid - 1); i++){
          other_b.arrayOfNodes[i] = b.arrayOfNodes[mid+i+1];
          b.arrayOfNodes[mid+i+1] = null;

          other_b.arrayOfBuckets[i] = b.arrayOfBuckets[mid+i+1];
          b.arrayOfBuckets[mid+i+1] = null;

          if(other_b.arrayOfBuckets[i] != null) other_b.arrayOfBuckets[i].parent = other_b;

    }


        other_b.arrayOfBuckets[i] = b.arrayOfBuckets[max_degree];
        b.arrayOfBuckets[max_degree] = null;
        if(other_b.arrayOfBuckets[i] != null) other_b.arrayOfBuckets[i].parent = other_b;




      if(b.parent == null){
        root = new Bucket(max_degree);
        root.arrayOfBuckets[0] = b;       //to set the parent
        b.parent = root;
        other_b.parent = root;
        root.arrayOfBuckets[1] = other_b;
        root.size = 0;

      }

      boolean flag = insert(b.arrayOfNodes[mid],other_b,b.parent);
      b.arrayOfNodes[mid] = null;



      if(!flag) return;
      if(flag){
         split(b.parent);
      }


    //  if(!b.CheckIfSplit()) break;
}


}
