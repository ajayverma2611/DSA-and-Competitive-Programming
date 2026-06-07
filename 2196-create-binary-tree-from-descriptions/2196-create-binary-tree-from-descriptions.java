import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] d) {
        int n = d.length;

        HashMap<Integer, ArrayList<Pair<Integer, Integer>>> mp = new HashMap<>();
        HashMap<Integer, TreeNode> p = new HashMap<>();

        for (int i = 0; i < n; i++) {

            p.putIfAbsent(d[i][1], new TreeNode(d[i][1]));

            if (mp.containsKey(d[i][0])) {
                mp.get(d[i][0]).add(new Pair<>(d[i][1], d[i][2]));
            } else {
                ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
                list.add(new Pair<>(d[i][1], d[i][2]));
                mp.put(d[i][0], list);
            }
        }

        TreeNode par = null;

        for (int i = 0; i < n; i++) {
            if (!p.containsKey(d[i][0])) {
                par = new TreeNode(d[i][0]);
                p.put(d[i][0], par);
                break;
            }
        }

        for (Map.Entry<Integer, ArrayList<Pair<Integer, Integer>>> entry : mp.entrySet()) {

            TreeNode parentNode = p.get(entry.getKey());

            for (Pair<Integer, Integer> t : entry.getValue()) {

                TreeNode childNode = p.get(t.getKey());

                if (t.getValue() == 1) {
                    parentNode.left = childNode;
                } else {
                    parentNode.right = childNode;
                }
            }
        }

        return par;
    }
}