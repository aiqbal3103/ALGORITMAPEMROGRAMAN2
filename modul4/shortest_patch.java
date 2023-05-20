package modul4;

public class shortest_patch {
	public static void dijkstraAlgorithm(int[ ][ ] graph, int source) 
	 {
	 int count = graph.length;
	 boolean[ ] visitedVertex = new boolean[count];
	 int[ ] distance = new int[count];
	 for (int i = 0; i < count; i++) 
	 {
	    visitedVertex[i] = false;
	    distance[i] = Integer.MAX_VALUE;
	 }
	 distance[source] = 0;
	 for (int i = 0; i < count; i++) 
	 {
	    int u = findMinDistance(distance, visitedVertex);
	    visitedVertex[u] = true;
	    for (int v = 0; v < count; v++) 
	    {
	        if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) 
	        {
	            distance[v] = distance[u] + graph[u][v];
	        } 
	    }
	 }
	 for (int i = 0; i < distance.length; i++) 
	 {
	    System.out.println(String.format("jarak dari  %s ke  %s adalah %s", source, i, distance[i]));
	 }
	 }
	
	/*Bagian ini menginisialisasi variabel untuk menyimpan informasi terkait jalur terpendek dari source vertex 
	 * ke semua vertex yang lain dalam graf. Variabel-variabel tersebut meliputi "count" untuk menyimpan jumlah 
	 * vertex dalam graf, "visitedVertex" untuk menandai apakah vertex tersebut telah dikunjungi atau belum, 
	 * "distance" untuk menyimpan jarak terpendek dari source vertex ke vertex ke-i dalam graf. Kemudian, 
	 * program menjalankan perulangan untuk menemukan jalur terpendek dengan mengunjungi vertex yang belum 
	 * dikunjungi dan mengupdate jarak terpendek pada vertex yang terhubung ke vertex yang sedang dikunjungi.
	 *  Akhirnya, program mencetak hasil jarak terpendek dari source vertex ke semua vertex lain dalam graf.*/
	 
	 private static int findMinDistance(int[] distance, boolean[] visitedVertex) 
	 {
	 int minDistance = Integer.MAX_VALUE;
	 int minDistanceVertex = -1;
	 for (int i = 0; i < distance.length; i++) 
	 {
	    if (!visitedVertex[i] && distance[i] < minDistance) 
	    {
	        minDistance = distance[i];
	        minDistanceVertex = i;
	    }
	 }
	 return minDistanceVertex;
	 }
	 
	 /*fungsi ini mendeklarasikan variabel minDistance yang memuat nilai jarak minimum awal yang akan dibandingkan
	  *  dengan nilai jarak minimum lainnya. Kemudian, dilakukan looping pada array distance dan visitedVertex untuk 
	  *  mengecek vertex yang belum dikunjungi dan memiliki nilai jarak terpendek. Jika ditemukan vertex dengan jarak 
	  *  terpendek yang lebih kecil dari nilai minDistance saat ini, maka nilai minDistance dan minDistanceVertex akan 
	  *  diperbarui. Setelah looping selesai, fungsi akan mengembalikan indeks vertex dengan jarak terpendek yang belum dikunjungi.*/
	 
	 public static void main(String[ ] args) 
	 {
	 int graph[ ][ ] = new int[ ][ ] { { 0, 6, 0, 0, 7}, 
	                                   { 0, 0, 5, -4, 8}, 
	                                   { 0, -2, 0, 0, 0}, 
	                                   { 0, 0, 7, 0, 0}, 
	                                   { 0, 0, -3, 9, 0}};
	 shortest_patch T = new shortest_patch();
	 shortest_patch.dijkstraAlgorithm(graph, 0);
	 }

}
/* inisialisasi array graph yang merepresentasikan graf dengan bobot pada setiap sisi (edge). 
 *	Selanjutnya, dibuat objek dari kelas shortest_patch dengan menggunakan
 *  konstruktor default (new shortest_patch()). Kemudian, dipanggil method dijkstraAlgorithm dengan parameter graph dan 0. 
 *  Method dijkstraAlgorithm akan menjalankan 
 *  algoritma Dijkstra untuk mencari lintasan terpendek dari simpul dengan indeks 0 ke seluruh simpul lainnya pada graf yang diwakili oleh graph. 
 *  Hasil lintasan
 *   terpendek akan dicetak pada baris-baris terakhir dari method dijkstraAlgorithm.*/