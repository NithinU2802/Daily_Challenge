class FindCommon
{

    static void Node_1(Node root, ArrayList<Integer> res){
    if(root==null)
        return;
    res.add(root.data);
    Node_1(root.left,res);
    Node_1(root.right,res);
    }
    
    static void result(Node root, ArrayList<Integer> res,ArrayList<Integer> a){
    if(root==null)
        return;
    if(res.contains(root.data))
        a.add(root.data);
    result(root.left,res,a);
    result(root.right,res,a);
    }
    
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
    ArrayList<Integer> res=new ArrayList<Integer>();
    Node_1(root1,res);
    ArrayList<Integer> a=new ArrayList<Integer>();
    result(root2,res,a);
    Collections.sort(a);
    return a;
    }
}
