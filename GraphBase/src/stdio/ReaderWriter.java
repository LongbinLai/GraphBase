package stdio;
import graph.Edge;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class ReaderWriter {

  public Collection<Edge> read(String fileName) throws IOException {
    Collection<Edge> edgeCollection = new HashSet<>();
    File file = new File(fileName);
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String edgeInformation = null;
      int fromId = 0;
      int toId = 0;
      while ((edgeInformation = reader.readLine()) != null) {
        if (edgeInformation.charAt(0) == '#' || edgeInformation.isEmpty()) {
          continue;
        }
        int split = 0;
        for (split = 0; split < edgeInformation.length(); split++) {
          if (edgeInformation.charAt(split) == ',') {
            break;
          }
        }
        fromId = Integer.valueOf(edgeInformation.substring(0, split)).intValue();
        toId = Integer.valueOf(edgeInformation.substring(split + 1)).intValue();
        Edge edge = new Edge(fromId, toId);
        edgeCollection.add(edge);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e1) {
        }
      }
    }
    return edgeCollection;
  }

}


