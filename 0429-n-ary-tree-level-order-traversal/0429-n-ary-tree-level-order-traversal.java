class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        LinkedList<List<Integer>> res = new LinkedList<>();
        //dont forget edge case
        if(root == null){
            return res;
        }
        
        //use q to store nodes, not the value
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                level.addLast(cur.val);
                for (Node child : cur.children) {
                    q.offer(child);
                }
            }
            res.addLast(level);
        }

        return res;
    }
}
