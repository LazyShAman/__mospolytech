import java.awt.*;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

// класс, реализующий полиэдр
public class Polyedr {
    // массив вершин полиэдра
    // private final
    public static Vertex[] vertexes;

    // массив ребер полиэдра
    // private final
    public static Edge[] edges;

    // массив граней полиэдра
    // private final
    public static Facet[] facets;

    // массив площадей граней полиэдра
    public static double[] areas;

    public Polyedr(String file) throws Exception {
        // исключительная ситуация, возникающая при ошибках
        // чтения или преобразования данных

        RandomAccessFile f = new RandomAccessFile(file, "r");
        StringTokenizer st = new StringTokenizer(f.readLine());

        vertexes = new Vertex[Integer.parseInt(st.nextToken())];
        facets = new Facet[Integer.parseInt(st.nextToken())];
        edges = new Edge[Integer.parseInt(st.nextToken())];

        for (int i = 0; i < vertexes.length; i++) {
            st = new StringTokenizer(f.readLine());

            double x = Double.valueOf(st.nextToken()).doubleValue();
            double y = Double.valueOf(st.nextToken()).doubleValue();
            double z = Double.valueOf(st.nextToken()).doubleValue();

            vertexes[i] = new Vertex(x, y, z);
        }

        int k = 0;
        for (int i = 0; i < facets.length; i++) {
            st = new StringTokenizer(f.readLine());
            int size = Integer.parseInt(st.nextToken());

            Vertex[] facet = new Vertex[size];

            facet[0] = vertexes[Integer.parseInt(st.nextToken()) - 1];
            for (int j = 1; j < size; j += 1) {
                facet[j] = vertexes[Integer.parseInt(st.nextToken()) - 1];
                edges[k++] = new Edge(facet[j], facet[j - 1]);
            }

            edges[k++] = new Edge(facet[size - 1], facet[0]);
            facets[i] = new Facet(facet);
        }
    }

    // получить количество вершин
    public final int getVertexesQuantity() { return vertexes.length; }

    // получить вершину с номером i
    public final Vertex getVertex(int i) { return vertexes[i]; }

    // получить количество ребер
    public final int getEdgesQuantity() { return edges.length; }

    // получить ребро с номером i
    public final Edge getEdge(int i) { return edges[i]; }

    // получить количество граней
    public final int getFacetsQuantity() { return facets.length; }

    // получить грань с номером i
    public final Facet getFacet(int i) { return facets[i]; }

    // найти площади всех граней и записать их в массив
    public void area() {
        areas = new double[getFacetsQuantity()];
        for (int i = 0; i < getFacetsQuantity(); i++) {
            int n = facets[i].getVertexesQuantity();

            double S = 0.;

            // формула площади Гаусса
            for (int k = 0; k < n-1; k++) {
                S += vertexes[k].getX() * vertexes[k+1].getY() -
                     vertexes[k+1].getX() * vertexes[k].getY();
            }
            S += vertexes[n-1].getX() * vertexes[0].getY() -
                 vertexes[0].getX() * vertexes[n-1].getY();
            S = 0.5 * Math.abs(S);

            areas[i] = S;
        }
    }

    // найти по координатам нецелого ребра грань,
    // которой он принадлежит, и обнулить её площадь
    public void findAndDelete(R3Vector a, R3Vector b) {
        int i = -1;
        boolean aFound = false;
        boolean bFound = false;

        while (!(aFound && bFound)) {
            i++;
            aFound = false;
            bFound = false;

            int n = facets[i].getVertexesQuantity();

            for (int k = 0; k < n; k++) {
                if (vertexes[k] == a) aFound = true;
                if (vertexes[k] == b) bFound = true;
            }
        }

        areas[i] = 0;
    }
}
