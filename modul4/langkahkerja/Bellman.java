package modul4.langkahkerja;

public class Bellman {
    int V;
    int E;
    Edge[] edge;

    class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }

    public Bellman(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    void bellmanFord(int src, Bellman graph) {
        int[] distance = new int[V];
        for (int i = 0; i < V; ++i)
            distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;

        for (int i = 0; i < V - 1; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
                    distance[v] = distance[u] + weight;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(distance, V);
    }

    void printArr(int[] distance, int V) {
        System.out.println("Vertex distanceance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + distance[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 10;
        Bellman graph = new Bellman(V, E);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 6;
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 7;
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 8;
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 5;
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = -4;
        graph.edge[5].src = 2;
        graph.edge[5].dest = 3;
        graph.edge[5].weight = -3;
        graph.edge[6].src = 2;
        graph.edge[6].dest = 4;
        graph.edge[6].weight = 9;
        graph.edge[7].src = 3;
        graph.edge[7].dest = 1;
        graph.edge[7].weight = -2;
        graph.edge[8].src = 4;
        graph.edge[8].dest = 0;
        graph.edge[8].weight = 2;
        graph.edge[9].src = 4;
        graph.edge[9].dest = 3;
        graph.edge[9].weight = 7;
        graph.bellmanFord(0);
    }
}

