/**
 * Maze.java
 *
 * Project 1, part 2. Solve the maze problem with stack and queue.
 *
 */
public class Maze {

    private final char SPACE = '.';
    private final char WALL = '#';
    private final char START = '$';
    private final char END = '%';
    
    /**
     * Finds the path using {@code MyStack}. 
     * Returns the path and number of spaces checked as {@code String}.
     *
     * @param  map a {@code char[][]} provide.
     * @return the path and number of spaces checked as {@code String}
     */

    public String solveWithStack(char[][] map){
        int count = 0;
        MyStack stack = new MyStack();
        stack.push("0 0");
        int i = 0;
        int j  = 0;
        int wall = 0;
        Object curr;
        int dirsplit = 0;
        int [] prev = {i, j};
        String f = "";
        String [] path = new String[map.length * map[0].length];
        String[] c = new String[map.length * map[0].length];
        while (true) {
            if (stack.peek() == "0 0") {
                path[0] = "0 0";
                stack.pop();
                count++;
            }
            //first check for treasure
            //down
            if (i + 1 < map.length) {
                if (map[i + 1][j] == END) {
                    //stack.pop();
                    f = "(" + (i + 1) + "," + j + ")";
                    break;
                }
            }
            //right
            if (j + 1 < map[0].length) {
                if (map[i][j + 1] == END) {
                    f = "(" + (i) + "," + (j + 1) + ")";
                    break;
                }
            }
            //up
            if (i - 1 >= 0) {
                if (map[i - 1][j] == END) {
                    f = "(" + (i - 1) + "," + j + ")";
                    break;
                }
            }
            //left
            if (j - 1 >= 0) {
                if (map[i][j - 1] == END) {
                    f = "(" + (i) + "," + (j - 1) + ")";
                    break;
                }
            }
            //check for spaces
            //down
            wall = 0;
            if (i + 1 < map.length) {
                if (map[i + 1][j] == SPACE && i + 1 != prev[0]) {
                    stack.push(i + 1 + " " + j);
                    wall++;
                }

            }
            //right
            if (j + 1 < map[0].length) {
                if (map[i][j + 1] == SPACE && prev[1] != j + 1) {
                    stack.push(i + " " + (j + 1));
                    wall++;
                }
            }
            //up
            if (i - 1 >= 0) {
                if (map[i - 1][j] == SPACE && prev[0] != i - 1) {
                    stack.push(i - 1 + " " + j);
                    wall++;
                }
            }
            //left
            if (j - 1 >= 0) {
                if (map[i][j - 1] == SPACE && prev[1] != j - 1) {
                    stack.push(i + " " + (j - 1));
                    wall++;
                }
            }
            prev[0] = i;
            prev[1] = j;
            if (dirsplit == 0) {
                if (stack.size() >= 2) {
                    dirsplit = 1;
                    c = path.clone();
                }
            }
            if (wall == 0 && dirsplit == 1) {
                for (int k = 0; k < path.length; k++) {
                    path[k] = c[k];
                }
                dirsplit = 0;
            }
            else if (wall == 0) {
                return "no way";
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
                curr = curr.toString();
                String[] out = ((String) curr).split(" ");
                path[count] = (curr.toString());
                count++;
                i = Integer.parseInt(out[0]);
                j = Integer.parseInt(out[1]);
            }
        }
        int z = 0;
        String toR = "";
        while (z < path.length) {
            if (path[z] == null) {
            }
            else {
                String[] space = path[z].split(" ");
                toR += "(" + space[0] + "," + space[1] + ")";
            }
            z++;

        }
        toR += f;
        toR +=  " " + count;
        return toR;
    }


    /**
     * Finds the path using {@code MyQueue}.
     * Returns the path and number of spaces checked as {@code String}.
     *
     * @param  map a {@code char[][]} provide.
     * @return the path and number of spaces checked as {@code String}
     */
    public String solveWithQueue(char[][] map){
        MyQueue queue = new MyQueue();
        int count = 0;
        queue.enqueue("0 0");
        int i = 0;
        int j  = 0;
        int wall = 0;
        Object curr;
        String f = "";
        String [] path = new String[map.length * map[0].length];
        Node[] soln = new Node[map.length * map[0].length];
        int solcount = 0;
        while (true) {
            if (queue.peek() == "0 0") {
                path[0] = "0 0";
                queue.dequeue();
                Node begin = new Node("0 0", "finished");
                soln[solcount++] = begin;
                count++;
            }
            //first check for treasure
            //down
            if (i + 1 < map.length) {
                if (map[i + 1][j] == END) {
                    f = "(" + (i + 1) + "," + j + ")";
                    Node toadd = new Node((i + 1) + " " + j, i + " " + j);
                    soln[solcount++] = toadd;
                    break;
                }
            }
            //right
            if (j + 1 < map[0].length) {
                if (map[i][j + 1] == END) {
                    f = "(" + (i) + "," + (j + 1) + ")";
                    Node toadd = new Node((i) + " " + (j + 1), i + " " + j);
                    soln[solcount++] = toadd;
                    break;
                }
            }
            //up
            if (i - 1 >= 0) {
                if (map[i - 1][j] == END) {
                    f = "(" + (i - 1) + "," + j + ")";
                    Node toadd = new Node((i - 1) + " " + (j), i + " " + j);
                    soln[solcount++] = toadd;
                    break;
                }
            }
            //left
            if (j - 1 >= 0) {
                if (map[i][j - 1] == END) {
                    f = "(" + (i) + "," + (j - 1) + ")";
                    Node toadd = new Node((i) + " " + (j - 1), i + " " + j);
                    soln[solcount++] = toadd;
                    break;
                }
            }
            //check for spaces
            //down
            wall = 0;
            if (i + 1 < map.length) {
                if (map[i + 1][j] == SPACE) {
                    queue.enqueue(i + 1 + " " + j);
                    map[i + 1][j] = WALL;
                    Node toadd = new Node((i + 1) + " " + (j), i + " " + j);
                    soln[solcount++] = toadd;
                    wall++;
                }

            }
            //right
            if (j + 1 < map[0].length) {
                if (map[i][j + 1] == SPACE) {
                    queue.enqueue(i + " " + (j + 1));
                    map[i][j + 1] = WALL;
                    Node toadd = new Node((i) + " " + (j + 1), i + " " + j);
                    soln[solcount++] = toadd;
                    wall++;
                }
            }
            //up
            if (i - 1 >= 0) {
                if (map[i - 1][j] == SPACE) {
                    queue.enqueue(i - 1 + " " + j);
                    map[i - 1][j] = WALL;
                    Node toadd = new Node((i - 1) + " " + (j), i + " " + j);
                    soln[solcount++] = toadd;
                    wall++;
                }
            }
            //left
            if (j - 1 >= 0) {
                if (map[i][j - 1] == SPACE /*&& prev[1] != j - 1*/) {
                    queue.enqueue(i + " " + (j - 1));
                    map[i][j - 1] = WALL;
                    Node toadd = new Node((i) + " " + (j - 1), i + " " + j);
                    soln[solcount++] = toadd;
                    wall++;
                }
            }
            map[i][j] = WALL;
            if (!queue.isEmpty()) {
                curr = queue.dequeue();
                count++;
                curr = curr.toString();
                String[] out = ((String) curr).split(" ");
                path[count - 1] = (curr.toString());
                i = Integer.parseInt(out[0]);
                j = Integer.parseInt(out[1]);
            }
            else {
                if (wall == 0) {
                    return "no way";
                }
            }
        }
        int t = solcount;
        int s = solcount - 1;
        String ranswer = "";
        while (true) {
            if (soln[t] != null) {
                if (soln[t].parent.equals("finished")) {
                    String[] loc = soln[t].location.split(" ");
                    ranswer += "(" + loc[0] + "," + loc[1] + ") ";
                    break;
                }
                if (soln[t].parent.equals(soln[s].location)) {
                    String[] loc = soln[t].location.split(" ");
                    ranswer += "(" + loc[0] + "," + loc[1] + ") ";
                    t = s;
                    s--;
                }
                else {
                    s--;
                }
            }
            else {
                t--;
            }
        }
        int z = 0;
        String toR = "";
        String [] didit = ranswer.split(" ");
        for (int k = didit.length - 1; k >= 0; k--) {
            toR += didit[k];
        }
        toR +=  " " + count;
        return toR;
    }
}

