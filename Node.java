//Hannah Kline
//COS 226
//April 22, 2022

class Node {

    private int data;
    Node left = null, right = null, parent = null;
    public int level;
    public Node(int inData){
      data = inData;
      level = 1;
    }
    int getData(){
      return data;
    }
    void setData(int inData){
      data = inData;
    }

    @Override
    public String toString(){
      return "[" + data + "]";
    }


  }
