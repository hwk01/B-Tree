//Hannah Kline
//COS 226

class Bucket{

  public Node[] arrayOfNodes; //max_degree

  public Bucket[] arrayOfBuckets; //max_degree

  Bucket parent = null;

  int size;
  int maxsize;


//defaults of a bucket
  Bucket(int max_degree){
    maxsize = max_degree;
    size = 0;
    arrayOfNodes = new Node[max_degree];
    arrayOfBuckets = new Bucket[max_degree+1];
  }



//this is for the print function
@Override
public String toString(){

  String Together = new String();
  for(int i = 0; i < size; i++){
    Together = Together + arrayOfNodes[i].toString();
  }
  return Together;
}




}
