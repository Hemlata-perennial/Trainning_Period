import java.util.Scanner;

public class BPlusTree {


    BplusTreeNode root = null, np = null, x = null;

    private class BplusTreeNode {
        int[] data;
        BplusTreeNode[] child_ptr;
        boolean leaf;
        int n;
    }



    BplusTreeNode init() {
        int i;
        np = new BplusTreeNode();
        np.data = new int[5];
        np.child_ptr = new BplusTreeNode[6];
        np.leaf = true;
        np.n = 0;
        for (i = 0; i < 6; i++) {
            np.child_ptr[i] = null;
        }
        return np;
    }

    void traverse(BplusTreeNode p) {
        System.out.println();
        int i;
        for (i = 0; i < p.n; i++) {
            if (p.leaf == false) {
                traverse(p.child_ptr[i]);
            }
            System.out.println(p.data[i]);
        }
        if (p.leaf == false) {
            traverse(p.child_ptr[i]);
        }
        System.out.println();
    }

    void sort(int[] p, int n) {
        int i, j, temp;
        for (i = 0; i < n; i++) {
            for (j = i; j <= n; j++) {
                if (p[i] > p[j]) {
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }

    int split_child(BplusTreeNode x, int i) {
        int j, mid;
        BplusTreeNode np1, np3, y;
        np3 = init();
        np3.leaf = true;
        if (i == -1) {
            mid = x.data[2];
            x.data[2] = 0;
            x.n--;
            np1 = init();
            np1.leaf = false;
            x.leaf = true;
            for (j = 3; j < 5; j++) {
                np3.data[j - 3] = x.data[j];
                np3.child_ptr[j - 3] = x.child_ptr[j];
                np3.n++;
                x.data[j] = 0;
                x.n--;
            }
            for (j = 0; j < 6; j++) {
                x.child_ptr[j] = null;
            }
            np1.data[0] = mid;
            np1.child_ptr[np1.n] = x;
            np1.child_ptr[np1.n + 1] = np3;
            np1.n++;
            root = np1;
        } else {
            y = x.child_ptr[i];
            mid = y.data[2];
            y.data[2] = 0;
            y.n--;
            for (j = 3; j < 5; j++) {
                np3.data[j - 3] = y.data[j];
                np3.n++;
                y.data[j] = 0;
                y.n--;
            }
            x.child_ptr[i + 1] = y;
            x.child_ptr[i + 1] = np3;
        }
        return mid;
    }

    void insert(int a) {
        int i, temp;
        x = root;
        if (x == null) {
            root = init();
            x = root;
        } else {
            if (x.leaf == true && x.n == 5) {
                temp = split_child(x, -1);
                x = root;
                for (i = 0; i < (x.n); i++) {
                    if ((a > x.data[i]) && (a < x.data[i + 1])) {
                        i++;
                        break;
                    } else if (a < x.data[0]) {
                        break;
                    } else {
                        continue;
                    }
                }
                x = x.child_ptr[i];
            } else {
                while (x.leaf == false) {
                    for (i = 0; i < (x.n); i++) {
                        if ((a > x.data[i]) && (a < x.data[i + 1])) {
                            i++;
                            break;
                        } else if (a < x.data[0]) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    if ((x.child_ptr[i]).n == 5) {
                        temp = split_child(x, i);
                        x.data[x.n] = temp;
                        x.n++;
                        continue;
                    } else {
                        x = x.child_ptr[i];
                    }
                }
            }
        }
        x.data[x.n] = a;
        sort(x.data, x.n);
        x.n++;
    }

    public static void main(String[] args) {
        int i, n, t;
        System.out.println("enter the no of elements to be inserted\n");
        Scanner s = new Scanner(System.in);
        BPlusTree bp=new BPlusTree();
        n = s.nextInt();
        for (i = 0; i < n; i++) {
            System.out.println("enter element: ");
            t = s.nextInt();
            bp.insert(t);
        }
        System.out.println("traverser of tree: ");

        bp.traverse(bp.root);
        
    }
}