package Day230923;

import java.util.*;



class LockingTree {
    HashMap<Integer, LockNode> map = new HashMap<>();


    public static void main(String[] args) {
        int[] parent = {-1, 0, 3,1,0};
        LockingTree lockingTree = new LockingTree(parent);
        System.out.println(lockingTree.lock(2, 2));
        System.out.println(lockingTree.unlock(2, 3));
        System.out.println(lockingTree.unlock(2, 2));
        System.out.println(lockingTree.lock(4, 5));
        System.out.println(lockingTree.upgrade(0, 1));
        System.out.println(lockingTree.lock(0, 1));
    }

    public LockingTree(int[] parent) {
        for(int i = 0; i < parent.length; i++){
            map.put(i, new LockNode());
        }

        for (int i = 1; i < parent.length; i++) {
            int n = parent[i];
            map.get(n).children.add(i);
            map.get(i).parent = n;
        }
    }

    public boolean lock(int num, int user) {
        if (map.get(num).isLocked) return false;
        map.get(num).isLocked = true;
        map.get(num).user = user;
        return true;
    }


    public boolean unlock(int num, int user) {
        if (!map.get(num).isLocked) return false;
        if (map.get(num).user != user) return false;
        map.get(num).isLocked = false;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (map.get(num).isLocked) return false;

        int parent = map.get(num).parent;
        while (parent != -1 ) {
            if(map.get(parent).isLocked)return false;
            parent= map.get(parent).parent;
        }


        boolean hasLockedChild = false;
        Queue<Integer> queue = new LinkedList<>();
        for (int child : map.get(num).children) queue.offer(child);
        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int child : map.get(c).children) queue.offer(child);
            if (map.get(c).isLocked){
                hasLockedChild = true;
                map.get(c).isLocked =false;
            }
        }

        if (hasLockedChild) lock(num, user);
        return hasLockedChild;
    }

}

class LockNode {
    public boolean isLocked = false;
    public int user = -1;
    public HashSet<Integer> children = new HashSet<>();
    public int parent = -1;

}