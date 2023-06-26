package Graphs;




import java.util.*;

public class Graph{


    //graph implementation
    private int V;//visited node
    private LinkedList<Integer> adj[];

    Graph(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i =0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }

    public void addEdge(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);

    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> arr ){
        boolean vis[]=new boolean[V];
        for(int i =0;i<V;i++){
            if(!vis[i]){
                if(DfsHelperTwo(i, vis)){
                    return true;
                }
                
            }
        }
        return false;
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] visited=new boolean[V];
        
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        q.add(0);
        visited[0]=true;
        
        while(!q.isEmpty()){
            int element=q.poll();
            list.add(element);
            
            for(int i : adj.get(element)){
                if(!visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        return list;
    }
    
    public void bfs(int source){

// Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
       Queue<Integer> q=new LinkedList<Integer>();


        //mark current node as visiteda and enqueue it
        visited[source]=true;
        q.add(source);


        while(!q.isEmpty()){
            
            // Dequeue a vertex from queue and print it
            source=q.poll();
            System.out.println(source + "");


            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it

            Iterator<Integer> i=adj[source].listIterator();
            while(i.hasNext()){
                int n=i.next();

                if(!visited[n]){
                    visited[n]=true;
                    q.add(n);
                }
            }

        }
        
        

    }

    public void DfsHelper(int v, boolean visited[]){
        
        //mark current node as visited and print it
        visited[v]=true;
        System.out.println( v + " ");

         // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DfsHelper(n, visited);
        }
    }

    public boolean DfsHelperTwo(int v, boolean visited[]){
        
        //mark current node as visited and print it
        visited[v]=true;
        System.out.println( v + " ");

         // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]){
                DfsHelper(n, visited);
                return true;
            }
        }
        return false;
    }

    public void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper
        // function to print DFS
        // traversal
        DfsHelperTwo(v, visited);
    }

    //Count all possible paths between two vertices
// all paths from 'u' to 'd'.
    public int countAllPathHelper(int s, int d, int pathCount){ 


        // If current vertex is same as
        // destination, then increment count
        if(s == d){
            pathCount++;
        }

        //recur for all the vertices adjacent to this vertex
        else{
            Iterator<Integer> i=adj[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                pathCount=countAllPathHelper(n, d, pathCount);
            }
        }

        return pathCount;
    }


     // Returns count of
    // paths from 's' to 'd'
    int countAllPaths(int s, int d)
    {
 
        // Call the recursive method
        // to count all paths
        int pathCount = 0;
        pathCount = countAllPathHelper(s, d, pathCount);
        return pathCount;
    }
 

    

    public static void main(String[] args){
        
       
        Graph g=new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("BFS TRAVERSAL FROM VERTEX 1");

        g.bfs(2);


        System.out.println("DFS TRAVERSAL FROM VERTEX 1");

        g.DFS(2);


        
        

        

        


    }

    
}
